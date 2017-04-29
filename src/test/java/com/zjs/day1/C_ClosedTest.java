package com.zjs.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/3/31.
 */
public class C_ClosedTest {

    @Test
    public  void closeChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        WebDriver webDriver= new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗口
        webDriver.close();

    }

    @Test
    public  void closeChrome2() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        WebDriver webDriver= new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //完全退出浏览器
        webDriver.quit();

    }

}
