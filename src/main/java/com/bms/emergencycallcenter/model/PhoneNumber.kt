package com.bms.emergencycallcenter.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class PhoneNumber @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    val number: String,

    val notes: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "number_status_id")
    val status: PhoneNumberStatus,

    @OneToMany(mappedBy = "phoneNumber")
    val calls: Set<Call>? = HashSet(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhoneNumber

        if (id != other.id) return false
        if (number != other.number) return false
        if (notes != other.notes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + number.hashCode()
        result = 31 * result + notes.hashCode()
        return result
    }

    override fun toString(): String {
        return "PhoneNumber(id=$id, number='$number', notes='$notes', status=$status, calls=$calls)"
    }

}
