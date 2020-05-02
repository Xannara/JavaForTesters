package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private String browser;

    public ApplicationManager(String browser) {
        ApplicationManager.this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.CHROME)) {
            ApplicationManager.this.wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            ApplicationManager.this.wd = new InternetExplorerDriver();
        }
        System.setProperty("webdriver.chrome.driver", "c:\\Windows\\System32\\chromedriver.exe");
        ApplicationManager.this.wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ApplicationManager.this.wd.get(properties.getProperty("web.baseURL"));
    }

    public void logout() {
        ApplicationManager.this.wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        ApplicationManager.this.wd.quit();
    }

    public void returnToHomePage() {
            ApplicationManager.this.wd.findElement(By.linkText("home page")).click();
        }
    }

