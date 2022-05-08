import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/authenticate/?returnUrl=https://www.cian.ru/']")
    private WebElement btnVoity;

    @FindBy(xpath = ".//button[@data-name='SwitchToEmailAuthBtn']")
    private WebElement btnDrugoySposob;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement inputLogEmail;

    @FindBy(xpath = "//button[@data-name='ContinueAuthBtn']")
    private WebElement btnContinue;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(xpath = ".//div[@class='_25d45facb5--buttons--f0vot']")
    private WebElement btnVoityFinish;

    @FindBy(xpath = ".//a[@data-name='UserAvatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//a[@class='_25d45facb5--full-name--K5jY5']")
    private WebElement actualIdLogin;

    @FindBy(xpath = "//div[@class='register_step_content']")
    private WebElement stepEmail;

    public LoginPage clickSingIn(){
        btnVoity.click();
        return this;
    }

    public LoginPage clickBtnDrugoySposob(){
        btnDrugoySposob.click();
        return this;
    }

    public LoginPage typeEmail(String logEmail){
        inputLogEmail.sendKeys(logEmail);
        return this;
    }

    public LoginPage clickBtnContinue(){
        btnContinue.click();
        return this;
    }

    public LoginPage typePassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickBtnVoity() {
        btnVoityFinish.click();
        return this;
    }

    public MainPage clickAvatar(){
        userAvatar.click();
        return new MainPage(driver);
    }
    public MainPage actualLogin(){
        actualIdLogin.click();
        return new MainPage(driver);
    }

    public LoginPage authorization(String logEmail, String password) {
        this.clickSingIn();
        this.clickBtnDrugoySposob();
        this.typeEmail(logEmail);
        this.clickBtnContinue();
        this.typePassword(password);
        this.clickBtnVoity();
        return this;
    }

    public String authorizationSuccessful(){
        this.clickAvatar();
        this.actualLogin();
        return stepEmail.getAttribute("innerText");
    }

    public String getAttribute(String innerText) {
        return stepEmail.getAttribute("innerText");
    }
}
