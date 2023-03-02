package edu.spring.stories.controllers

import edu.spring.stories.entities.Developer
import edu.spring.stories.repositories.DeveloperRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class MainController {
    @Autowired
    lateinit var developerRepository: DeveloperRepository
        @RequestMapping(path=["","/"])
        fun indexAction(): String {
            return "index"
        }

        @PostMapping
        @RequestMapping(path=["/developer/add"])
        fun addNewDeveloper(@ModelAttribute("firstname") firstname : String,@ModelAttribute("lastName") lastname : String): RedirectView {
            developerRepository.save(Developer(firstname, lastname))
            return RedirectView("/")
        }




        @PostMapping
        @RequestMapping(path=["/developer/{id}/story"])
        fun addStoryToStories(): String {
            return "/"
        }

        @GetMapping
        @RequestMapping(path=["/story/{id}/giveup"])
        fun removeStoryFromDeveloper(): String {
            return "/"
        }

        @GetMapping
        @RequestMapping(path=["/developer/{id}/delete"])
        fun removeDeveloper(): String {
            return "/"
        }

        @PostMapping
        @RequestMapping(path=["/story/{id}/action"])
        fun removeStoryByIdOrAffect(): String {
            return "/"
        }
}