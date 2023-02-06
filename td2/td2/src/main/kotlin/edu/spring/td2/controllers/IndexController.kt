package edu.spring.td2.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller

@Controller
@RequestMapping("/")
class IndexController {
   @RequestMapping(path=["","index"])
   fun indexAction(): String {
       return "index"
   }

}