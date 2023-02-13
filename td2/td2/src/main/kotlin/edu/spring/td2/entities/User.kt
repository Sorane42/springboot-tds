package edu.spring.td2.entities

import jakarta.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int?=null
    @Column(length = 30)
    open var firstname:String?=null
    @Column(length = 30)
    open var lastname:String?=null

    @Column(nullable = false, length = 255, unique = true)
    open lateinit var email:String

    open var password:String?=null

    open var suspended:Boolean=false

    @ManyToOne
    @JoinColumn(name="idOrganization",nullable = false)
    lateinit open var organization:Organization


}