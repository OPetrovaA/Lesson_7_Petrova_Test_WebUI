import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/authenticate/?returnUrl=https://www.cian.ru/']")
    private WebElement btnVoity;

    @FindBy(xpath = "//a/span[text()='+ Разместить объявление']")
    private WebElement btnPostAds;

    @FindBy(xpath = ".//button[@data-name='SwitchToEmailAuthBtn']")
    private WebElement btnDrugoySposob;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement inputLogEmail;

    @FindBy(xpath = "//button[@data-name='ContinueAuthBtn']")
    private WebElement btnContinue;

    @FindBy(xpath = ".//span[@class='_25d45facb5--box--FHmxp _25d45facb5--box--LJe53']")
    private WebElement checkboxOk;

    @FindBy(xpath = "//button[@data-name='ContinueBtn']")
    private WebElement btnContinue2check;

    @FindBy(xpath = "//input[@autocomplete='new-password']")
    private WebElement newPassword;

    //private By inputPassword = By.name("password");
    @FindBy(xpath = ".//div[@class='_25d45facb5--buttons--f0vot']")
    private WebElement btnVoityFinish;

    @FindBy(xpath = "//div[@class='register_step_content']")
    private WebElement stepEmail;

    @FindBy(xpath = "//h3[@class='_25d45facb5--title--OSQN1 _25d45facb5--large_indent--YwY6z']")
    private WebElement actualRegOk;

    @FindBy(xpath = "//span[@class='_25d45facb5--error-message--NCPjP']")
    private WebElement errorPassActual;

    @FindBy(xpath = ".//a[@data-name='UserAvatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//a[@class='_25d45facb5--full-name--K5jY5']")
    private WebElement actualIdLogin;


    public LoginPage clickSingIn() {
        btnVoity.click();
        return new LoginPage(driver);
    }

    public LoginPage clickBtnDrugoySposob() {
        btnDrugoySposob.click();
        return new LoginPage(driver);
    }

    public LoginPage clickBtnContinue() {
        btnContinue.click();
        return new LoginPage(driver);
    }

    public NewRegistration clickBtnContinue2check() {
        btnContinue2check.click();
        return new NewRegistration(driver);
    }

    public MainPage typeEmail(String newLogEmail) {
        inputLogEmail.sendKeys(newLogEmail);
        return this;
    }

    public LoginPage clickСheckboxOk() {
        checkboxOk.click();
        return new LoginPage(driver);
    }

    public MainPage typeNewPassword(String password) {
        newPassword.sendKeys(password);
        return this;
    }

    public NewRegistration clickBtnRegist() {
        btnVoityFinish.click();
        return new NewRegistration(driver);
    }

    public PostAdsPage btnPostAds() {
        btnVoity.click();
        return new PostAdsPage(driver);
    }

    public LoginPage registration(String newLogEmail, String password) {
        this.clickSingIn();
        this.clickBtnDrugoySposob();
        this.typeEmail(newLogEmail);
        this.clickBtnContinue();
        this.clickСheckboxOk();
        this.clickBtnContinue2check();
        this.typeNewPassword(password);
        this.clickBtnRegist();
        return new LoginPage(driver);
    }

    public MainPage clickAvatar() {
        userAvatar.click();
        return this;
    }

    public MainPage actualLogin() {
        actualIdLogin.click();
        return this;
    }

    public String authorizationSuccessful() {
        this.clickAvatar();
        this.actualLogin();
        return stepEmail.getAttribute("innerText");

    }


}
