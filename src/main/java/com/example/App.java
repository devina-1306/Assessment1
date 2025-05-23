package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
    public static void main(String[] args) {
        String browser = "chrome"; // change to "firefox" if needed
        WebDriver driver = null;

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.get("https://www.coursera.org/");
            Thread.sleep(5000); // wait for search box to load

            WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
            System.out.println("ID: " + searchBox.getAttribute("id"));
            System.out.println("Name: " + searchBox.getAttribute("name"));
            System.out.println("Class Name: " + searchBox.getAttribute("class"));
            System.out.println("CSS Value (font-size): " + searchBox.getCssValue("font-size"));

            WebElement loginLink = driver.findElement(By.linkText("Log In"));
            System.out.println("Login Link Text: " + loginLink.getText());

            WebElement partialLoginLink = driver.findElement(By.partialLinkText("Log"));
            System.out.println("Partial Link Text: " + partialLoginLink.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
