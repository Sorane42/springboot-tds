package edu.spring.stories.controllers

import edu.spring.stories.repositories.MasterRepository
import io.github.jeemv.springboot.vuejs.VueJS
import io.github.jeemv.springboot.vuejs.utilities.Http
import io.github.jeemv.springboot.vuejs.utilities.JsArray
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class SPAController {

    @Autowired
    lateinit var masterRepository: MasterRepository

    @Autowired
    lateinit var vue: VueJS

    @ModelAttribute("vue")
    fun vue(): VueJS = vue

    @GetMapping(path = ["/","","/index"])
    fun index(): String {
        vue.addData("masters", masterRepository.findAll() )
        vue.addDataRaw("message","{title:'',content:''}")
        vue.addMethod("showMessage",
            "this.message={error: error,title: title, content: content, display: true};"+
                    "setTimeout(function(){this.message.display=false;}.bind(this),5000);",
            "title","content","error")
        vue.addMethod("successMessage",
            "this.showMessage(title,content,false);",
            "title","content")
        vue.addMethod("errorsMessage",
            "this.showMessage(title,content,true);",
            "title","content")
        vue.addMethod("remove", Http.delete("'/masters/'+master.id",
           JsArray.remove("this.masters","master")+
                        JsArray.addAll("this.dogs","master.dogs")+
                        "console.log(`Maître \${master.firstname} supprimé!`);",
                "console.log('Erreur sur suppression de master!');"
            ),
            "master")

        vue.addGlobalComponent("AppMessage").setProps("title","content","error","visible").setDefaultTemplateFile()

        return "/spa/index"
    }
}