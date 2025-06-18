package com.myjava.pratice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class AppendTest {
    @Test
    public  void testappend() throws IOException {
        Appendstring content = new Appendstring();
        String filename = "sample.txt";
        String content1 = "This is new line to append";

        FileWriter writer = new FileWriter(filename,true);
        writer.write(content1);
        writer.close();


        String actualcontent = content.readFile(filename);


        Assertions.assertTrue(actualcontent.contains(content1));
    }

}
