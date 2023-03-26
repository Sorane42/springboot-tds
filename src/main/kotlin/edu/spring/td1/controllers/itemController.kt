package edu.spring.td1.controllers

import items
import edu.spring.td1.services.UIMessage
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView


@SessionAttributes("items")
@Controller
class itemController {

    private fun getItemByName(nom:String,items:HashSet<items>):items?=items.find { nom==it.nom }
    @ModelAttribute("items")
    fun getItems(): kotlin.collections.List<items?>? {
        return ArrayList<items?>()
    }

    @get:ModelAttribute("items")
    val Item: Set<items>
        get() {
            var items = HashSet<items>()
            items.add(items(nom="item1"))
            return items
        }

    @RequestMapping("/")
    fun indexAction(@RequestAttribute("msg") msg:UIMessage.Message?):String{
        return "index"
    }

    @GetMapping("/new")
    fun newAction():String{
        return "monForm"
    }

    @PostMapping("/addNew")
    fun addNewAction(
            @ModelAttribute("nom") nom:String,
            @SessionAttribute("items") items:HashSet<items>,
            attrs:RedirectAttributes):RedirectView{
        if(items.add(items(nom))) {
            attrs.addFlashAttribute("msg", UIMessage.message("Ajout d'item", "$nom a été ajouté avec succès"))
        } else {
            attrs.addFlashAttribute("msg", UIMessage.message("Ajout d'item", "$nom est déjà dans la liste,<br>Il n'a pas été ajouté.","error","warning circle"))

        }
        return RedirectView("/")
    }
    @GetMapping("/inc/{nom}")
    fun incrementerEvaluation (@PathVariable nom:String, @SessionAttribute("items") items:HashSet<items>, attrs:RedirectAttributes):RedirectView{
        var item=getItemByName(nom,items)
        item?.evaluation = item!!.evaluation + 1
        return RedirectView("/")
    }
    @GetMapping("/dec/{nom}")
    fun decrementerEvaluation (@PathVariable nom:String, @SessionAttribute("items") items:HashSet<items>, attrs:RedirectAttributes):RedirectView{
        var item=getItemByName(nom,items)
        item?.evaluation = item!!.evaluation - 1
        return RedirectView("/")

    }
    @GetMapping("/items/delete/{nom}")
    fun removeItem(@PathVariable nom:String, @SessionAttribute("items") items:HashSet<items>, attrs:RedirectAttributes):RedirectView {

        for (item in items) {
            if (item.nom == nom) {
                items.remove(item)
            }
        }
        return RedirectView("/")
    }
}