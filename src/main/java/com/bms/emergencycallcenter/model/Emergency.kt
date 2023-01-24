package com.bms.emergencycallcenter.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Emergency @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    val name: String,

    val details: String,

    @OneToMany(mappedBy = "emergency")
    val alertedService: Set<AlertedService>? = HashSet(),

    @OneToMany(mappedBy = "emergency")
    val alert: Set<Alert>? = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Emergency

        if (id != other.id) return false
        if (name != other.name) return false
        if (details != other.details) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + details.hashCode()
        return result
    }

    override fun toString(): String {
        return "Emergency(id=$id, name='$name', details='$details', alertedService=$alertedService, alert=$alert)"
    }
}
