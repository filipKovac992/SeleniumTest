package assignment.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoqaInteractionsPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']//div[@class='accordion']/div[5]/div/ul[@class='menu-list']/li[4]")
    WebElement droppableLink;

    @FindBy(id = "draggable")
    WebElement draggableBox;

    @FindBy(id = "droppable")
    WebElement droppableBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div")
    WebElement widgetsMenu;

    @FindBy(xpath = "//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']//div[@class='accordion']/div[4]/div/ul[@class='menu-list']/li[7]")
    WebElement toolTipsSection;

    @FindBy(id = "toolTipTextField")
    WebElement toolTipsInput;


    //Constructor
    public DemoqaInteractionsPage(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnDroppable() {
        droppableLink.click();

    }

    public void dragBox() {
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(draggableBox)
                .moveToElement(droppableBox)
                .release(droppableBox)
                .build();

        dragAndDrop.perform();
    }

    public void getText() {
        System.out.print(droppableBox.getText() + "\n");
    }

    public void clickOnWidgets() {
        widgetsMenu.click();
    }

    public void clickOnToolTips() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipsSection);
        actions.perform();
        toolTipsSection.click();
    }

    public void moveToInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipsInput).perform();


    }

    public void printHoverText() throws InterruptedException {
        Thread.sleep(2000);
        WebElement tooltip = driver.findElement(By.xpath("//*[@id=\"textFieldToolTip\"]"));
        System.out.println(tooltip.getText());

    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
//        proper method functioning requires setting up a valid destination argument for Screenshot path
//        alongside with
//        folder named "screenshots"

    public void screenShot() throws IOException, InterruptedException {     //Take screenshot and save to file
        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    //Destination where to store screenshot
        File dest= new File("src/test/java/assignment/tests/screenshots/"+timestamp()+".png");  // Copy the file to system ScreenshotPath
        FileUtils.copyFile(scr,dest );
        Thread.sleep(1200);
    }



}




