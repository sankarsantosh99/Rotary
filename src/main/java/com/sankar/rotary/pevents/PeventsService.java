package com.sankar.rotary.pevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class PeventsService {

    @Autowired
    private PeventsRepo per1;

    private static final String UPLOAD_DIR = "D:/DATCH" +
            "/Springboot/rotary" +
            "/uploads/Pevents";

    public PeventsPojo savePev(MultipartFile mfile,
                           PeventsPojo pep) throws IOException {
        String fileName = mfile.getOriginalFilename();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File fileToSave =
                new File(UPLOAD_DIR + File.separator + fileName);
        mfile.transferTo(fileToSave);

        pep.setPeUrl(fileName);

        return per1.save(pep);
    }




    public void deletePev(int id) {
        Optional<PeventsPojo> pepOptional =
                per1.findById(id);

        if (pepOptional.isPresent()) {
            PeventsPojo pep = pepOptional.get();
            File fileToDelete =
                    new File(UPLOAD_DIR + File.separator + pep.getPeUrl());
            boolean isDeleted = false;
            if (fileToDelete.exists()) {
                isDeleted=fileToDelete.delete();
            }
            if(isDeleted){
                per1.deleteById(id);
            }else{
                System.out.println("Failed to Delete " +
                        "File"+pep.getPeUrl());
            }
        }
    }
}
