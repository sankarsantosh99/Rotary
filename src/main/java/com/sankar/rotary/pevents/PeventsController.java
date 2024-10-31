package com.sankar.rotary.pevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PeventsController {

    @Autowired
    private PeventsRepo per;
    @Autowired
    private PeventsService pes1;

    @GetMapping("/pevents")
    public String pastevev(Model m) {
        m.addAttribute("pevents",per.findAll());
        return "pastevents";
    }

    @PostMapping("/addpevent")
    public String addpevent(@RequestParam(
            "finame")MultipartFile mfile,
                         @ModelAttribute PeventsPojo pep){

        try {
            pes1.savePev(mfile,pep);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }

    @GetMapping("/retrievepevent/{id}")
    @ResponseBody
    public PeventsPojo retEvent(@PathVariable int id){
       return per.findById(id).orElse(new PeventsPojo());
    }

    @PostMapping("/updatepevent")
    public String upEvent(@RequestParam("finame")MultipartFile mfile,
                          @ModelAttribute PeventsPojo pep){
        try {
            pes1.savePev(mfile,pep);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }


    @PostMapping("/deletepevent/{id}")
    public String deleteFile(@PathVariable int id) {
        pes1.deletePev(id);
        return "redirect:/admin";
    }

}
