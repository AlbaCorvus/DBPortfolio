package com.cjmulcahy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Chris on 1/16/2017.
 */
@Controller
@RequestMapping("DB")
public class DBController {


    @RequestMapping("/Home")
    public ModelAndView openHomePage(){

        return new ModelAndView("Home");
    }



}
