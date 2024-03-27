package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectOptionTest {

    public static WebDriver driver;
    public static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.wikipedia.org/";

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void testSelectOption() {
        WebElement selectElement = driver.findElement(By.id("searchLanguage"));

        Select selectLanguage = new Select(selectElement);
        List<WebElement> listLanguages = selectLanguage.getOptions();

        for (WebElement webLang : listLanguages) {
            System.out.println(webLang.getText());
        }
    }
    @Test
    public void testSelectLanguageDa() {
        boolean daSelected = false;
        WebElement selectElement = driver.findElement(By.id("searchLanguage"));

        Select selectLanguage = new Select(selectElement);
        List<WebElement> listLanguages = selectLanguage.getOptions();

        for (WebElement webLang : listLanguages) {

            if(webLang.getAttribute("value").equals("da")) {
                webLang.click();
                daSelected = webLang.isSelected();
            }
        }

        Assertions.assertTrue(daSelected);
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
