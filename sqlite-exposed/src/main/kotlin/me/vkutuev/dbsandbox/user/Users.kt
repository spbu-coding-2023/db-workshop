package me.vkutuev.dbsandbox.user

import me.vkutuev.dbsandbox.city.Cities
import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val name = varchar("name", 255)
    val phone = integer("phone")
    val city = reference("city", Cities).nullable()
}
