package com.zjs.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by z on 2017/4/15.
 */
public class E_SendEmail {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com");
    }

    @Test
    public void SendEmailTest(){
        D_LoginTest.login(driver,"meyoungtester","meyoung123");

        //点击写信
        driver.findElement(By.xpath(" .//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("hahaha");
        //主题文本框
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("邮件主题");
        //上传文件
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\abc.txt");

        //定位iframe
        WebElement iframe1 = driver.findElement(By.className("APP-editor-iframe"));

        driver.switchTo().frame(iframe1);
        driver.findElement(By.xpath("/html/body")).sendKeys("内容");

     //控制权转交回来
        driver.switchTo().defaultContent();

        //点击发送按钮
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        //验证
        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);

    }
}
