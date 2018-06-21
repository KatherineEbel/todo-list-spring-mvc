package com.katherineebel.controller;

import com.katherineebel.services.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    // == constructor
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    // prefix + name + suffix
    // -- resolves to --> /WEB-INF/view/welcome.jsp)
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Kathy"));
        log.info("model= {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
