package ru.itmo.filmhub.model.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    val subscription: Subscription?,
    val name: String,
    val email: String,
    val login: String,
    val password: String,
    @Column(name = "phone_number")
    val phoneNumber: String?,

)
