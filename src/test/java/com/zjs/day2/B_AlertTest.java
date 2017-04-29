package com.zjs.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/4/8.
 */
public class B_AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    /**
     * 1. 打开“ UI自动化测试”主页
     2. 点击Alert按钮
     3. 在alert警告框点击确定按钮
     */

    @Test
    public  void alertTest() throws InterruptedException{
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //切换控制权
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     * 1. 打开“ UI自动化测试”主页
     2. 点击Confirm按钮
     3. 在Confirm警告框点击确定\取消按钮
     */
    @Test
    public  void confirmTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        //点击confirm的确定按钮
        //alert.accept();

        //点击confirm的取消按钮
        alert.dismiss();
    }

    /**
     * 1. 打开“ UI自动化测试”主页
     2. 点击prompt按钮
     3.在输入框中输入文本
     4.点击确定
     */
    @Test
    public  void promptTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        driver.quit();
    }



    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
