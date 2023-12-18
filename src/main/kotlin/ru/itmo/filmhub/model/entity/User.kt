package ru.itmo.filmhub.model.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    var subscription: Subscription? = null,
    @Column(nullable = false)
    val name: String? = null,
    @Column(nullable = false)
    val email: String? = null,
    @Column(nullable = false)
    val login: String? = null,
    @Column(nullable = false)
    val password: String? = null,
    @Column(name = "phone_number")
    val phoneNumber: String? = null,
) : BaseEntity()
