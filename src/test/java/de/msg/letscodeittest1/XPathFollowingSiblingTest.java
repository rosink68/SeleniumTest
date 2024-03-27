package de.msg.letscodeittest1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathFollowingSiblingTest {

    private WebDriver driver;
    private final String baseUrl = "https://www.letskodeit.com/practice";
    
    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void testFollowingSiblingsRadioButtonsExample() throws InterruptedException {
        driver = webdriverSetup();
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // kopierter xpath fieldset: //*[@id="radio-btn-example"]/fieldset
        // legend-Tag: //*[@id="radio-btn-example"]/fieldset/legend
        List<WebElement> listeRadioButtons = driver.findElements(By.xpath("//legend[contains(text(),'Radio')]//following-sibling::label//following-sibling::input"));

        for (WebElement listeAutos : listeRadioButtons) {
            System.out.println(listeAutos.getAttribute("value"));
            listeAutos.click();
            Thread.sleep(2000);
        }

        //close Fire fox
        driver.close();
    }

    @Test
    public void testFollowingSiblingsCheckboxExample() throws InterruptedException {
        driver = webdriverSetup();
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> listeCheckboxen = driver.findElements(By.xpath("//legend[contains(text(),'Checkbox Example')]//following-sibling::label//following-sibling::input"));

        for(WebElement listeAutos : listeCheckboxen) {
            System.out.println(listeAutos.getAttribute("value"));
            listeAutos.click();
            Thread.sleep(2000);
        }

        //close Fire fox
        driver.close();
    }

}
