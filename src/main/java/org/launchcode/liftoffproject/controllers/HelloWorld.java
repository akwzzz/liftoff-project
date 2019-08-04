package org.launchcode.liftoffproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class HelloWorld {
    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello, World!";
    }

}
