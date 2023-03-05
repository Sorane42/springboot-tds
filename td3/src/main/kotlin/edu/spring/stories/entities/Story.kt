package edu.spring.stories.entities

import jakarta.persistence.*

@Entity
open class Story(name: String?) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int? = null

    @Column(length = 30)
    open lateinit var name:String


    @ManyToOne
    @JoinColumn(name="idDeveloper", nullable = false)
    open var developer: Developer? =null

    @ManyToMany
    @JoinTable(name = "story_tag",
        joinColumns = [JoinColumn(name = "idStory")],
        inverseJoinColumns = [JoinColumn(name = "idTag")])
    open var tags: MutableSet<Tag> = HashSet()


}