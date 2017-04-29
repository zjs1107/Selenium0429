package com.zjs.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/3/30.
 */
public class B_TestNGDemo2 {
    //校验 相等
    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf1111";
        // Assert.assertEquals(a,b,"a不等于b" );
        Assert.assertEquals(a,b);
    }

    //校验为空
    @Test
    public void assertNotEqualsTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b );

    }

    //校验 不为空
    @Test
    public void assertEqualsTest(){
        int a = 1;
        int b = 2;
        Assert.assertEquals(a,b );

    }

    //校验 等于空
    @Test
    public void assertNull(){
        String a = null;
        Assert.assertNull(a);

    }


}
