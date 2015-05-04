package tse.testCases;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSearchEngine extends SeleneseTestCase {

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

    /* run this case, modify the file old_testng.xml
     * 
     * 
     */
    @Parameters( { "url", "query-string", "btn-id", "txt-id", "verify-String" })
    @Test
    public void testGoogle(String url, String queryString, String btnID,
            String txtID, String verifyString) {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", url);
        selenium.start();

        selenium.open("/");
        selenium.type(txtID, queryString);
        selenium.click(btnID);
        selenium.waitForPageToLoad("30000");
        verifyTrue(selenium.isTextPresent(verifyString));

        System.out.println("stop selenium............");
        selenium.stop();
    }
    

    public void tearDown() {
        if (SELENIUM_SERVER != null) {
            SELENIUM_SERVER.stop();
        }
    }

}
