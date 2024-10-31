package com.sankar.rotary.home3upeve;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home3Controller {

    @Autowired
    Home3Repo h3r;

    @PostMapping("/upeve")
    public String upeve(@RequestParam(
            "UpEve") String upEve,
                          Home3Pojo h3p){

        h3p=new Home3Pojo(h3p.getH3Id(),upEve);
        h3r.save(h3p);
        return "redirect:/admin";
    }

}
