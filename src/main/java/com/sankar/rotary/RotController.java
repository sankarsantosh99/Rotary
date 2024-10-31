package com.sankar.rotary;

import com.sankar.rotary.aboutcarousel.AboutPojo;
import com.sankar.rotary.aboutcarousel.AboutRepo;
import com.sankar.rotary.home1platime.Home1Pojo;
import com.sankar.rotary.home1platime.Home1Repo;
import com.sankar.rotary.home2theme.Home2Pojo;
import com.sankar.rotary.home2theme.Home2Repo;
import com.sankar.rotary.home3upeve.Home3Pojo;
import com.sankar.rotary.home3upeve.Home3Repo;

import com.sankar.rotary.members1dig.DigPojo;
import com.sankar.rotary.members1dig.DigRepo;
import com.sankar.rotary.members2lead.LeadPojo;
import com.sankar.rotary.members2lead.LeadRepo;
import com.sankar.rotary.members3mem.MemPojo;
import com.sankar.rotary.members3mem.MemRepo;
import com.sankar.rotary.pevents.PeventsPojo;
import com.sankar.rotary.pevents.PeventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotController {

    @Autowired
    private Home1Repo h1r;
    @Autowired
    private Home2Repo h2r;
    @Autowired
    private Home3Repo h3r;
    @Autowired
    private AboutRepo ar1;
    @Autowired
    private DigRepo dr1;
    @Autowired
    private LeadRepo lr1;
    @Autowired
    private MemRepo mr1;
    @Autowired
    private PeventsRepo per1;


    @GetMapping("/findus")
    public String findusv() {
        return "findus";
    }


    @GetMapping("/upevents")
    public String upevev() {
        return "upcomingevents";
    }

    @GetMapping("/adminlogin")
    public String adminlogv() {
        return "adminlogin";
    }

    @GetMapping("/admin")
    public String adminv(Model m) {

        m.addAttribute("home1Pojo",
                new Home1Pojo());
        m.addAttribute("Details",
                h1r.findAll());


        m.addAttribute("Theme",
                h2r.findAll());

        m.addAttribute("UpEvent", h3r.findAll());


        m.addAttribute("carou", ar1.findAll());


        m.addAttribute("digpojo", new DigPojo());
        m.addAttribute("dignitaries",
                dr1.findAll());


        m.addAttribute("leadpojo",
                new LeadPojo());
        m.addAttribute("leaders",
                lr1.findAll());


        m.addAttribute("mempojo", new MemPojo());
        m.addAttribute("members",
                mr1.findAll());


        m.addAttribute("peventspojo",
                new PeventsPojo());
        m.addAttribute("pevents",
                per1.findAll());

        return "admin";
    }


}
