package assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class GooglePage {

    public WebDriver driver;

    //element locators
    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement googleSearchField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")
    WebElement resultDemoqa;

    @FindBy(id = "result-stats")
    WebElement searchResults;

    //Constructor
    public GooglePage(WebDriver driver) {
        this.driver = driver;
        //Google home page
        String pageUrl = "https://google.com";
        driver.get(pageUrl);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void searchCheese(){     //types in word "cheese" into google search
        googleSearchField.sendKeys("cheese");   //searches for the entered word
        googleSearchField.submit();     //waits for the number of results element to appear on the page
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
    }

    //compares the number of results to preset value
    public void compareCheeseSearchResults(){       //parses the number of results string and takes second element
        String totalCheeseNumber=searchResults.getText().split(" ")[1];     //asserts the condition of passing the comparison and prints the error text
        assertEquals("777",totalCheeseNumber,"There is too much cheese on the internet");

    }

    //searches for the "Demo QA" page
    public void searchForDemoqa(){
        googleSearchField.sendKeys("Demoqa");
        googleSearchField.submit();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")));

    }

    //clicks on the search result
    public void openDemoqa(){
        resultDemoqa.click();



    }
}
