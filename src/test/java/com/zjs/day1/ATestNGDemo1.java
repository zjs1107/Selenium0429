package com.zjs.day1;

import org.testng.annotations.*;

/**
 * Created by z on 2017/3/30.
 */
public class ATestNGDemo1 {
    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是@beforeTest注解");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("这是@AfterTest注解");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("这是@BeforeMethod注解");
    }

   @AfterMethod
   public void AfterMethod(){
       System.out.println("这是@AfterMethod注解");
   }

    @Test
    public void testCase1(){
        System.out.println("这是@test注解,case1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是@test注解.case2");
    }

}
