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
import tse.tasks.TestMailLoginTasks;
import tse.utilities.SeleniumUtils;
import tse.utilities.XMLParser;

public class TestMailLoginTestCase extends SeleneseTestCase {

    private HashMap<String, Object> paraMap;

    private TestMailLoginTasks      tgTasks;

    private SeleniumUtils           utils;

    RemoteControlConfiguration      rcc = new RemoteControlConfiguration();

    SeleniumServer                  SELENIUM_SERVER;

    @BeforeClass
    public void setup() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox",
                "https://accounts.google.com/");
        System.out.println("Starting selenium.");
        selenium.start();
        utils = new SeleniumUtils(selenium);
        tgTasks = new TestMailLoginTasks(utils);
    }

    @Parameters( { "mail_login_se_para_1" })
    @Test
    public void testMailLogin_1(String paraFile) {
        paraMap = (HashMap<String, Object>) XMLParser.getInstance()
                .parserXml(paraFile);
        System.out.println("the paraMap is" + paraMap);

        tgTasks.openSite();
        tgTasks.typeLoginTxtField(paraMap);
        tgTasks.clickLoginBtn();
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
