package com.bms.emergencycallcenter.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Call @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    val callStartTime: LocalDateTime,

    val callEndTime: LocalDateTime,

    val callDuration: Int,

    val notes: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "operator_id")
    val operator: Operator?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "phone_number_id")
    val phoneNumber: PhoneNumber?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "call_status_id")
    val status: CallStatus,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "city_id")
    val city: City
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Call

        if (id != other.id) return false
        if (callStartTime != other.callStartTime) return false
        if (callEndTime != other.callEndTime) return false
        if (callDuration != other.callDuration) return false
        if (notes != other.notes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + callStartTime.hashCode()
        result = 31 * result + callEndTime.hashCode()
        result = 31 * result + callDuration
        result = 31 * result + notes.hashCode()
        return result
    }

    override fun toString(): String {
        return "Call(id=$id, callStartTime=$callStartTime, callEndTime=$callEndTime, " +
                "callDuration=$callDuration, notes='$notes', operator=$operator, " +
                "phoneNumber=$phoneNumber, status=$status, city=$city)"
    }
}
