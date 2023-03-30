package me.vkutuev.dbsandbox

import mu.KotlinLogging

private val logger = KotlinLogging.logger { }
private const val dbPath = "jdbc_database.db"

fun main() {
    try {
        SqliteRepository(dbPath).use { it ->
            it.createDb()
            it.executeQuery("INSERT INTO users (name, phone, cityId) VALUES ('Vova', 987654, null);")
            val rybinsk = City("Rybinsk")
            it.addCity(rybinsk)
            it.addUser(User("Ann", 630474, rybinsk))

            /*
            Пример на SQL инъекцию:

            read name
            name <- "X', 0); SELECT * FROM 'users'; INSERT INTO 'users' ('name', 'phone') VALUES ('X"
            read phone
            phone <- 000000

            it.executeQuery("INSERT INTO 'users' ('name', 'phone') VALUES ('${name}', ${phone});")

            Т.е запрос, который выполнится будет выглядеть так:

            INSERT INTO 'users' ('name', 'phone') VALUES ('X', 0); SELECT * FROM 'users'; INSERT INTO 'users' ('name', 'phone') VALUES ('X', 000000);

            */
            it.getAllUsers().forEach { user -> println(user) }
        }
    } catch (ex: Exception) {
        logger.error(ex) {}
    }
}
