package edu.spring.td2.controllers

import edu.spring.td2.directory.OrgaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import edu.spring.td2.entities.Organization
import edu.spring.td2.entities.User
import edu.spring.td2.exception.ElementNotFoundException
import edu.spring.td2.repositories.OrganizationRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView


@Controller
@RequestMapping("/orgas/")
class OrgaController {

    @Autowired
    lateinit var orgaRepository:OrganizationRepository
    @Autowired
    lateinit var orgaService:OrgaService
    @RequestMapping(path = ["","/index","/"])
    fun indexAction(model:ModelMap):String {
        model["organization"]=orgaRepository.findAll()
        return "organization/index"
    }
    @PostMapping("/new")
    fun newSubmitAction(
        @ModelAttribute orga:Organization,
        @ModelAttribute("users") users:String
    ): RedirectView {
       orgaService.addUserFromString(users,orga)
        orgaRepository.save(orga)
        return RedirectView("/orgas")
    }

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

    @GetMapping("display/{id}")
    fun display(@PathVariable id:Long,model:ModelMap):String{
        val option=orgaRepository.findById(id)
        if(option.isPresent){
            model["organization"]=option.get()
            return "/orgas/display"
        }
        throw ElementNotFoundException("L'organisation $id n'existe pas")
    }

    @ExceptionHandler(value = [ElementNotFoundException::class])
    @ResponseBody
    fun exceptionHandler(ex:RuntimeException):String {
        return "Erreur ${ex.message}"
    }

}