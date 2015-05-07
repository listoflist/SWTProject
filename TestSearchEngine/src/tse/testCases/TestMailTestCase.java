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

import tse.tasks.TestMailTasks;
import tse.utilities.SeleniumUtils;
import tse.utilities.XMLParser;

public class TestMailTestCase extends SeleneseTestCase {

    private HashMap<String, Object> paraMap;

    private TestMailTasks           tgTasks;

    private SeleniumUtils           utils;

    RemoteControlConfiguration      rcc = new RemoteControlConfiguration();

    SeleniumServer                  SELENIUM_SERVER;

    @BeforeClass
    public void setup() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox",
        		"https://mail.google.com/");
        	//                "https://accounts.google.com/");
        System.out.println("Starting selenium.");
        selenium.start();
        utils = new SeleniumUtils(selenium);
        tgTasks = new TestMailTasks(utils);
    }

    @Parameters( { "mail_test_para_1" })
    @Test
    public void testMailLogin(String paraFile) throws InterruptedException {
        paraMap = (HashMap<String, Object>) XMLParser.getInstance().parserXml(paraFile);
        System.out.println("the paraMap is" + paraMap);

        tgTasks.openSite();
        tgTasks.typeLoginTxtField(paraMap);
        tgTasks.clickLoginBtn();
        
        //Thread.sleep(10000);
        //tgTasks.verifyInboxTitle(paraMap);
        Thread.sleep(8000);
    }

    @Parameters( { "mail_test_para_1" })
    @Test
    public void testMailSend(String paraFile) throws InterruptedException {
        paraMap = (HashMap<String, Object>) XMLParser.getInstance().parserXml(paraFile);
        System.out.println("the paraMap is" + paraMap);

        // tgTasks.openSite();
        // tgTasks.typeLoginTxtField(paraMap);
        // tgTasks.clickLoginBtn();
        Thread.sleep(2000);
        
        tgTasks.clickComposeBtn();
        utils.pause(1000);
        tgTasks.typeMailField(paraMap);
        tgTasks.clickSendBtn();
        //tgTasks.verifyResult(paraMap);
        Thread.sleep(5000);
    }

    // @Parameters( { "mail_test_para_1" }) //still using login para
    // @Test
    // public void testMailDelete(String paraFile) throws InterruptedException {
    //     paraMap = (HashMap<String, Object>) XMLParser.getInstance().parserXml(paraFile);
    //     System.out.println("the paraMap is" + paraMap);

    //     // tgTasks.openSite();
    //     // tgTasks.typeLoginTxtField(paraMap);
    //     // tgTasks.clickLoginBtn();
    //     //tgTasks.verifyResult(paraMap);
    //     Thread.sleep(3000);
    //     //
    //     tgTasks.clickCheckBox();
    //     tgTasks.clickDelete();
    //     //
    //     // String totalEmailAfterDelete = selenium.getText("//span[@class='Dj']/b[3]");
    //     // System.out.println(totalEmailBeforeDelete + " Emails at the beginning, now only " + 
    //     //                    totalEmailAfterDelete + " Emails !");
    //     // assertEquals(1, Integer.parseInt(totalEmailBeforeDelete) - Integer.parseInt(totalEmailAfterDelete));
    
    //     Thread.sleep(3000);
    // }
    
    @Parameters( { "mail_test_para_1" }) //still using search para
    @Test
    public void testMailSearch(String paraFile) throws InterruptedException {
        paraMap = (HashMap<String, Object>) XMLParser.getInstance().parserXml(paraFile);
        System.out.println("the paraMap is" + paraMap);

        // tgTasks.openSite();
        // tgTasks.typeLoginTxtField(paraMap);
        // tgTasks.clickLoginBtn();
        Thread.sleep(3000);

        tgTasks.typeSearchTxtField(paraMap);
        tgTasks.clickSearchBtn();
        
        Thread.sleep(5000);

        // int total = tgTasks.getTotalEmails();
        // System.out.println("Searching \"" + paraMap
        //                     .get(TestMailConstants.MAIL_SEARCH_TXT_FIELD_1) +
        //                     "\" , find " + total + " emails.");
       
        // Thread.sleep(5000);
    }

    @AfterClass
    public void stop(){
        if(selenium != null){
            selenium.stop();
        }
    }
}
