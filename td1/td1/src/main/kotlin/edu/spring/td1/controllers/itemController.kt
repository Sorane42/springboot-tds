package edu.spring.td1.controllers

@SessionAttributes("items")
class itemController {
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
}