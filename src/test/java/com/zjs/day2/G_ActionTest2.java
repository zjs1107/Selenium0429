package com.zjs.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by z on 2017/4/8.
 */
public class G_ActionTest2 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();

    }

    /**
     * 打开百度
     * 在百度一下上右键
     * @throws InterruptedException
     */
    @Test
    public void WaitTest() throws InterruptedException {
        //打开百度页面
        driver.get("http://www.baidu.com");

        //定位百度一下按钮
        WebElement baiduBtn = driver.findElement(By.id("su"));
        //new action 对象
        Actions actions = new Actions(driver);

        //actions.contextClick().build().perform();
        //在百度一下按钮上右键
        actions.contextClick(baiduBtn).perform();

        //双击百度一下按钮
        actions.doubleClick(baiduBtn).perform();

    }

    /**
     * 打开测试页面
     * 鼠标移到action按钮上
     * 显示hello world
     */
    @Test
    public void MoveTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化action对象
        Actions builder = new Actions(driver);
        //鼠标移到action按钮上
        builder.moveToElement(element).perform();

        //  xpath   .//*[test()='Hello World!']
        String text = driver.findElement(By.id("over")).getText();

        Thread.sleep(3000);
        Assert.assertEquals(text,"Hello World!");
        //"over"
    }

    @Test
    public  void DropTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/dragAndDrop.html");
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        //实例化action对象
        Actions builder = new Actions(driver);
        Thread.sleep(2000);
        builder.dragAndDropBy(drag,500,500).perform();

    }

    @Test
    public  void  DropTest2() throws InterruptedException {
        driver.get("file:///c:/selenium_html/dragAndDrop.html");

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        WebElement drag2 = driver.findElement(By.xpath("/html/body/h1"));
        //实例化action对象
        Actions builder = new Actions(driver);
        Thread.sleep(2000);
        builder.dragAndDropBy(drag,500,500).perform();
        builder.clickAndHold(drag).moveToElement(drag2).release(drag).perform();

    }

    @Test
    public void MoreSelectTest() throws InterruptedException {
        driver.get("file:///c:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        //取出下拉框中的所有元素
        List<WebElement> options = element.findElements(By.tagName("option"));

        //实例化action对象
        Actions builder = new Actions(driver);

        //选择0,1,2
        builder.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).build().perform();

    }

    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();

        int keyA = (int)new Character('A');

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test
    public void uploadTest(){
        driver.get("file:///c:/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\ztest\test.png");
    }


    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
