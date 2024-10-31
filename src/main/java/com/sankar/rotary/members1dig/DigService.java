package com.sankar.rotary.members1dig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class DigService {
    @Autowired
    DigRepo dr1;
    private static final String UPLOAD_DIR = "D:/DATCH" +
            "/Springboot/rotary" +
            "/uploads/Dignitaries";
    private static final int MAX_FILES = 2;

    public DigPojo saveDig(MultipartFile mfile,
                           DigPojo dp) throws IOException {
        String fileName = mfile.getOriginalFilename();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        long fileCount = dr1.count();
        if (fileCount >= MAX_FILES) {
            throw new IOException("File limit reached" +
                    ".Please delete an entry before " +
                    "uploading a new  one.");
        }
        File fileToSave =
                new File(UPLOAD_DIR + File.separator + fileName);
        mfile.transferTo(fileToSave);

        dp.setdUrl(fileName);

        return dr1.save(dp);
    }


    public void deleteFile(int id) {
        Optional<DigPojo> dpOptional = dr1.findById(id);

        if (dpOptional.isPresent()) {
            DigPojo dp = dpOptional.get();
            File fileToDelete =
                    new File(UPLOAD_DIR + File.separator + dp.getdUrl());
            boolean isDeleted = false;
            if (fileToDelete.exists()) {
                isDeleted=fileToDelete.delete();
            }
            if(isDeleted){
                dr1.deleteById(id);
            }else{
               System.out.println("Failed to Delete File"+dp.getdUrl());
            }
        }
    }


}
