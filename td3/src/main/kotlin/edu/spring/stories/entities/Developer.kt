package edu.spring.stories.entities

import jakarta.persistence.*


@Entity
open class Developer(firstname: String?, lastname: String?) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int = 0

    @Column(length = 30)
    open var firstname:String? = null
    @Column(length = 30)
    open var lastname:String? = null


    @OneToMany
    open lateinit var stories: MutableSet<Story>

    fun addStory(story: Story) {
        stories.add(story)
    }

    fun giveUpStory(story: Story) {
        stories.remove(story)
    }

    @PreRemove
    fun preRemove() {
        stories.removeAll(stories)
    }
}