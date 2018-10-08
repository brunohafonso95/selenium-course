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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.TaskitPage;

public class toastMessageDesapearTest {
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
    public void testToastMessageDesapear() {
        taskit.login().goToMoreDataAboutYou();
        driver.findElement(By.xpath("//div[@id=\"moredata\"]//button[@data-target=\"addmoredata\"]")).click();
        taskit.wait(3);
        WebElement addMoreDataModal = driver.findElement(By.id("addmoredata"));
        WebElement comboBoxMoreDataMoral = addMoreDataModal.findElement(By.name("type"));
        new Select(comboBoxMoreDataMoral).selectByValue("phone");
        taskit.wait(3);
        addMoreDataModal.findElement(By.name("contact")).sendKeys("+55(11)12345-689");
        addMoreDataModal.findElement(By.linkText("SAVE")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        WebElement toastMessageContainer = driver.findElement(By.id("toast-container"));
        WebElement toastMessage = toastMessageContainer.findElement(By.className("toast"));
        explicitWait.until(ExpectedConditions.stalenessOf(toastMessage));
        taskit.screenshot("toastMessageDesapear.png");
    }
}
