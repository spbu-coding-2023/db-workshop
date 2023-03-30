package me.vkutuev.dbsandbox

import mu.KotlinLogging

import org.neo4j.driver.AuthTokens
import org.neo4j.driver.GraphDatabase
import java.io.Closeable

private val logger = KotlinLogging.logger { }

class Neo4jRepository(uri: String, user: String, password: String) : Closeable {

    private val driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password))
    private val session = driver.session()

    fun addUser(user: User) {
        session.executeWrite { tx ->
            if (user.city != null) {
                tx.run(
                    "CREATE (u:User{name:\$name, phone:\$phone}) " +
                            "MERGE (c:City{name:\$city}) " +
                            "CREATE (u)-[:LIVES_IN]->(c)",
                    mutableMapOf(
                        "name" to user.name,
                        "phone" to user.phone,
                        "city" to user.city.name
                    ) as Map<String, Any>?
                )
            } else {
                tx.run(
                    "CREATE (:User{name:\$name, phone:\$phone})",
                    mapOf(
                        "name" to user.name,
                        "phone" to user.phone
                    )
                )
                logger.info { "User $user added" }
            }
        }
    }

    fun addCity(city: City) {
        session.executeWrite { tx ->
            tx.run(
                "MERGE (:City{name:\$city})",
                mapOf("city" to city.name)
            )
            logger.info { "City $city added" }
        }
    }

    fun getAllUsers(): Iterable<User> = session.executeRead { tx ->
        val result =
            tx.run(
                "MATCH (u:User) OPTIONAL MATCH (u)-->(c) " +
                        "RETURN u.name AS name, u.phone AS phone, c.name AS city"
            )
        logger.info { "Got all users" }
        result.stream().map { rec ->
            val city = rec["city"]
            User(
                rec["name"].asString(),
                rec["phone"].asInt(),
                if (city.isNull) null else City(city.asString())
            )
        }.toList()
    }


    override fun close() {
        session.close()
        driver.close()
    }
}
