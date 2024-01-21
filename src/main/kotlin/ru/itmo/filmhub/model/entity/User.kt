package ru.itmo.filmhub.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @Column
    val name: String? = null,
    @Column
    val email: String? = null,
    @Column(nullable = false)
    val username: String? = null,
    @Column(nullable = false)
    val password: String? = null,
    @Column(nullable = false)
    val enabled: Boolean? = null,
    @Column
    val phoneNumber: String? = null,
    @OneToMany(cascade = [CascadeType.ALL])
    @JsonIgnore
    val authorities: List<UserAuthority> = mutableListOf()
) : BaseEntity()
