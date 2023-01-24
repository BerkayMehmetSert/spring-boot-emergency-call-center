package com.bms.emergencycallcenter.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Alert @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    val alwaysAlert: Boolean,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "emergency_id")
    val emergency: Emergency?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "catalog_id")
    val catalog: ActionCatalog?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Alert

        if (id != other.id) return false
        if (alwaysAlert != other.alwaysAlert) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + alwaysAlert.hashCode()
        return result
    }

    override fun toString(): String {
        return "Alert(id=$id, alwaysAlert=$alwaysAlert, emergency=$emergency, catalog=$catalog)"
    }
}
