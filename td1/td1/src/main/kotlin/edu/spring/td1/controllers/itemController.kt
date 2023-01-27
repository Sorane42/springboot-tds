package edu.spring.td1.controllers

import Item
import edu.spring.td1.models.items
import edu.spring.td1.services.UIMessage
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView


@SessionAttributes("items")
class itemController {

    @ModelAttribute("items")
    fun getItems(): kotlin.collections.List<items?>? {
        return ArrayList<items?>()
    }
    @get:ModelAttribute("items")
    val items: Set<Any>
        get() {
            var elements=HashSet<Item>()
            elements.add(Item())
            return elements
        }

    @get:ModelAttribute("items")
    val items: Set <Item>
        get(){
            var elements=HashSet<Item>()
            elements.add(Item(nom:"Foo"))
            return elements
        }

    @RequestMapping("/")

    @GetMapping("/new")
    fun newAction(

    ):String{
        items.add(items)
        return "newForm"
    }

    @PostMapping("/addNew")
    fun addNewAction(
            @ModelAttribute("nom") item:Item,
            @SessionAttribute("Items") items:HashSet<Item>,
            attrs: RedirectAttributes
    ):RedirectView {
        if (items.add(item)){
            attrs.addFlashAttribute("msg", UIMessage.message("Ajout", "${item.nom} ajouté dans les items"))
    } else {
            attrs.addFlashAttribute("msg", UIMessage.message("Ajout", "${item.nom} est déjà dans les items", "error", "warning circle"))
    }

}