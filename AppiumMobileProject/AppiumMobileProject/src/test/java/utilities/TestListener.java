package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.Utils;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.Base.BaseUtil;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Field;

import static utilities.ExtentTestManager.getTest;

import static utilities.Generic.capture;
import static utilities.PropReader.getDeviceName;


public class TestListener extends BaseTest implements ITestListener {


    private static ExtentReports extent = ExtentManager.createInstance();
    //private static ExtentTest logger = ExtentManager.logger;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();



    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
        System.out.println(System.currentTimeMillis());
        String st = iTestContext.getName();
        //

    }


    //After ending all tests, below method runs.
    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.createInstance().flush();
        System.out.println(System.currentTimeMillis());
        getTest().log(Status.INFO, iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
       /* Scenario scenario;
        String screenshotName = scenario.getName().replaceAll(" ", "_");*/
      /*  try {
            //This takes a screenshot from the driver at save it to the specified location
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourcePath = ts.getScreenshotAs(OutputType.FILE);
            //File sourcePath = ((TakesScreenshot).getScreenshotAs(OutputType.FILE);

            //Building up the destination path for the screenshot to save
            //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
            File destinationPath = new File(".\\screenshot\\"+"screenShot"+".png");


            //Copy taken screenshot from source location to destination location
            Files.copy(sourcePath, destinationPath);

            //This attach the specified screenshot to the test
            ExtentTestManager.getTest().addScreenCaptureFromPath(destinationPath.toString());
        } catch (IOException e) {
        }*/
        /*Class clazz = iTestResult.getTestClass().getRealClass();
        try {
            // this field name must be present and equals in any testcase
            Field field = clazz.getDeclaredField("driver");
            field.setAccessible(true);

            AppiumDriver<?> driver = (AppiumDriver<?>) field.get(iTestResult.getInstance());

            TakesScreenshot ts = (TakesScreenshot) driver;
            File file = ts.getScreenshotAs(OutputType.FILE);

            // the filename is the folder name on test.screenshot.path property plus the completeTestName
            FileUtils.copyFile(file,
                    new File(System.getProperty("user.dir") + "\\ErrorScreenshots\\" + composeTestName(iTestResult) + ".png"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

*/

        //Name of the thread
        String name = Thread.currentThread().getName().toString().replace("TestNG-test=", " ");
        // name.toString().replace(":", "-");

        //System.out.println("failed case:"+ ThreadMXB);
        //System.out.println("failed case:"+Thread.currentThread().);

        try {
            //ExtentTestManager.getTest().addScreenCaptureFromPath(FailedCaseScreenshot());
            // Reporter.addScreenCaptureFromPath(FailedCaseScreenshot());
            System.out.println(name);
            Reporter.addScreenCaptureFromPath(capture(name));
        //    test.get().log(Status.INFO,"screenshot attached");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //Extenttest log operation for skipped tests.
        test.get().log(Status.SKIP, "Test Skipped");//
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @After
    public void AddDeviceToJson(Scenario scenario) {
        scenario.write("This test was executed on device " + getDeviceName());
        System.out.println(getDeviceName());

    }
/*    private String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();

        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name

        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for (Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }
   *//* public void Name(ITestContext iTestContext){
        String name=iTestContext.getName();
        System.out.println(iTestContext.getName());
    }
*/
}