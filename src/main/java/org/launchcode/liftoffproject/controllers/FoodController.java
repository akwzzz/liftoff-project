package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.models.Category;
import org.launchcode.liftoffproject.models.Food;
import org.launchcode.liftoffproject.models.data.CategoryDao;
import org.launchcode.liftoffproject.models.data.FoodDao;
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
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private CategoryDao categoryDao;


    // Request path: /food
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("foods", foodDao.findAll());
        model.addAttribute("title", "My Food Tracker");
        model.addAttribute("categories", categoryDao.findAll());

        return "food/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddFoodForm(Model model) {
        model.addAttribute("title", "Add Today's Food");
        model.addAttribute(new Food());
        model.addAttribute("categories", categoryDao.findAll());
        return "food/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddFoodForm(
            @ModelAttribute  @Valid Food newFood,
            Errors errors,
            @RequestParam int categoryId,
            Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Food");
            return "food/add";
        }

        Category cat = categoryDao.findOne(categoryId);
        newFood.setCategory(cat);
        foodDao.save(newFood);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveFoodForm(Model model) {
        model.addAttribute("foods", foodDao.findAll());
        model.addAttribute("title", "Remove A Food");
        return "food/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveFoodForm(@RequestParam int[] foodIds) {

        for (int foodId : foodIds) {

            foodDao.delete(foodId);
        }

        return "redirect:/food";
    }

}
