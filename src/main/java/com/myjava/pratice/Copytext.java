package com.myjava.pratice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copytext {
    public String copytext(String filename, String anotherfilename) throws IOException {
        FileReader reader = new FileReader(filename);
        FileWriter writer = new FileWriter(anotherfilename);
        StringBuilder copiedContent = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {  // ascii value
            writer.write(ch);
            copiedContent.append((char)ch);// store as character
        }
        reader.close();
        writer.close();
        return copiedContent.toString();
    }
}
