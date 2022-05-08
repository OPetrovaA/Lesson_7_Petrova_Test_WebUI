import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostAdsPage {
    WebDriver driver;
    public PostAdsPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a/span[text()='+ Разместить объявление']")
    private WebElement btnPostAds;

    @FindBy(xpath = "//div[@data-mark='switcher_button||true']")
    private WebElement btnOwner;

    public String clickBtnPostAds(){
        btnPostAds.click();
        return driver.getTitle();
    }


}


