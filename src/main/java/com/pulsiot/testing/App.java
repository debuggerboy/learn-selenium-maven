package com.pulsiot.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main() {
        // Set Driver path
        System.setProperty("webdriver.chrome.driver", "C:\\AUTOMATION\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //open google
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //enter linux tutorials in search box
        driver.findElement(By.name("q")).sendKeys("Linux Tutorials");

        //wait for suggestions
        //WebDriverWait wait=new WebDriverWait(driver, 20);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sbtc")));

        WebElement list=driver.findElement(By.className("sbtc"));
        List rows=list.findElements(By.tagName("li"));

        for(WebElement elem:rows) {
            System.out.println(elem.getText());
        }

    }
}


