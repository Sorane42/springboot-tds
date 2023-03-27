package edu.spring.btp.controllers


import edu.spring.btp.entities.Domain
import edu.spring.btp.entities.Complaint
import edu.spring.btp.entities.User
import edu.spring.btp.entities.Provider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView

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
        @PostMapping("complaints/{domain}/new")
        fun newComplaint(
            @PathVariable domain:String,
            @RequestParam("title") title:String,
            @RequestParam("description") description:String,
            ): String {
                println(title)
                var complaint = Complaint()
                complaint.title = title
                complaint.description = description
                complaint.domain = domainRepository.findByName(domain)
                complaintRepository.save(complaint)
                return "redirect:/complaints/$domain"
            }

        @RequestMapping("complaints/{domain}/new")
        fun newComplaint(@PathVariable domain:String, model:Model):String{
            model.addAttribute("domain", domainRepository.findByName(domain))
            return "forms/complaint"
        }

        @RequestMapping("login")
        fun login():String{
            return "login"
        }

    @RequestMapping("signup")
    fun signup():String{
        return "signup"
    }


}