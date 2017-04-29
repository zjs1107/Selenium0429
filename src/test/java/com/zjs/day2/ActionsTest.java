package com.zjs.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


/**
 * Created by z on 2017/4/8.
 */
public class ActionsTest {
    /**
     * 我要点击百度首页的新闻链接
     * 那么我打开了新闻页面
     */

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        driver= new ChromeDriver();
    }

    @Test
    public void clickTest(){
        driver.get("http://www.baidu.com");
        //定位
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newslink.click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入selenium
     * 点击搜索按钮
     * 校验title是否等于“selenium_百度搜索<”
     */
    @Test
    public void baiduTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位输入框
        WebElement keysInput = driver.findElement(By.id("kw"));
        //搜索框输入selenium
        keysInput.sendKeys("selenium");
        //定位百度一下按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
        //点击
        baiduButton.click();
        //等待
        Thread.sleep(3000);

        //获取页面title
        String title = driver.getTitle();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 打开百度首页
     * 输入selenium
     * 清空搜索框
     */
    @Test
    public void baiduTest2() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位输入框
        WebElement keysInput = driver.findElement(By.id("kw"));
        //搜索框输入selenium
        keysInput.sendKeys("selenium");

        //等待
        Thread.sleep(3000);

        //清空搜索框
        keysInput.clear();
        //等待
        Thread.sleep(3000);

    }

    /**
     * 打开百度首页
     * 输入selenium
     * 搜索框中的文本
     * 校验是否为“selenium”
     * 清空文本框
     * 再次获取
     * 校验文本是否为空
     *
     * getText()获取的是标签中间的值，所以下面这个case是个错误的case
     */
    @Test
    public void baiduTest3() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位输入框
        WebElement keysInput = driver.findElement(By.id("kw"));
        //搜索框输入selenium
        keysInput.sendKeys("selenium");
        Thread.sleep(2000);
        String text1 = keysInput.getText();
        keysInput.clear();
        Thread.sleep(2000);
        String text2 = keysInput.getText();
        Thread.sleep(2000);
        //校验
        Assert.assertEquals(text1,"selenium");
        Assert.assertEquals(text2,"");
    }

    /**
     * 打开百度首页
     * 获取新闻的文本
     */
    @Test
    public void baiduTest4() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位新闻
        String text1 = driver.findElement(By.name("tj_trnews")).getText();

        //校验
        Assert.assertEquals(text1,"新闻");

    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public  void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagname = driver.findElement(By.id("kw")).getTagName();
//        if (tagname.equals("input")){
//            System.out.println("OK");
//        }else{
//            System.out.println("error");
//        }
        Assert.assertEquals(tagname,"input");
    }

    /**
     * 打开百度首页
     * 判断按钮显示的文本是否为  百度一下
     */
    @Test
    public  void getAttributeTest(){
        driver.get("http://www.baidu.com");
        String attributeValue = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue,"百度一下");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度按钮
     */
    @Test
    public  void isDisplayedTest(){
        driver.get("http://www.baidu.com");
        Boolean boolvalue = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(boolvalue);
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框是否被选中
     */
    @Test
    public  void isSelectTest(){
        driver.get("file:///c:/selenium_html/index.html");
        Boolean boolvalue = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).isDisplayed();

        Assert.assertTrue(boolvalue,"校验单选框已选中");
    }

    /**
     * 打开测试页面
     * 判断submit按钮为为不可点击状态
     */
    @Test
    public  void isEnableTest(){
        driver.get("file:///c:/selenium_html/index.html");
        Boolean boolvalue = driver.findElement(By.name("buttonhtml")).isEnabled();

        Assert.assertFalse(boolvalue);
    }

    /**
     * 截图百度首页
     */
    @Test
    public  void screenShotFile(){
        driver.get("http://www.baidu.com");

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShotFile,new File("C:/ztest/test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public  void closed() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
