package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by z on 2017/4/22.
 */
public class LoginPage {
    //定义email文本框定位方式
    public static By emialInput = By.name("email");
    //密码
    public static By pwdInput = By.name("password");
    //登陆按钮
    public static By loginButton = By.id("dologin");

    //去注册
    public static By zhuceButton = By.id("changepage");
}
