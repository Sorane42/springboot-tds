package edu.spring.stories.entities

import jakarta.persistence.*


@Entity
open class Developer() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int? = null

    @Column(length = 30)
    open var firstname:String? = null
    @Column(length = 30)
    open var lastname:String? = null

    @OneToMany
    @JoinColumn(name="idStory", nullable = false)
    lateinit open var stories: Story
}