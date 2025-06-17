package com.myjava.pratice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordcountTest {

    private Assertions Assertion;

    @Test
    public void testWordcount(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("String is immutable object");
        Assertion.assertEquals(4,count);
    }
    @Test
    public void testWordcountwithoutspace(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("Stringisimmutableobject");
        Assertion.assertEquals(1,count);
    }
    @Test
    public void testWordcountDoublespace(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("String  is");
        Assertion.assertEquals(2,count);
    }
    @Test
    public void testWordcountwithcomma(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("Stringis, immutableobject");
        Assertion.assertEquals(2,count);
    }
    @Test
    public void testWordcountwithspecialcharacter(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("Stringisimmutableobject ,@#$");
        Assertion.assertEquals(2,count);
    }
    @Test
    public void testWordcountwithsinglequotes(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("Stringisimmutable 'object'");
        Assertion.assertEquals(2,count);
    }
    @Test
    public void testWordcountwithDoublequotes(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("Stringisimmutable \"object\"");
        Assertion.assertEquals(2,count);
    }
    @Test
    public void testWordcountisEmpty(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("");
        Assertion.assertEquals(0,count);
    }
    @Test
    public void testWordcountisNull(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count(null);
        Assertion.assertEquals(0,count);
    }
    @Test
    public void testWordcountBiggerString(){
        Wordcount wordcount = new Wordcount();
        int count = wordcount.count("String is immutable object and it stores values as array");
        Assertion.assertEquals(10,count);
    }



}
