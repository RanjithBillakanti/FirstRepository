package tests.cucumber.test;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.Base.BaseUtil;
import tests.BaseTest;
import utilities.ExtentTestManager;

import java.io.File;

import static utilities.PropReader.getDeviceName;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\Padmashree M\\IdeaProjects\\Basic\\src\\test\\java\\tests\\cucumber\\Feature\\Basic.feature"},
        glue = {"tests.cucumber.StepDefin"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/reports.html"}
)
public class TestRunner extends BaseTest {
//glues code for running cucumber via TestNG
    private TestNGCucumberRunner testNGCucumberRunner;



    //Runs before the class and considers this class(Cucumber) to be run using testNG
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
//* The only purpose of this class is to provide custom,making TestNG reports look more descriptive.
    @Test(groups = "cucumber", description = "Runs Basic tests.cucumber.Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        //System.out.println("Cucumber Test Class Inside Test"+ + iTestContext.getName();
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
       // ExtentTestManager.getTest().setDescription(log.iTestContext.getName());
    }

    @DataProvider
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();

    }

    @AfterClass
    public void tearDownClass() {

        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")
                + "\\extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        testNGCucumberRunner.finish();
    }

}
