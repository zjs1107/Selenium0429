package com.zjs.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by z on 2017/4/8.
 * 作业：找个下载页面，并完成下载功能的自动化实现
 *
 */
public class HomeWork {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
         driver= new ChromeDriver();

    }

    @Test
    public void DownLoad() throws InterruptedException, AWTException {

        driver.get("https://www.baidu.com/baidu?wd=qq&tn=monline_dg&ie=utf-8");

        driver.findElement(By.xpath(".//*[@id='2']/div[2]/div/div[1]/div[2]/p[6]/a")).click();

    }

    @AfterMethod
    public  void closed() throws InterruptedException {

       // driver.quit();
    }

}

