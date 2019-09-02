package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Sleep;
import org.launchcode.liftoffproject.models.data.SleepDao;
import org.launchcode.liftoffproject.models.data.TrendsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("sleep")
public class SleepController {

    @Autowired
    private SleepDao sleepDao;

    @Autowired
    private TrendsDao trendsDao;

    // Request path: /sleep
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("sleep", sleepDao.findAll());
        model.addAttribute("title", "My Sleep");

        return "sleep/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddSleepForm(Model model) {
        model.addAttribute("title", "Add Sleep");
        model.addAttribute(new Sleep());
        return "sleep/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddSleepForm(
            @ModelAttribute @Valid Sleep newSleep,
            Errors errors,
            Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Sleep");
            return "sleep/add";
        }

        sleepDao.save(newSleep);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveSleepForm(Model model) {
        model.addAttribute("sleeps", sleepDao.findAll());
        model.addAttribute("title", "Remove Sleep Entry");
        return "sleep/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveSleepForm(@RequestParam int[] sleepIds) {

            for (int sleepId : sleepIds) {

                sleepDao.delete(sleepId);
            }

            return "redirect:/sleep";
        }
    }

