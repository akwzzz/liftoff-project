package org.launchcode.liftoffproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class GraphController {

    @GetMapping("/displayBarGraph")
    public String barGraph(Model model) {
        Map<String,Integer> surveyMap=new LinkedHashMap<>();
        surveyMap.put("9/7/19", 5);
        surveyMap.put("9/8/19", 3);
        surveyMap.put("9/9/19", 4);
        model.addAttribute("surveyMap", surveyMap);
        return "barGraph";
    }
}
