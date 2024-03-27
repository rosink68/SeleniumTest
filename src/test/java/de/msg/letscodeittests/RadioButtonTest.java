package de.msg.letscodeittests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void radioButtonBMWTest() {

        WebElement radioButton = driver.findElement(By.id("bmwradio"));
        radioButton.click();

        Assertions.assertTrue(radioButton.isSelected());
    }

    @Test
    public void radioButtonBenzTest() {

        WebElement radioButton = driver.findElement(By.id("benzradio"));
        radioButton.click();

        Assertions.assertTrue(radioButton.isSelected());
    }


    @Test
    public void radioButtonHondaTest() {

        WebElement radioButton = driver.findElement(By.id("hondaradio"));
        radioButton.click();

        Assertions.assertTrue(radioButton.isSelected());
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
