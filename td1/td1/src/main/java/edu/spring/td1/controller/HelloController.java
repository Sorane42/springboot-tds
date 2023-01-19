package edu.spring.td1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String helloAction() {
        return "Hello world";
    }

    @GetMapping(path={"msg/{c}", "msg/{c}/"})
    @ResponseBody
    public String messageAction(@PathVariable("c") String content){
        return content;
    }

    @GetMapping(path={"msg/view/{c}", "msg/{c}/"})
    public String messageViewAction(@PathVariable("c") String content){
        return "helloView";
    }

}