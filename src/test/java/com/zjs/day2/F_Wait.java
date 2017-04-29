package com.zjs.day2;

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
 * Created by z on 2017/4/8.
 */
public class F_Wait {
    /**
     * 打开测试界面
     * 点击wait按钮
     * 获取文本，判断文本是否为“wait for display”
     */
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();

        //全局等待
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void WaitTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        //线程等待，很不灵活，不推荐
//        Thread.sleep(5000);

        //显示等待，大力推荐的方案
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();

        Assert.assertEquals(text,"wait for display");

    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
