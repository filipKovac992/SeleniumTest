package assignment.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmDashboard {

    WebDriver driver;

    //element locators
    @FindBy(xpath = "//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/a")
    WebElement recruitmentDropDown;

    @FindBy(id = "menu_recruitment_viewCandidates")
    WebElement candidatesDropDown;

    //Constuctor
    public OrangeHrmDashboard(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //clicks on the "Candidates' link
    public void candidatesClick(){
        recruitmentDropDown.click();
        candidatesDropDown.click();


    }

    //waits for the dashboard page to fully load
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new  ExpectedCondition<Boolean> (){
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(pageLoadCondition);
    }

}

