package de.msg.letscodeittests;

import de.msg.base.Testbase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtonExampleTest extends Testbase {

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

}
