package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String formPage(Model model) {
        model.addAttribute("login", "Login");
        return "login/form";
    }

}
