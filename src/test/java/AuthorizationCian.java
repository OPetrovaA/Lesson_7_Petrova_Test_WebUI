import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import sun.plugin.dom.core.Element;

import java.util.concurrent.TimeUnit;

public class AuthorizationCian {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    String myIdLogin = "Ваш E-mail: yagejo7360@moonran.com";

    @BeforeEach
    public void setUp(){
        Data getData = new Data();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getData.getUrl);
       // String title = driver.getTitle();
       // Assertions.assertTrue(title.equals("Циан - база недвижимости в Московской области | Продажа, аренда квартир и другой недвижимости"));
    }

    @Test
    public void signIn(){
        LoginPage loginPage = mainPage.clickSingIn().clickSingIn();
        String parametr = loginPage.getAttribute("innerText");
        System.out.println(parametr);
        Assertions.assertEquals(myIdLogin, parametr, "Authorization failed");
    }

    @AfterEach
    @DisplayName("Тест завершен")
    public void testClose() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}


