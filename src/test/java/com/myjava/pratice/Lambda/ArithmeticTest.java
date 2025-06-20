package com.myjava.pratice.Lambda;

import com.myjava.Generic.Arithmetic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticTest {
    @Test
    public void testoperation(){
        Arithmetic addition = (int x,int y)->x+y;
        Assertions.assertEquals(40,addition.calculate(20,20));
    }
    @Test
    public void testSubtraction(){
        Arithmetic subtract = (int x,int y)->x-y;
        Assertions.assertEquals(5,subtract.calculate(10,5));
    }
    @Test
    public void testMultiplication(){
        Arithmetic multiply = (int x,int y)->x*y;
        Assertions.assertEquals(50,multiply.calculate(10,5));
    }
    @Test
    public void testDivision(){
        Arithmetic divide = (int x,int y)->x/y;
        Assertions.assertEquals(5,divide.calculate(25,5));
    }
    @Test
    public void testModulo(){
        Arithmetic modulo = (int x,int y)->x%y;
        Assertions.assertEquals(0,modulo.calculate(10,5));
    }
}
