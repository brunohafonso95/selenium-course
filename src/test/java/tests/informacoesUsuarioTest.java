package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.jws.WebService;

public class informacoesUsuarioTest {
    WebDriver driver;

    @Before
    public void abrirNavegador()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/bhenriquea/Desktop/webdriverjava/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com.br");
    }

    @After
    public void fecharNavegador()
    {
        driver.quit();
    }


    @Test
    public void testAdicionarInformacaoUsuario()
    {
        assertEquals("","");
    }
}
