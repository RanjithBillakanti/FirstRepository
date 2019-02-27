/*
package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import screens.BaseScreen;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static screens.BaseScreen.driver;

public class TakescreeshotOfFailed {

    Dimension size;
    String destDir;
    DateFormat dateFormat;

    public static String  FailedCaseScreenshot() throws IOException {


        //Creating an object of Date class
        Date d = new Date();
        //Printing the actual date
        String date1 = d.toString();
        System.out.println(date1);
        //replacing the colon present in the date timestamp format to "_" using replaceAll()
        //method of String class
        String date2 = date1.replaceAll(":", "_");
        System.out.println(date2);

        //Typecasting the driver object to TakesScreenshot interface type.
        TakesScreenshot ts = (TakesScreenshot) driver;

        //getting the source file using getScreenshotAs() method and storing in a file
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        */
/*Created a folder called "screenshot" in the project directory
        Created another file by concatenating the date value  which has "_" in it
        (Underscore is the accepted character while creating a file in the project )*//*


        File destFile = new File(".\\screenshot\\" + date2 + ".png");

        */
/*copyFile() method is a static method present in FileUtils class of JAVA
        storing the screenshot in the destination location*//*


        FileUtils.copyFile(srcFile, destFile);


        return date2;
    }}
*/
