package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static screens.BaseScreen.driver;


public class Generic {



    public Generic(AndroidDriver tlDriver) {
    }


    /**Screenshot capturing way-1**/
/*

    public static String   FailedCaseScreenshot() throws IOException {

        String date2=null;
        //Creating an object of Date class
        Date d = new Date();
        //Printing the actual date
        String date1 = d.toString();
        System.out.println(date1);
        //replacing the colon present in the date timestamp format to "_" using replaceAll()
        //method of String class

         date2 = date1.replaceAll(":", "_");
        System.out.println(date2);

        //Typecasting the driver object to TakesScreenshot interface type.
        TakesScreenshot ts = (TakesScreenshot) driver;

        //getting the source file using getScreenshotAs() method and storing in a file
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        */
/*Created a folder called "ErrorScreenshots" in the project directory
        Created another file by concatenating the date value  which has "_" in it
        (Underscore is the accepted character while creating a file in the project )*//*


        File destFile = new File(System.getProperty("user.dir")
                + "\\ErrorScreenshots\\" + date2 + ".png");

        */
/*copyFile() method is a static method present in FileUtils class of JAVA
        storing the screenshot in the destination location*//*


        FileUtils.copyFile(srcFile, destFile);

        return date2;
    }
*/


    /**Screenshot capturing way-2**/
    /*Refer about BASE64- https://en.wikipedia.org/wiki/Base64
    https://stackoverflow.com/questions/10315757/what-is-the-real-purpose-of-base64-encoding
     */

    public static String capture(String NameOfThread) throws Exception {



        System.out.println(NameOfThread);
        String nameOfScr=NameOfThread;
/*


        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name
        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        String screen=completeFileName.toString().replace(":", "-");
*/

        Date d = new Date();
        //String date1 = d.toString();
        //System.out.println("date1 "+date1);
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MMM/YYYY hh:mm", Locale.ENGLISH);

        Date d1=d;
        String ScreenDate = mdyFormat.format(d);
        System.out.println(ScreenDate);
        String date2 = ScreenDate.replaceAll("/", "_").replaceFirst(":","h");
        //.replaceAll(":","_")
        System.out.println(date2);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader;
        try {
            fileInputStreamReader = new FileInputStream(sourceFile);
            byte[] bytes = new byte[(int) sourceFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

            //String screenShotDestination = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + NameOfThread + ".png";

            //should create a file "ErrorScreenshots" in project folder
            String screenShotDestination = System.getProperty("user.dir")
                    + "\\ErrorScreenshots\\" + NameOfThread+"/"+date2 +"m" +".png";

            File destination = new File(screenShotDestination);
            FileUtils.copyFile(sourceFile, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;
    }


    /*protected static String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name
        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }
        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }*/
}
