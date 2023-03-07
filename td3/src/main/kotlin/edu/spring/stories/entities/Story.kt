package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
open class Story() {
    constructor(name:String):this(){
        this.name=name
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open val id = 0

    @Column(length = 60, nullable = false)
    open lateinit var name: String

    open var description:String=""

    @ManyToOne(optional = true)
    open var developer: Developer?=null

    @ManyToMany
    open val tags= mutableSetOf<Tag>()

}