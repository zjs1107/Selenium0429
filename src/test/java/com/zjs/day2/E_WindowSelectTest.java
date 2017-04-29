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
public class E_WindowSelectTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击Open new window
     * 点击新窗口中的baidu
     */


    @Test
    public void WindowSelectTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        WebElement selectEl = driver.findElement(By.className("open"));
        selectEl.click();
        Thread.sleep(2000);

        //获取当前窗口句柄
        String handle = driver.getWindowHandle();
        //获取所有页面的句柄，并循环判断不是当前的句柄，就做切换switchTo（）
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        Thread.sleep(2000);

        //点击baidu链接
        driver.findElement(By.className("baidu")).click();

        Thread.sleep(2000);
        driver.switchTo().window(handle);

    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
