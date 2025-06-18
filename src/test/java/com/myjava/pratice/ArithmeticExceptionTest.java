package com.myjava.pratice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticExceptionTest {
    @Test
    public void ArithmeticTest(){
        Arithmetic arithmetic = new Arithmetic();
        int a =10;
        int b =2;
        int result = arithmetic.division(a,b);
        Assertions.assertEquals(5,result);

        a= 10;
        b= 0;
        try{
            result = arithmetic.division(a,b);
            Assertions.fail();
        } catch (ArithmeticException e) {
            Assertions.assertNotNull(e);
           // Assertions.assertEquals("you can't divide number by 0",e.getMessage());
        }
    }
}
