package pageObject;

import java.io.File;
import java.sql.Timestamp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class TaskitPage extends BasePage {
   public TaskitPage(WebDriver driver) {
       super(driver);
   }

    public TaskitPage init(String pageUrl) {
        driver.manage().window().maximize();
        driver.get(pageUrl);
        return this;
    }

    public void finish() {
        driver.quit();
    }

    public TaskitPage wait(int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        return this;
    }

    public TaskitPage login() {
        WebElement signinButton = driver.findElement(By.linkText("Sign in"));
        signinButton.click();
        WebElement signinModal = driver.findElement(By.id("signinbox"));
        signinModal.findElement(By.name("login")).sendKeys("brunohafonso");
        signinModal.findElement(By.name("password")).sendKeys("bbc259521");
        signinModal.findElement(By.linkText("SIGN IN")).click();
        return this;
    }

    public TaskitPage goToMoreDataAboutYou() {
        this.wait(3);
        driver.findElement(By.className("me")).click();
        this.wait(3);
        driver.findElement(By.className("tabs")).findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        this.wait(3);
        return this;
    }

    public TaskitPage validateToastMessage(String message) {
        this.wait(3);
        WebElement toastMessageContainer = driver.findElement(By.id("toast-container"));
        String toastMessageText = toastMessageContainer.findElement(By.className("toast")).getText();
        assertEquals(message, toastMessageText);
        return this;
    }

    public TaskitPage screenshot(String fileName) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch(Exception e) {
            System.out.println("Erro ao copiar arquivo para a pasta" + e.getMessage());
        }
        return this;
    }

    public String dataGenerator() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(ts);
    }

    public TaskitPage addUserContactInformation(String type, String contact, String expectedMessage) {
        driver.findElement(By.xpath("//div[@id=\"moredata\"]//button[@data-target=\"addmoredata\"]")).click();
        this.wait(3);
        WebElement addMoreDataModal = driver.findElement(By.id("addmoredata"));
        WebElement comboBoxMoreDataMoral = addMoreDataModal.findElement(By.name("type"));
        new Select(comboBoxMoreDataMoral).selectByValue(type);
        this.wait(3);
        addMoreDataModal.findElement(By.name("contact")).sendKeys(contact);
        addMoreDataModal.findElement(By.linkText("SAVE")).click();
        this.validateToastMessage(expectedMessage);
        return this;
    }
}
