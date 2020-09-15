package assignment.tests;

import assignment.pages.OrangeHrm;
import assignment.pages.OrangeHrmCandidates;
import assignment.pages.OrangeHrmDashboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCandidate {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        //use Chrome Driver
        driver = new ChromeDriver();
    }

    @Test
    public void TestHrmCandidate() throws InterruptedException {
        OrangeHrm orangeHrm = new OrangeHrm(driver);
        OrangeHrmDashboard orangeHrmDashboard = new OrangeHrmDashboard(driver);
        OrangeHrmCandidates orangeHrmCandidates = new OrangeHrmCandidates(driver);

        orangeHrm.loginClick();
        orangeHrmDashboard.waitForLoad(driver);
        orangeHrmDashboard.candidatesClick();
        Thread.sleep(5000);
        orangeHrmCandidates.getNumberOfCandidates();
    }


    @AfterEach
    public void close() {
        driver.close();
    }

}





