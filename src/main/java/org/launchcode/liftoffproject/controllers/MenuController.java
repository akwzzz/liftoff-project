package org.launchcode.liftoffproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LaunchCode
 */
@Controller
public class MenuController {

    @RequestMapping(value = "menu")
    public String index(Model model) {

        model.addAttribute("title", "My Wellness");

        return "menu/index";
    }

}
