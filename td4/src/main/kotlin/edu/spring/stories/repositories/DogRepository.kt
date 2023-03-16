package edu.spring.stories.repositories


import Dog
import org.springframework.data.repository.CrudRepository

interface DogRepository:CrudRepository<Dog, Int> {
    fun findByMasterIsNull():List<Dog>
    fun findByNameAndMasterId(name:String,masterId:Int):Dog?
}