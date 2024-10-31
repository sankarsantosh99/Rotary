package com.sankar.rotary.home1platime;

import com.sankar.rotary.home2theme.Home2Repo;
import com.sankar.rotary.home3upeve.Home3Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Home1Controller {

    @Autowired
    Home1Repo h1r;
    @Autowired
    Home2Repo h2r;
    @Autowired
    Home3Repo h3r;

    @GetMapping("/home")//home page
    public String homev(Model m){

        m.addAttribute("Details", h1r.findAll());

        m.addAttribute("Theme",h2r.findAll());

        m.addAttribute("UpEvent",h3r.findAll());

        return "Home";
    }

    @GetMapping("/home1dir")
    //submit admin1 action
    public String h1d(@ModelAttribute Home1Pojo h1p){
       h1r.save(h1p);
       return "redirect:/admin";
    }


}
