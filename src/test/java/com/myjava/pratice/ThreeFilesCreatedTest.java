package com.myjava.pratice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ThreeFilesCreatedTest {
    @Test
    public void testthreefile(){
        ThreefilesCreated fileOperation = new ThreefilesCreated();
        fileOperation.createfile("text.txt");
        fileOperation.createfile("input.txt");
        fileOperation.createfile("output.txt");
        File file1 = new File("text.txt");
        File file2 = new File("input.txt");
        File file3 = new File("output.txt");
        Assertions.assertTrue(file1.exists());
        Assertions.assertTrue(file2.exists());
        Assertions.assertTrue(file3.exists());
    }
}
