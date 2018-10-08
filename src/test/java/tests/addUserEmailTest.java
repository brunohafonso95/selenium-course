package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.TaskitPage;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "addUserEmailTestData.csv")
public class addUserEmailTest {
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
    public void testAddUserEmail(@Param(name="type")String type, @Param(name="contact")String contact, @Param(name="expectedMessage")String expectedMessage) {
        taskit.login()
            .goToMoreDataAboutYou()
                .addUserContactInformation(type, contact, expectedMessage);
    }
}
