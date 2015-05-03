package tse.testCases;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SearchEngineSuite extends SeleneseTestCase {

    RemoteControlConfiguration rcc = new RemoteControlConfiguration();

    SeleniumServer             SELENIUM_SERVER;

    @BeforeClass
    public void setUp() {
        try {
            rcc.setPort(4444);
            SELENIUM_SERVER = new SeleniumServer(rcc);
            System.out.println("Selemium server is strating...");
            SELENIUM_SERVER.start();
            System.out.println("Selemium server is started...");
        } catch (Exception e) {
            throw new IllegalStateException("Can't start selenium server", e);
        }

    }
    
    public static void main(String args[]){
        SearchEngineSuite ses = new SearchEngineSuite();
        ses.setUp();
        
        //suite tag
        XmlSuite suite = new XmlSuite();
        // set suite name
        suite.setName("Test Search Engine");
        // set parameter tag
        HashMap para = new HashMap();
        para.put("google_se_para_1", "/resources/google_se_para_1.xml");
        para.put("google_se_para_2", "/resources/google_se_para_2.xml");
        para.put("baidu_se_para_1", "/resources/baidu_se_para_1.xml");
        para.put("bing_se_para_1", "/resources/bing_se_para_1.xml");
        para.put("mail_login_se_para_1", "/resources/mail_login_se_para_1.xml");
        suite.setParameters(para);
        //google test tag
        XmlTest testGoogle = new XmlTest(suite);
        testGoogle.setName("Test Google");
        List<XmlClass> googleClasses = new ArrayList<XmlClass>();
        googleClasses.add(new XmlClass(TestGoogleTestCase.class));
        testGoogle.setXmlClasses(googleClasses);
        
        //baidu test tag
        XmlTest testBaidu = new XmlTest(suite);
        testBaidu.setName("Test Baidu");
        List<XmlClass> baiduClasses = new ArrayList<XmlClass>();
        baiduClasses.add(new XmlClass(TestBaiduTestCase.class));
        testBaidu.setXmlClasses(baiduClasses);
        
        //bing test tag
        XmlTest testBing = new XmlTest(suite);
        testBing.setName("Test Bing");
        List<XmlClass> bingClasses = new ArrayList<XmlClass>();
        bingClasses.add(new XmlClass(TestBingTestCase.class));
        testBing.setXmlClasses(bingClasses);
        
        //mail login tag
        XmlTest testMailLogin = new XmlTest(suite);
        testMailLogin.setName("Test Mail Login");
        List<XmlClass> mailLoginClasses = new ArrayList<XmlClass>();
        mailLoginClasses.add(new XmlClass(TestMailLoginTestCase.class));
        testMailLogin.setXmlClasses(mailLoginClasses);
        
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();

        ses.tearDown();
    }


    @AfterClass
    public void tearDown() {
        if (SELENIUM_SERVER != null) {
            SELENIUM_SERVER.stop();
        }
    }

}
