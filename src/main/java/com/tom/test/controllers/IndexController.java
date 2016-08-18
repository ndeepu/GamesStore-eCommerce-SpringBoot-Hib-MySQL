package com.tom.test.controllers;

import com.tom.test.services.BundleService;
import com.tom.test.services.DummyDataGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by tom on 7/6/2016.
 */
@Controller
public class IndexController {

    @Autowired
    BundleService bundleService;

    @ModelAttribute("page")
    public String module() {
        return "index";
    }

    @RequestMapping("/access_denied")
    public String notAuth(){
        return "access_denied";
    }

    @RequestMapping("login")
    public String loginForm(){
        return "login";
    }

    @RequestMapping({"/","index","home"})
    public String home(Model model){
        model.addAttribute("bundle", bundleService.getById(1));
        model.addAttribute("products",bundleService.getById(1).getProducts());
        return "index";
    }
}
