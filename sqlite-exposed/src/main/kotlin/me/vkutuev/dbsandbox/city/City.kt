package me.vkutuev.dbsandbox.city

import me.vkutuev.dbsandbox.user.User
import me.vkutuev.dbsandbox.user.Users
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class City(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<City>(Cities)

    var name by Cities.name
    val users by User optionalReferrersOn Users.city

    override fun toString(): String = "City(name = $name)"
}
