package edu.spring.td1.controllers

import Item
import edu.spring.td1.models.items
import org.springframework.web.bind.annotation.*


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

    @GetMapping("/new")
    fun newAction(
            @ModelAttribute("nom") item:Item,
            @SessionAttribute("Items") items:HashSet<Item>
    ):String{
        items.add(item)
        return "newForm"
    }

}