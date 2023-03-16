package edu.spring.stories.ressources

import Dog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "dogs", path = "dogs")
interface RestDogResource: JpaRepository<Dog, Int> {
}