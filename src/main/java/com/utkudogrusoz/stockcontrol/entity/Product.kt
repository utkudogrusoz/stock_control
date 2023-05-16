package com.utkudogrusoz.stockcontrol.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "product", schema = "stock_control")
data class Product @JvmOverloads constructor(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @Column(name = "product_name")
        val productName: String? = "",

        val quantity: Int? = 0,
        val price: Double? = 0.0,

        @Column(name = "updated_date")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonFormat(pattern = "yyyy-MM-dd")
        val updatedDate: Date = Date(),

        @Column(name = "created_date")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonFormat(pattern = "yyyy-MM-dd")
        val createdDate: Date = Date(),

        val deleted: Boolean? = false

) {

}
