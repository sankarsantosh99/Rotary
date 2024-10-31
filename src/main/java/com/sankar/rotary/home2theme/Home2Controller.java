package com.sankar.rotary.home2theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class Home2Controller {

    @Autowired
    private Home2Service h2s;


    @PostMapping("/uploads/up1th")
    public String uploadFile(@RequestParam(
            "themeYear") String theme,
                             @RequestParam(
            "file") MultipartFile file
                            ) throws IOException {
        h2s.saveFile(theme,file);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id) {
        h2s.deleteFile(id);
        return "redirect:/admin";
    }
}


