package assignment.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class OrangeHrmCandidates {

    WebDriver driver;

    //element locators


    @FindBy(id = "fromToOf")
    WebElement numberOfCandidates;

    @FindBy(id = "list_item_add")
    WebElement addCandidate;

    //Constructor
    public OrangeHrmCandidates(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void getNumberOfCandidates(){
        numberOfCandidates= driver.findElement(By.id("rowsperpage"));
        System.out.println(numberOfCandidates.getText().split(" ")[4]);
    }



}
