package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
open class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int? = null

    @Column(length = 30)
    open var name:String? = null

    @ManyToOne
    @JoinColumn(name="idDeveloper", nullable = false)
    lateinit open var developer: Developer

    @ManyToMany
    @JoinTable(name = "story_tag",
        joinColumns = [JoinColumn(name = "idStory")],
        inverseJoinColumns = [JoinColumn(name = "idTag")])
    open var tags: MutableSet<Tag> = mutableSetOf()


}