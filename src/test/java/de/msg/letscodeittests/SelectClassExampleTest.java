package de.msg.letscodeittests;

import de.msg.base.Testbase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassExampleTest extends Testbase {

    List<WebElement> listeAutos;
    Select selectAutos;

    @BeforeEach
    public void setupBeforeClass() {
        Testbase.setUp();

        WebElement selectElement = driver.findElement(By.id("carselect"));
        selectAutos = new Select(selectElement);

        listeAutos = selectAutos.getOptions();
    }

    @Test
    public void selectBMWTest() {
        selectAutos.selectByValue("bmw");
        Assertions.assertTrue(listeAutos.get(0).isSelected());
    }

    @Test
    public void selectBenzTest() {
        selectAutos.selectByValue("benz");
        Assertions.assertTrue(listeAutos.get(1).isSelected());
    }

    @Test
    public void selectHondaTest() {
        selectAutos.selectByValue("honda");
        Assertions.assertTrue(listeAutos.get(2).isSelected());
    }
}
