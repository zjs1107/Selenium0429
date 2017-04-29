package com.zjs.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by z on 2017/4/2.
 */
public class F_FindElementsTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    //id定位
    @Test
    public void byIDTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }

    //name定位
    @Test
    public void byNameTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    //class定位
    @Test
    public void byClassTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("s_ipt"));
    }

    //部分链接文本定位
    @Test
    public void byLinkTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("糯米"));
    }

    //部分链接文本定位
    @Test
    public void byPartialLinkTextTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("糯"));
    }

    //通过标签名定位,用的很少，很少用
    @Test
    public void byTagnameTest(){
        driver.get("http://www.baidu.com");
        List<WebElement> list=driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }

    //通过xpath
    @Test
    public void byXpathTest(){
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath(".//*[@id='su']"));

    }

    //通过css
    @Test
    public void byCss(){
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.cssSelector("#su"));

    }

    //定位多个按钮
    @Test
    public void byXpath02Test(){
        driver.get("http://www.baidu.com");
        List<WebElement> list=driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < list.size(); i++) {
            String test = list.get(i).getText();
            System.out.println(test);
        }
    }

    @AfterMethod
    public  void closedBrowser(){
        driver.quit();
    }
}
