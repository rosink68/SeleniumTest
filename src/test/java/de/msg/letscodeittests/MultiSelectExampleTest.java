package de.msg.letscodeittests;

import de.msg.base.Testbase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectExampleTest extends Testbase {

    List<WebElement> listFruits;
    Select selectFruits;

    @BeforeEach
    public void setupBeforeEach() {
        Testbase.setUp();
        WebElement listSelections = driver.findElement(By.id("multiple-select-example"));
        selectFruits = new Select(listSelections);

        listFruits = selectFruits.getOptions();
    }

    @ParameterizedTest
    @MethodSource("de.msg.utilities.DataProviderUtil#setTestDataMultipleSelectExampleTest")
    public void multipleSelectTest(String selectedFruit, int indexSelection) {

        selectFruits.selectByValue(selectedFruit);
        Assertions.assertTrue(listFruits.get(indexSelection).isSelected());

        wait2000();
    }
}
