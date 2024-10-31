package com.sankar.rotary.members2lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class LeadController {

    @Autowired
    private LeadService ls1;

    @PostMapping("/addlead")
    public String addlead(@RequestParam(
            "finame")MultipartFile mfile,
                         @ModelAttribute LeadPojo lp){

        try {
            ls1.saveLead(mfile,lp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }


    @PostMapping("/deletelead/{id}")
    public String deleteFile(@PathVariable int id) {
        ls1.deleteLead(id);
        return "redirect:/admin";
    }
}
