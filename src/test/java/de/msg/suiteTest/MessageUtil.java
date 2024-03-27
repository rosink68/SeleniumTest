package de.msg.suiteTest;

public class MessageUtil {

    private String message;

    public MessageUtil(String message){
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public String salutationMessage(){
        message = "Hallo! " + message;
        System.out.println(message);
        return message;
    }

}
