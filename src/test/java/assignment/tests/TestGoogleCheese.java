package assignment.tests;

import assignment.pages.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestGoogleCheese {


    WebDriver driver;


    @BeforeEach
    public  void setup() {
        //use Chrome Driver
        driver = new ChromeDriver();

    }

    @Test
    public void cheeseCompare(){
        GooglePage googlePage=new GooglePage(driver);
        googlePage.searchCheese();
        googlePage.compareCheeseSearchResults();
    }



    @AfterEach
    public void close(){
        driver.close();
    }

}
