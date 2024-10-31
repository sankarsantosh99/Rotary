package com.sankar.rotary.members3mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MemController {

   @Autowired
   private MemService ms1;

    @PostMapping("/addmem")
    public String addmem(@RequestParam(
            "finame")MultipartFile mfile,
                          @ModelAttribute MemPojo mp){

        try {
            ms1.saveMem(mfile,mp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/admin";
    }


    @PostMapping("/deletemem/{id}")
    public String deleteFile(@PathVariable int id) {
        ms1.deleteMem(id);
        return "redirect:/admin";
    }
}
