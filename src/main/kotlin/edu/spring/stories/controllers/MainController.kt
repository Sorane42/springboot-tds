package edu.spring.stories.controllers

import edu.spring.stories.entities.Developer
import edu.spring.stories.entities.Story
import edu.spring.stories.repositories.DeveloperRepository
import edu.spring.stories.repositories.StoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.view.RedirectView

@Controller
class MainController {
    @Autowired
    lateinit var developerRepository: DeveloperRepository

    @Autowired
    private lateinit var storyRepository: StoryRepository

        @GetMapping(path=["","/"])
        fun indexAction(model : ModelMap): String {
            val developers = developerRepository.findAll()
            val stories = storyRepository.findAll()
            model["develop"]=developers
            model["stories"]=stories
            model.addAttribute("nbDeveloper",developers.count())
            model.addAttribute("nbStory",stories.count())
            return "index"
        }

        @PostMapping("/developer/add")
        fun submitNewAction(@ModelAttribute dev:Developer
        ):RedirectView{
            developerRepository.save(dev)
            return RedirectView("/")
        }
        @GetMapping(path=["/story/{id}/giveup"])
        fun giveUpAction(@PathVariable id: Int): RedirectView {
            val story = storyRepository.findById(id).get()
            val developer = story.developer
            developer?.giveUpStory(story)
            story.developer = null
            storyRepository.save(story)
            return RedirectView("/")
        }


        @PostMapping("/developer/{id}/story")
        fun addStoryAction(@PathVariable id:Int, @RequestParam nomStory:String
        ):RedirectView{
            val developer = developerRepository.findById(id).get()
            val story = Story(nomStory)
            story.name = nomStory
            story.developer = developer
            developer.addStory(story)
            developerRepository.save(developer)
            return RedirectView("/")
        }



        @GetMapping("/developer/{id}/delete")
        fun deleteDeveloperAction( @PathVariable id:Int
        ):RedirectView{
        developerRepository.deleteById(id)
        return RedirectView("/")
        }

        @PostMapping(path=["/story/{id}/action"])
        fun removeStoryAction(): String {
            return "/"
        }
}