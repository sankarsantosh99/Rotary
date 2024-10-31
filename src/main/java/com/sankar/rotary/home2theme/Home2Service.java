package com.sankar.rotary.home2theme;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class Home2Service {

    @Autowired
    private Home2Repo h2r;

    private static final String UPLOAD_DIR
            = "D:/DATCH/Springboot/rotary" +
            "/uploads/Home2Uploads";

    // Saving the file to directory and storing
    // the file name in the DB
    public Home2Pojo saveFile(String theme,
                              MultipartFile file) throws IOException {
        String fileName =
                file.getOriginalFilename();

        try {
            // checking the Home2Uploads directory
            // exists
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                if (!uploadDir.mkdirs()) {
                    throw new IOException(
                            "Failed to create " +
                                    "Home1Uploads" +
                                    "directory");
                }
            }

            // Store the file in the folder
            File fileToSave =
                    new File(UPLOAD_DIR + File.separator + fileName);
            file.transferTo(fileToSave);

            // Save file name to DB
            Home2Pojo h2p =
                    new Home2Pojo();
            h2p.setThYear(theme);
            h2p.setFileName(fileName);
            return h2r.save(h2p);

        } catch (IOException e) {
            throw new IOException("Failed to " +
                    "store file " + fileName, e);
        }
    }


    // Delete file and remove file name from DB
    public void deleteFile(int id) {
        Optional<Home2Pojo> h2pOptional =
                h2r.findById(id);

        if (h2pOptional.isPresent()) {
            Home2Pojo h2p =
                    h2pOptional.get();
            File file =
                    new File(UPLOAD_DIR + File.separator + h2p.getFileName());

            //  safety try
            // to delete the file
            boolean isDeleted = false;
            if (file.exists()) {
                isDeleted = file.delete();
            }
            // Only delete the record from
            // the DB if the file deletion
            // was successful
            if (isDeleted) {
                h2r.deleteById(id);
            } else {
                // deletion failed case
                System.out.println("Failed to " +
                        "delete file: " + file.getName());
            }
        }
    }


    // Retrieve a file by its ID
    public Home2Pojo getFileById(int id) {
        return h2r.findById(id).orElse(null);
    }
}


