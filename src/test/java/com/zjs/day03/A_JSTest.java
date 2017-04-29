package com.zjs.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/4/15.
 */
public class A_JSTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();

    }
    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("document.getElementById(\"kw\").setAttribute(\"value\",\"abced\")");
        Thread.sleep(5000);
    }

    @AfterMethod
    public  void closed() throws InterruptedException {

        driver.close();
    }

}
