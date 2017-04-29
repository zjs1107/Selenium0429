package com.zjs.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by z on 2017/3/31.
 */
public class D_OpenBrowerTest {
    @Test
    public void openFF(){
        //48版本以前的firefox不需要任何driver就可以启动
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openF2(){
        System.setProperty("webdriver.firefox.bin","c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

    }

    @Test
    public  void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
        //支持IE7/8/9/10/11  selenium3.0 就不支持IE7/8了
    }


    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\IEDriverServer.exe");
        WebDriver webDriver= new InternetExplorerDriver();
    }

    @Test
    public void openEdge(){
        //驱动没下载，暂时不可用
        //System.setProperty("webdriver.edgee.driver","C:\\Users\\z\\IdeaProjects\\selenium2\\drivers\\IEDriverServer.exe");
        WebDriver webDriver= new EdgeDriver();
    }



}
