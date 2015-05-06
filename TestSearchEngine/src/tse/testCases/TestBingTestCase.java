package tse.testCases;

import java.util.HashMap;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

import tse.tasks.TestBingTasks;
import tse.utilities.SeleniumUtils;
import tse.utilities.XMLParser;

public class TestBingTestCase extends SeleneseTestCase {

    private HashMap<String, Object> paraMap;

    private TestBingTasks         tgTasks;

    private SeleniumUtils           utils;

    RemoteControlConfiguration      rcc = new RemoteControlConfiguration();

    SeleniumServer                  SELENIUM_SERVER;

    @BeforeClass
    public void setup() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox",
                "http://www.bing.com/");
        System.out.println("Starting selenium.");
        selenium.start();
        utils = new SeleniumUtils(selenium);
        tgTasks = new TestBingTasks(utils);
    }

    @Parameters( { "bing_se_para_1" })
    @Test
    public void testBing_1(String paraFile) {
        paraMap = (HashMap<String, Object>) XMLParser.getInstance()
                .parserXml(paraFile);
        System.out.println("the paraMap is" + paraMap);

        tgTasks.openSite();
        tgTasks.typeSearchTxtField(paraMap);
        tgTasks.clickSearchBtn();
        tgTasks.verifyResult(paraMap);
        utils.pause(10000);
    }
    
    @AfterClass
    public void stop(){
        if(selenium != null){
            selenium.stop();
        }
    }
}
