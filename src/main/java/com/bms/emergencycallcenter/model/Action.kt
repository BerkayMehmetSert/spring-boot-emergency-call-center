package com.bms.emergencycallcenter.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Action @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    val notes: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "catalog_id")
    val catalog: ActionCatalog?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "call_id")
    val call: Call?,

    @OneToMany(mappedBy = "action")
    val alertedService: Set<AlertedService>? = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Action

        if (id != other.id) return false
        if (notes != other.notes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + notes.hashCode()
        return result
    }

    override fun toString(): String {
        return "Action(id=$id, notes='$notes', catalog=$catalog, call=$call, alertedService=$alertedService)"
    }
}