package edu.spring.stories.entities

import jakarta.persistence.*


@Entity
open class Tag(color : String?, label : String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int? = null

    @Column(length = 30)
    open var color:String? = null
    @Column(length = 30)
    open var label:String? = null

    @ManyToMany
    @JoinTable(name = "story_tag",
        joinColumns = [JoinColumn(name = "idStory")],
        inverseJoinColumns = [JoinColumn(name = "idTag")])
    open var tags: MutableSet<Story> = HashSet()

}