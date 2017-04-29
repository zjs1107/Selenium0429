package com.zjs.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/4/8.
 */
public class D_SelectTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    /**
     * 三种处理方式：
     1. selectByIndex() 根据索引来选取，从0开始
     2. selectByValue() 根据属性value的属性值来选取
     3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
        Select select = new Select(selectEl);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByValue("meizu");
        Thread.sleep(2000);
        select.selectByVisibleText("xiaomi");
    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
