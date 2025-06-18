package com.myjava.pratice;

import java.io.File;
import java.io.IOException;

public class ThreefilesCreated {

    public void createfile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();

    }
}
