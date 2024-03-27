package de.msg.erstetests;

import main.MyFunctionality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebsiteContentTest {

    private WebDriver driver;
    private final String baseUrl = "https://fprdev.github.io/selenium-dummypage-fp/";

    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void testWebsiteTitle() {

        driver = webdriverSetup();

        String expectedTitle = "My Selenium Testpage";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //close Fire fox
        driver.close();
    }

    @Test
    public void testHeaderH1() {
        driver = webdriverSetup();

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

// selenium java chromewebdriver how to get h1 by element
        String expectHeaderH1 = "Welcome to my Selenium Test Page!";
//        WebElement header1 = driver.findElement(By.tagName("h1"));
        WebElement header1 = driver.findElement(By.id("webpageheader"));
        String actualHeaderH1 = header1.getText();

        Assertions.assertEquals(expectHeaderH1,actualHeaderH1);

        //close Fire fox
        driver.close();

    }

    @Test
    public void testFirstButton() {
        driver = webdriverSetup();

        driver.get(baseUrl);

       WebElement firstButton = driver.findElement(By.id("firstbutton"));
       firstButton.click();

        //wait(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ZERO);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        

        //close Fire fox
    //    driver.close();

    }

    @Test
//    @Disabled("Methode wird noch überarbeitet")
    public void testFirstPrompt() throws InterruptedException {
        driver = webdriverSetup();

        driver.get(baseUrl);
// selenium wait until implemention for prompt
        WebElement firstPrompt = driver.findElement(By.id("firstprompt"));
        firstPrompt.click();
        wait(4000);

        WebDriverWait wait = new WebDriverWait(driver , Duration.ZERO);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());


//Type your message
        alert.sendKeys("Selenium");

//Press the OK button
        alert.accept();
        //close Fire fox
     //   driver.close();

    }

    @Test
    public void testTickCheckboxes() {
        driver = webdriverSetup();

        driver.get(baseUrl);

        WebElement licenseForm = driver.findElement(By.id("licenseagreementform"));
        String test = licenseForm.getText();

        WebElement agreement1 = driver.findElement(By.id("agreement1"));
        agreement1.click();
        Assertions.assertTrue(agreement1.isSelected());

        WebElement agreement2 = driver.findElement(By.id("agreement2"));
        agreement2.click();
        Assertions.assertTrue(agreement2.isSelected());

        WebElement agreement3 = driver.findElement(By.id("agreement3"));
        agreement3.click();
        Assertions.assertTrue(agreement3.isSelected());

        //close Fire fox
     //   driver.close();

    }

    @Test
    public void testSubmitCheckboxForm() {
        driver = webdriverSetup();

        //close Fire fox
        driver.close();

    }

    @Test
    public void testFilloutTextarea() {
        driver = webdriverSetup();

        driver.get(baseUrl);

        WebElement txtArea = driver.findElement(By.tagName("textarea"));
        txtArea.sendKeys("The last step is to write a short description about yourself:");


        //close Fire fox
//        driver.close();

    }

    @Test
    public void testSubmitFeedback() {
        driver = webdriverSetup();

        driver.get(baseUrl);

        WebElement submitFeedback = driver.findElement(By.id("submitFeedback"));
        submitFeedback.click();

        //close Fire fox
        //driver.close();

    }







    @Test
    public void testSelenium() {
        driver = webdriverSetup();

        String expectedTitle = "My Selenium Testpage";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();

        System.out.println("Ende Seleniumtest");
    }

}
