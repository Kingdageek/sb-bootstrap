package com.udacity.bootstrap.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streams")
public class StreamController {
    
    @GetMapping("/img")
    public String copyByteFileBuffer() {
        String rootDir = "C:\\Users\\Nonso Mgbechi\\Documents\\DeutschLernen\\DaF-A2.2\\";
        String inFile = rootDir + "Nonso_Mgbechi_Tests.pdf";
        String outFile = rootDir + "Nonso_Mgbechi_Tests_Copy.png";

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
            byte[] byteBuffer = new byte[4000];
            int bytesRead;
            while( (bytesRead = in.read(byteBuffer)) != -1) {
                out.write(byteBuffer, 0, bytesRead);
            }
            return "Success";
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "failed";
    }
}
