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
public class C_RegisterTest {
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

        //转交控制权
        driver.switchTo().frame("x-URS-iframe");

        //点击去注册按钮
        driver.findElement(By.id("changepage")).click();

        //获取当前窗口句柄
        String handle = driver.getWindowHandle();
        //获取所有页面的句柄，并循环判断不是当前的句柄，就做切换switchTo（）
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }

        String time = String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("nameIpt")).sendKeys("abcd"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123123123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(System.currentTimeMillis()/100));

        //图片验证码，让开发人员给一个万能验证码、或者跳过此项验证
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainRegA")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainMobile']/span")));

        String err = driver.findElement(By.xpath(".//*[@id='m_mainMobile']/span")).getText();

        Assert.assertEquals(err,"  手机号码可用");
    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
