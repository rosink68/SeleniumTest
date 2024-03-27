package de.msg.suiteTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {
    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutionMessage() {
        System.out.println("Inside testSalutionMessage()");
        message = "Hallo! " + "Robert";
        Assertions.assertEquals(message, messageUtil.salutationMessage());
    }
}
