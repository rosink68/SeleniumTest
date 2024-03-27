package de.msg.erstetests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiinySiteTest {

    private WebDriver driver;
    private final String baseUrl = "https://tiiny.host/test-html/"; //https://google.com
    private final String baseUrl1 = "https://tiiny.host/";


    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void testHeaderH1() {
        driver = webdriverSetup();

        driver.get(baseUrl);

        String expectHeaderH1 = "Test HTML";
        WebElement header1 = driver.findElement(By.tagName("h1"));
        String actualHeaderH1 = header1.getText();

        Assertions.assertEquals(expectHeaderH1,actualHeaderH1);

        //close Fire fox
 //       driver.close();

    }

    @Test
    public void testFindByLinkText() {
        driver = webdriverSetup();

        driver.get(baseUrl1);

       WebElement blogLink = driver.findElement(By.linkText("Blog"));
      blogLink.click();

        //close Fire fox
//        driver.close();

    }


    @Test
    public void testFindByPartialLinkText() {
        driver = webdriverSetup();

        driver.get(baseUrl1);

        WebElement partLink = driver.findElement(By.partialLinkText("Pric"));
        partLink.click();

        //close Fire fox
//        driver.close();

    }

    @Test
    public void testFindByName() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        WebElement eingabeFeld = driver.findElement(By.name("subdomain"));
        eingabeFeld.sendKeys("Test");

        //close Fire fox
//        driver.close();

    }

    @Test
    public void testEingabefeldFindByXPath() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        // WebElement eingabeFeld = driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/div[1]/div/form/div[1]/input"));
        // xpath vereinfachen zu "//input[@name='subdomain']" <== geht nur, wenn 'subdomain' ein einziges Mal auf der Seite vorkommt
        WebElement eingabeFeld = driver.findElement(By.xpath("//input[@name='subdomain']"));
        eingabeFeld.sendKeys("Test");

        //close Fire fox
//        driver.close();

    }

    @Test
    public void testFindExampleButtonByID() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        WebElement exampleButton = driver.findElement(By.id("content-selector-tab-template"));
        exampleButton.click();

        //close Fire fox
//        driver.close();

    }


    @Test
    public void testAufrufExamplePitchdeck() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        WebElement exampleButton = driver.findElement(By.id("content-selector-tab-template"));
        exampleButton.click();

        // WebElement pitchdeck = driver.findElement(By.xpath("//*[@id=\"content-selector-tabpane-template\"]/div/div[2]/img"));
        //img[@src='/assets/img/pitchdeck.png']
        // WebElement pitchdeck = driver.findElement(By.xpath("//img[@src='/assets/img/pitchdeck.png']"));
        //div[text()='Pitchdeck']
        WebElement pitchdeck = driver.findElement(By.xpath("//div[text()='Pitchdeck']"));
        pitchdeck.click();


        //close Fire fox
//        driver.close();

    }

    @Test
    public void testAufrufExampleMitContains1() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        WebElement exampleButton = driver.findElement(By.id("content-selector-tab-template"));
        exampleButton.click();

        WebElement landingPage = driver.findElement(By.xpath("//div[contains(text(), 'Landing P')]"));
        landingPage.click();


        //close Fire fox
//        driver.close();

    }


    @Test
    public void testAufrufExampleMitContains2() {
        driver = webdriverSetup();
        driver.get(baseUrl1);

        WebElement exampleButton = driver.findElement(By.id("content-selector-tab-template"));
        exampleButton.click();

        WebElement landingPage = driver.findElement(By.xpath("//div[contains(@class, 'mt-2 grey') and contains(text(), 'Landing P')]"));
        landingPage.click();


        //close Fire fox
//        driver.close();

    }

}
