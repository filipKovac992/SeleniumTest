package assignment.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import assignment.pages.*;


import java.io.IOException;

public class TestDemoQA {


    WebDriver driver;




    @BeforeEach
    public void setup() {
        //use Chrome Driver
        driver = new ChromeDriver();

    }

    @Test
    public void TestDemoqa() throws InterruptedException, IOException {
        GooglePage googlePage=new GooglePage(driver);
        DemoqaMainPage demoqaMainPage= new DemoqaMainPage(driver);
        DemoqaInteractionsPage demoqaInteractionsPage= new DemoqaInteractionsPage(driver);

        googlePage.searchForDemoqa();
        googlePage.openDemoqa();
        demoqaMainPage.clickInteractions();
        demoqaInteractionsPage.clickOnDroppable();
        demoqaInteractionsPage.dragBox();
        demoqaInteractionsPage.getText();
        demoqaInteractionsPage.screenShot();
        demoqaInteractionsPage.clickOnWidgets();
        demoqaInteractionsPage.clickOnToolTips();
        demoqaInteractionsPage.moveToInput();
        demoqaInteractionsPage.printHoverText();



    }

    @AfterEach
    public void close(){
        driver.close();
    }

}
