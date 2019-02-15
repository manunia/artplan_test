package com.aplanTest.webApp.controller;

import com.aplanTest.webApp.domain.User;
import com.aplanTest.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;



    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);
            model.addAttribute("message", "Error! Field is empty!");
            return "registration";

        }
        //проверка на существование юзера с таким имененм
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        } else {
            model.addAttribute("message", "Username available.");
        }

        return "redirect:/login";
    }
}
