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

public class removeUserPhoneTest {
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

    @After
    public void fecharNavegador()
    {
        taskit.finish();
    }

    @Test
    public void testRemoveUserPhone() {
        taskit.login().goToMoreDataAboutYou();
        driver.findElement(By.xpath("//span[text()=\"+55(11)12345-6789\"]/following-sibling::a")).click();
        driver.switchTo().alert().accept();
        taskit.validateToastMessage("Rest in peace, dear phone!");
    }
}
