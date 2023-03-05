package edu.spring.stories.entities

import jakarta.persistence.*


@Entity
open class Developer() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int = 0

    @Column(length = 30)
    open var firstname:String? = ""
    @Column(length = 30)
    open var lastname:String? = ""


    @OneToMany (mappedBy = "developer", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL])
    open lateinit var stories: MutableSet<Story>

    fun addStory(story: Story) {
        stories.add(story)
        story.developer = this
    }

    fun giveUpStory(story: Story) {
        stories.remove(story)
    }

    @PreRemove
    fun preRemove() {
        stories.forEach {
            it.developer = null
        }
        stories.clear()
    }

    constructor(firstname: String, lastname: String) : this() {
        this.firstname = firstname
        this.lastname = lastname
    }
}