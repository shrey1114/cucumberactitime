package com.envision.actitime.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String rm;

    private static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        if (rm.equalsIgnoreCase("headless")){
           co.addArguments(rm);
         }
        driver.set(new ChromeDriver(co));
    }

    private static void openEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions eo = new EdgeOptions();
        driver.set(new EdgeDriver(eo));
    }

    private static void openFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions fo = new FirefoxOptions();
        driver.set(new FirefoxDriver(fo));
    }


    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase().intern()) {
            case "chrome":
                openChromeBrowser();
                break;
            case "edge":
                openEdgeBrowser();
                break;
            case "firefox":
                openFirefoxBrowser();
                break;
            default:
                System.out.println("Please Enter Browser from: MS Edge, Google Chrome, Mozilla FireFox");
        }
        return driver.get();
    }

    public static WebDriver getBrowser(String browserName, String runMode) {
        rm = runMode;
        return getBrowser(browserName);
    }

    public static WebDriver getBrowser() {
        return driver.get();
    }

    public static void openUrl(String url) {
        driver.get().get(url);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get().manage().window().maximize();
    }

    public static void closeCurrentBrowserWindow() {
        driver.get().close();
    }

    public static void exitBrowser() {
        driver.get().quit();
    }
}