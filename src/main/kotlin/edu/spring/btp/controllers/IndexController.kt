package edu.spring.btp.controllers


import edu.spring.btp.entities.Domain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController {
    @Autowired
    lateinit var userRepository: edu.spring.btp.repositories.UserRepository

    @Autowired
    lateinit var domainRepository: edu.spring.btp.repositories.DomainRepository

    @Autowired
    lateinit var complaintRepository: edu.spring.btp.repositories.ComplaintRepository

    @Autowired
    lateinit var providerRepository: edu.spring.btp.repositories.ProviderRepository

    @RequestMapping("/","/index")
    fun index(model : Model): String{
        model.addAttribute("domain",domainRepository.findByParentNull())
        return "index"
    }

    @RequestMapping("domain/{name}")
    fun getDomain(@PathVariable name:String, model : Model):String{
        model.addAttribute("domain",domainRepository.findByName(name))
        return "index"
    }

        @RequestMapping("/complaints/{domain}")
        fun getComplaints(@PathVariable domain:String, model : Model):String{
            model.addAttribute("complaints",complaintRepository.findByDomainName(domain))
            return "complaints"
        }
/*
        @RequestMapping("/complaints/{domain}/new")
        fun getNewComplaint(@PathVariable domain:String):String{

        }


        @RequestMapping("/login")

        @RequestMapping("/signup")

        @RequestMapping("/logout")
        */

}