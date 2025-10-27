package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //    @RequestMapping(value = "/home")
//    public String homePage(Model model) {
//        model.addAttribute("title", "Welcom to Spring");
//        return "home/welcome";
//    }
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("title", "Welcome to Spring");
        return "home/welcome";
    }
}
