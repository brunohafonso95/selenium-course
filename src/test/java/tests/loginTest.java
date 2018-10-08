package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.TaskitPage;

import static org.junit.Assert.*;

public class loginTest {
    protected WebDriver driver;
    protected TaskitPage taskit;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/bhenriquea/Desktop/webdriverjava/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        taskit = new TaskitPage(driver);
        taskit.init("http://www.juliodelima.com.br/taskit/");
    }

    @Test
    public void testUserLogin() {
        taskit.login().wait(3);
        WebElement userSignedLabel = driver.findElement(By.className("me"));
        assertEquals("Hi, Bruno Afonso", userSignedLabel.getText());
    }
}
