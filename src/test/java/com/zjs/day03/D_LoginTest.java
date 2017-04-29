package com.zjs.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/4/15.
 */
public class D_LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
        driver.get("http://mail.163.com");
    }

    @Test
    public void registerTest() throws InterruptedException {

        login(driver,"meyoungtester","meyoung123");

        //显示等待（线程等待、全局等待）
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String logout = driver.findElement(By.linkText("退出")).getText();

        Assert.assertEquals(logout,"退出");
    }


    @Test
    public void error() throws InterruptedException {
        login(driver,"abc","123456");


        //显示等待（线程等待、全局等待）
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"neeror\"]/div[2]")));

        String logout = driver.findElement(By.xpath("//*[@id=\"neeror\"]/div[2]")).getText();

        Assert.assertEquals(logout,"账号或密码错误");
    }

    public static void login(WebDriver driver,String email,String pwd) {
        //转交控制权
        driver.switchTo().frame("x-URS-iframe");

        //点击去注册按钮
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();

    }



    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
