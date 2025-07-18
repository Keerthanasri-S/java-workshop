package com.myjava.pratice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileTest {
    @Test
    public void ReadFiletest() throws IOException {
        FileOperation readfile = new FileOperation();
        String filename = "sample.txt";
        String content = "This is the empty file and we are creating a new file";

        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();

        String actualcontent = readfile.readFile(filename);
        Assertions.assertEquals(content,actualcontent);
    }
}
