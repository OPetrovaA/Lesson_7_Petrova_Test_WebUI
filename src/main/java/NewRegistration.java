import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRegistration {
    WebDriver driver;
    public NewRegistration(WebDriver driver){
        this.driver = driver;
    }

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

    @FindBy(xpath = ".//div[@class='_25d45facb5--buttons--f0vot']")
    private WebElement btnVoityFinish;
    // private By userAvatar = By.xpath(".//a[@data-name='UserAvatar']");
    //private By actualIdLogin = By.xpath("//a[@class='_25d45facb5--full-name--K5jY5']");
    //private By stepEmail = By.xpath("//div[@class='register_step_content']");
    @FindBy(xpath = "//h3[@class='_25d45facb5--title--OSQN1 _25d45facb5--large_indent--YwY6z']")
    private WebElement actualRegOk;

    @FindBy(xpath = "//span[@class='_25d45facb5--error-message--NCPjP']")
    private WebElement errorPassActual;

    public NewRegistration typeEmail(String newLogEmail){
        inputLogEmail.sendKeys(newLogEmail);
        return this;
    }

    public NewRegistration clickBtnContinue(){
        btnContinue.click();
        return this;
    }

    public NewRegistration clickСheckboxOk(){
        checkboxOk.click();
        return this;
    }


    public NewRegistration clickBtnContinue2check(){
        btnContinue2check.click();
        return this;
    }

    public NewRegistration typeNewPassword(String password){
        newPassword.sendKeys(password);
        return this;
    }

    public NewRegistration clickBtnRegist(){
        btnVoityFinish.click();
        return this;
    }

    public NewRegistration inccorectPassword(String newLogEmail, String negativpassword){
    this.typeEmail(newLogEmail);
    this.typeNewPassword(negativpassword);
    btnVoityFinish.click();
    return this;
    }

    public NewRegistration ValidRegistration(String newLogEmail, String password){
        this.typeEmail(newLogEmail);
        this.typeNewPassword(password);
        btnVoityFinish.click();
        return this;
    }

    public String registrationSuccessful(){
        return  actualRegOk.getAttribute("innerText");
    }

    public String errorPassword(){
        return errorPassActual.getAttribute("innerHTML");
    }
}
