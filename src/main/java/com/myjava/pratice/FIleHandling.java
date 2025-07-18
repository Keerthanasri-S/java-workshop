package com.myjava.pratice;

import java.io.*;

public class FIleHandling {

    public static void main(String[] args) throws IOException {
        File file = new File("sample1.txt");

       Reader reader = new FileReader(file);

        int ch;
       while((ch = reader.read()) != -1){
            System.out.print((char) ch);
        }
        reader.close();
        Writer writer = new FileWriter(file,true);
        writer.append("sri");
        writer.close();
        }
    }



