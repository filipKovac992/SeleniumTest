package assignment.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaMainPage {

    public WebDriver driver;


    //Google home page
    private static String pageUrl = "https://google.com";

    //element locators
    @FindBy(css = ".category-cards [class='card mt-4 top-card']:nth-of-type(5) [stroke]")
    WebElement interactionsCard;


    //Constructor
    public DemoqaMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        //Initialise Elements
        PageFactory.initElements(driver, this);

    }

    //clicks on the "interactions" element
    public void clickInteractions(){
        interactionsCard.click();

    }
}
