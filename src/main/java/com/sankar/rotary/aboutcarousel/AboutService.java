package com.sankar.rotary.aboutcarousel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class AboutService {

    @Autowired
    private AboutRepo ar1;

    private static final String UPLOAD_DIR =
            "D:/DATCH/Springboot/rotary/uploads/Carou";
    private static final int MAX_FILES = 6;
    // Save a new file if file count is less than MAX_FILES

    public AboutPojo saveFile(MultipartFile mfile) throws IOException {
        String fileName = mfile.getOriginalFilename();

        //  Carou directory exists or not
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Check the number of existing files in the
        // database
        long fileCount = ar1.count();

        if (fileCount >= MAX_FILES) {

            throw new IOException("File limit reached" +
                    ".Please delete an entry before " +
                    "uploading a new  one.");
        }

        // save the file in the directory
        File fileToSave =
                new File(UPLOAD_DIR + File.separator + fileName);
        mfile.transferTo(fileToSave);

        // Save the file entity to the DB
        AboutPojo ap1 = new AboutPojo();
        ap1.setAbUrl(fileName);
        return ar1.save(ap1);
    }


    // Delete file and remove file name from DB
    public void deleteFile(int id) {
        Optional<AboutPojo> ap1Optional = ar1.findById(id);

        if (ap1Optional.isPresent()) {

            AboutPojo ap1 = ap1Optional.get();
            File file =
                    new File(UPLOAD_DIR + File.separator + ap1.getAbUrl());

            //  safety try to delete the file
            boolean isDeleted = false;
            if (file.exists()) {
                isDeleted = file.delete();
            }
            if (isDeleted) {
                ar1.deleteById(id);
            } else {
                System.out.println("Failed to delete " +
                        "file: " + file.getName());
            }
        }
    }
}