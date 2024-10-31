package com.sankar.rotary.members3mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class MemService {

    @Autowired
    private MemRepo mr1;
    private static final String UPLOAD_DIR = "D:/DATCH" +
            "/Springboot/rotary" +
            "/uploads/Members";

    public MemPojo saveMem(MultipartFile mfile,
                            MemPojo mp) throws IOException {
        String fileName = mfile.getOriginalFilename();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File fileToSave =
                new File(UPLOAD_DIR + File.separator + fileName);
        mfile.transferTo(fileToSave);

        mp.setmUrl(fileName);

        return mr1.save(mp);
    }


    public void deleteMem(int id) {
        Optional<MemPojo> mpOptional = mr1.findById(id);

        if (mpOptional.isPresent()) {
            MemPojo mp = mpOptional.get();
            File fileToDelete =
                    new File(UPLOAD_DIR + File.separator + mp.getmUrl());
            boolean isDeleted = false;
            if (fileToDelete.exists()) {
                isDeleted=fileToDelete.delete();
            }
            if(isDeleted){
                mr1.deleteById(id);
            }else{
                System.out.println("Failed to Delete " +
                        "File"+mp.getmUrl());
            }
        }
    }

}