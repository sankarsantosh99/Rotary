package com.sankar.rotary.aboutcarousel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AboutController {

    @Autowired
    AboutService as1;
    @Autowired
    AboutRepo ar1;

    @GetMapping("/about")
    public String aboutv(Model m){
        m.addAttribute("carou",ar1.findAll());
        return "about";
    }

    @PostMapping("/caroup")
    public String uploadFile(@RequestParam(
            "carfile") MultipartFile mfile,
                             RedirectAttributes redirectAttributes
                            ) throws IOException {
        if (mfile.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a file to upload.");
            return "redirect:/admin";
        }

        try {
            as1.saveFile(mfile);
            return "redirect:/admin";
        }catch (IOException e){
            redirectAttributes.addFlashAttribute("error",
                    e.getMessage());
            return "redirect:/admin";
        }
    }

    @PostMapping("/deletecar/{id}")
    public String deleteFile(@PathVariable int id) {
        as1.deleteFile(id);
        return "redirect:/admin";
    }


}
