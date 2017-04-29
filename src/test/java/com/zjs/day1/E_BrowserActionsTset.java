package com.zjs.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/3/31.
 */
public class E_BrowserActionsTset {
    /*
    打开chrome浏览器
    打开百度首页
    等待5s
    关闭浏览器
     */

    @Test
    public  void  getTest() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        WebDriver webDriver= new ChromeDriver();
        //打开百度首页
        webDriver.get("http://www.baidu.com");
        //等待5s
        Thread.sleep(5000);
        //完全退出浏览器
        webDriver.quit();
    }

        /*
    打开chrome浏览器
    打开百度首页
    等待5s
    后退
    等待3s
    关闭浏览器
     */

    @Test
    public  void  getTest2() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        //实例化 chromeDriver
        WebDriver webDriver= new ChromeDriver();
        //打开百度首页
        webDriver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);

        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);

        //前进
        webDriver.navigate().forward();
        Thread.sleep(3000);

        //刷新
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        //最大化
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        //设置浏览器大小
        Dimension dimension = new Dimension(800,600);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //获取当前页面URL
        String url = webDriver.getCurrentUrl();
        System.out.println(url);
        Thread.sleep(3000);
        //获取当前页面title
        String title = webDriver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        //完全退出浏览器
        webDriver.quit();
    }

}
