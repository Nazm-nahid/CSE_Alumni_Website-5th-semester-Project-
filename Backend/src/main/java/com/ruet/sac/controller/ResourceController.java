package com.ruet.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@CrossOrigin(origins = "*")
@RequestMapping("/resource")
@RestController
public class ResourceController {
    @Autowired
    ResourceLoader resourceLoader;
    @GetMapping(
            value = "/images",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("imageName") String imageName) throws IOException {
        Resource resource=resourceLoader.getResource("classpath:/images/"+imageName);

        File file = resource.getFile();



        return  Files.readAllBytes(file.toPath());
    }
}
