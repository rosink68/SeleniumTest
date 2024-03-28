package de.msg.letscodeittests;

import de.msg.base.Testbase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtonExampleTest extends Testbase {

    @ParameterizedTest
    @MethodSource("de.msg.utilities.DataProviderUtil#setTestDataRadioButtonExampleTest")
    public void radioButtonTest(String radioButton) {

        WebElement radioButtontest = driver.findElement(By.id(radioButton));
        radioButtontest.click();

        Assertions.assertTrue(radioButtontest.isSelected());

        // nur um auf der Webseite was zu sehen
        wait2000();
    }

}
