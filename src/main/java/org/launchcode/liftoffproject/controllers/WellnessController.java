package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Wellness;
import org.launchcode.liftoffproject.models.data.WellnessDao;
import org.launchcode.liftoffproject.models.data.TrendsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("wellness")
public class WellnessController {

    @Autowired
    private WellnessDao wellnessDao;

    @Autowired
    private TrendsDao trendsDao;

    // Request path: /wellness
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("wellness", wellnessDao.findAll());
        model.addAttribute("title", "My Wellness");

        return "wellness/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddWellnessForm(Model model) {
        model.addAttribute("title", "Add Wellness");
        model.addAttribute(new Wellness());
        return "wellness/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddWellnessForm(
            @ModelAttribute  @Valid Wellness newWellness,
            Errors errors,
            Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Wellness");
            return "wellness/add";
        }

        wellnessDao.save(newWellness);
        return "redirect:";
    }

}