package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @Description: selenium demo
 * @Author : 郑玮泽
 * @Date : 11:19 2020/8/25
 */
public class HelloSelenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\common-software\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).toMillis());
        try {
            driver.get("https://www.cotroncloud.com/");
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            //WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            //System.out.println(firstResult.getAttribute("textContent"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
