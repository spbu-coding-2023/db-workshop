package me.vkutuev.dbsandbox

fun main() {
    Neo4jRepository("bolt://localhost:7687", "neo4j", "qwertyui").use {
        val rybinsk = City("Rybinsk")
        it.addUser(User("Vova", 987654, null))
        it.addCity(rybinsk)
        it.addUser(User("Ann", 630474, rybinsk))
        it.getAllUsers().forEach { user -> println(user) }
    }
}
