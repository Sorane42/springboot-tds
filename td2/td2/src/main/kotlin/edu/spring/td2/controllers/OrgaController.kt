package edu.spring.td2.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import edu.spring.td2.entities.Organization
import edu.spring.td2.entities.User
import edu.spring.td2.repositories.OrganizationRepository


@Controller
@RequestMapping("/orgas/")
class OrgaController {


    @RequestMapping(path = ["","/index","/"])
    fun indexAction(model:ModelMap):String {
        model["organization"]=orgaRepository.findAll()
        return "organization/index"
    }

    @Autowired
    lateinit var orgaRepository:OrganizationRepository
    @GetMapping("add/{name}")
    @ResponseBody
    fun testAddAction(@PathVariable name:String):String{
        val orga = Organization()
        orga.name=name
        var user= User()
        user.firstname = "Thibault"
        user.lastname = "Lebranleur"
        user.email="Lt.lerbanleur@gmail.com"
        orga.users.add(user)

        orgaRepository.save(orga)
        return "Organisation $name"
    }


}