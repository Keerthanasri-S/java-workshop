package com.myjava.pratice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Appendstring {
    public void createfile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
    }

    public String readFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        StringBuilder readf = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {  // ascii value
            readf.append((char) ch); // store as character
        }
        reader.close();
        return readf.toString();
    }
}