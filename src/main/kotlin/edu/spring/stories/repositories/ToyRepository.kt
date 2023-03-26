package edu.spring.stories.repositories

import Toy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
@Repository
interface ToyRepository:CrudRepository<Toy, Int> {
    fun findByType(type:String):List<Toy>
}