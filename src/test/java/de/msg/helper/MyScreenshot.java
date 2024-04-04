package de.msg.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.UUID;

public class MyScreenshot {

    public static void makeScreenShot(WebDriver driver) {

        // Variable muss für jeden Screenshot einzigartig sein!!!
        String screenshotPath = "src/test/resources/screenshots/" + UUID.randomUUID() + ".png";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
