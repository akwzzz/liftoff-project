package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Exercise;
import org.launchcode.liftoffproject.models.data.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("exercise")
public class ExerciseController {

    @Autowired
    private ExerciseDao exerciseDao;


    // Request path: /exercise
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("exercises", exerciseDao.findAll());
        model.addAttribute("title", "My Exercise Tracker");

        return "exercise/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddExerciseForm(Model model) {
        model.addAttribute("title", "Add An Activity");
        model.addAttribute(new Exercise());
        return "exercise/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddExerciseForm(
            @ModelAttribute  @Valid Exercise newExercise,
            Errors errors,
            Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Exercise");
            return "exercise/add";
        }

        exerciseDao.save(newExercise);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveExerciseForm(Model model) {
        model.addAttribute("exercises", exerciseDao.findAll());
        model.addAttribute("title", "Remove An Activity");
        return "exercise/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveExerciseForm(@RequestParam int[] exerciseIds) {

        for (int exerciseId : exerciseIds) {

            exerciseDao.delete(exerciseId);
        }

        return "redirect:/exercise";
    }

}