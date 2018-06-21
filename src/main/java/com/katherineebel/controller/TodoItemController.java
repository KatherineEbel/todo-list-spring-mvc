package com.katherineebel.controller;

import com.katherineebel.model.TodoData;
import com.katherineebel.util.Mappings;
import com.katherineebel.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
    // == model attributes
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == handler methods
    // http://localhost:todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
