package com.zjs.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/4/8.
 */
public class C_IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    /**
     * 打开测试界面
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        //通过ID或者Name的方式转交控制权
        //driver.switchTo().frame("aa");

        //通过webelement方式
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);

        driver.findElement(By.linkText("baidu")).click();

        Thread.sleep(3000);

        //将driver控制权转交给原来的frame
        driver.switchTo().defaultContent();
        driver.findElement(By.className("baidu")).click();
    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
