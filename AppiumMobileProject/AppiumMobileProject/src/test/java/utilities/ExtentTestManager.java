package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.createInstance();



    //At getTest() method, return ExtentTest instance in extentTestMap by using current thread id.
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    //At endTest() method, test ends and ExtentTest instance got from extentTestMap via current thread id.
    public static synchronized void endTest() {
        extent.removeTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    //At startTest() method, an instance of ExtentTest created and put into extentTestMap with current thread id.
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
