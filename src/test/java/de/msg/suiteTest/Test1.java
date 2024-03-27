package de.msg.suiteTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        Assertions.assertEquals(message, messageUtil.printMessage());
    }
}
