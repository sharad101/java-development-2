package com.pluralsight.ledgerapi4.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(path = "/potato", method = RequestMethod.GET)
    public String index(@RequestParam String name){
        return "Hello " + name + "!";
    }
}
