package edu.spring.td2.directory

import edu.spring.td2.entities.Organization
import edu.spring.td2.entities.User
import org.springframework.stereotype.Service

@Service
class OrgaService {

    fun addUserFromString(users: String, organization: Organization) {
        if(users.isNotEmpty()){
            users.split("\n").forEach { user ->
                val u = User()
                val (firstname, lastname) = user.split(" ",limit=2)
                u.firstname = firstname
                u.lastname = lastname
                u.email = "${u.firstname}.${u.lastname}@${organization.domain}".lowercase()
                organization.users.add(u)
            }
        }
    }
}