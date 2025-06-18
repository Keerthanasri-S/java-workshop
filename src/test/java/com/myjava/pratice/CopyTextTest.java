package com.myjava.pratice;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class CopyTextTest {
    @Test
    public void testcopy() throws IOException {
        Copytext copytext = new Copytext();
        String filename = "sample.txt";
        String anotherfilename = "text.txt";

        Copytext copier = new Copytext();
        String copied = copier.copytext("sample.txt", "text.txt");



    }
}
