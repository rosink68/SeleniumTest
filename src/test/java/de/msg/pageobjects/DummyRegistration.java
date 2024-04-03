package de.msg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.*;

public class DummyRegistration {

    private WebDriver driver;

    // xpath: $x("//input[@name='name']")
    // xpath als css: $$("input[name='name']")
    private By nameLocator = By.name("name");
    private By phoneLocator = By.name("phone");
    private By emailLocator = By.name("email");


    // xpath: $x("//select[@name='country']")
    private By countryLocator = By.name("country");
    private By cityLocator = By.name("city");

    // da username nicht eindeutig ist, verwende ich hier für den Test (unschöner weise) den Path
    // xpath: $x("//*[@id='load_form']/fieldset[6]/input")
    private By usernameLocator = By.xpath("//*[@id='load_form']/fieldset[6]/input");

    private By passwordLocator = By.xpath("//*[@id='load_form']/fieldset[7]/input");

    // da der Button nicht eindeutig indetifizierbar ist, nehme ich hier den full xpath
    private By submitButtonLocator = By.xpath("/html/body/div[2]/div/div/div/div/div/form/div[1]/div[2]/input");

    public DummyRegistration (WebDriver driver) {
        this.driver = driver;
    }

    public void typeName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
    }

    public void typePhone(String phone) {
        driver.findElement(phoneLocator).sendKeys(phone);
    }

    public void typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void selectCountry(String country) {
        Select selectCountries = new Select(driver.findElement(countryLocator));
        selectCountries.selectByValue(country);
    }

    public void typeCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSubmitButtonTest() {
        driver.findElement(submitButtonLocator).click();
    }
}
