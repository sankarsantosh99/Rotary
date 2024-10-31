package com.sankar.rotary.members1dig;

import com.sankar.rotary.members2lead.LeadRepo;
import com.sankar.rotary.members3mem.MemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DigController {

    @Autowired
    private DigRepo dr1;
    @Autowired
    private LeadRepo lr1;
    @Autowired
    private MemRepo mr1;
    @Autowired
    private DigService ds1;

    @GetMapping("/members")
    public String membersv(Model m) {

        m.addAttribute("Dignitaries",
                dr1.findAll());
        m.addAttribute("Leaders",
                lr1.findAll());
        m.addAttribute("Members",
                mr1.findAll());

        return "members";
    }

    @PostMapping("/adddig")
    public String adddig(@RequestParam(
            "finame")MultipartFile mfile,
                         @ModelAttribute DigPojo dp){

        try {
            ds1.saveDig(mfile,dp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }


    @PostMapping("/deletedig/{id}")
    public String deleteFile(@PathVariable int id) {
        ds1.deleteFile(id);
        return "redirect:/admin";
    }

}
