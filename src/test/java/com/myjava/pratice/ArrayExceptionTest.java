package com.myjava.pratice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayExceptionTest {
    @Test
    public void ArrayTest(){
         Arrayindex arrayindex = new Arrayindex();
         int []number ={10,20,30,40,50};
         int index=3;
         int result = arrayindex.number(number,index);
        Assertions.assertEquals(40,result);

          index=5;
          try{
              result= arrayindex.number(number,index);
              Assertions.fail();
          } catch (ArrayIndexOutOfBoundsException e) {
             Assertions.assertNotNull(e);
             Assertions.assertEquals("Index out of bound",e.getMessage());
          }

    }

}
