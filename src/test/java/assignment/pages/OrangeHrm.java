package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrm {

    WebDriver driver;

    //element locators
    @FindBy(id = "btnLogin")
    WebElement loginButton;

    //Constructor
    public OrangeHrm(WebDriver driver) {
        this.driver = driver;
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
        PageFactory.initElements(driver, this);
    }

    //clicks on the "Login" button
    public void loginClick(){
        loginButton.click();
    }

}

