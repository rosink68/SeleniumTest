package de.msg.letscodeittests;

import de.msg.base.Testbase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxExampleTest extends Testbase {

    @ParameterizedTest
    @MethodSource("de.msg.utilities.DataProviderUtil#setTestDataCheckBoxExampleTest")
    public void checkBoxTest(String checkBox) {

        WebElement checkBoxTest = driver.findElement(By.id(checkBox));
        checkBoxTest.click();

        Assertions.assertTrue(checkBoxTest.isSelected());

        wait2000();
    }
}
