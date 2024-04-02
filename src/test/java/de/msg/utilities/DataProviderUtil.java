package de.msg.utilities;

public class DataProviderUtil {
    public static Object[][] setTestDataRadioButtonExampleTest() {
        return new Object[][]{{"bmwradio"},{"benzradio"},{"hondaradio"}};
    }

    public static Object[][] setTestDataSelectClassExampleTest() {
        return new Object[][]{{"bmw", 0},{"benz", 1},{"honda", 2}};
    }

    public static Object[][] setTestDataCheckBoxExampleTest() {
        return new Object[][]{{"bmwcheck"},{"benzcheck"},{"hondacheck"}};
    }

    public static Object[][] setTestDataMultipleSelectExampleTest() {
        return new Object[][]{{"apple",0},{"orange",1},{"peach",2}};
    }

}
