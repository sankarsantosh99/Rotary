package com.sankar.rotary.members2lead;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    LeadRepo lr1;
    private static final String UPLOAD_DIR = "D:/DATCH" +
            "/Springboot/rotary" +
            "/uploads/Leaders";
    private static final int MAX_FILES = 2;

    public LeadPojo saveLead(MultipartFile mfile,
                           LeadPojo lp) throws IOException {
        String fileName = mfile.getOriginalFilename();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        long fileCount = lr1.count();
        if (fileCount >= MAX_FILES) {
            throw new IOException("File limit reached" +
                    ".Please delete an entry before " +
                    "uploading a new  one.");
        }
        File fileToSave =
                new File(UPLOAD_DIR + File.separator + fileName);
        mfile.transferTo(fileToSave);

        lp.setlUrl(fileName);

        return lr1.save(lp);
    }


    public void deleteLead(int id) {
        Optional<LeadPojo> lpOptional = lr1.findById(id);

        if (lpOptional.isPresent()) {
            LeadPojo lp = lpOptional.get();
            File fileToDelete =
                    new File(UPLOAD_DIR + File.separator + lp.getlUrl());
            boolean isDeleted = false;
            if (fileToDelete.exists()) {
                isDeleted=fileToDelete.delete();
            }
            if(isDeleted){
                lr1.deleteById(id);
            }else{
                System.out.println("Failed to Delete " +
                        "File"+lp.getlUrl());
            }
        }
    }


}
