package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String formPage(Model model) {
        model.addAttribute("title", "Login");
        return "login/form";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String homePage(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            Model model) {
        model.addAttribute("title", "Welcom to Spring");
        model.addAttribute("name", name);
        return "home/welcome";
    }
}
