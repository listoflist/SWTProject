package tse.tasks;

import java.util.HashMap;
import java.util.Properties;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import tse.utilities.PropUtils;
import tse.utilities.SeleniumUtils;

public class TestMailLoginTasks {

    private final static String PROP_NAME = "tse/appObjects/mailLogin.properties";

    private SeleniumUtils       utils;

    private Selenium            selenium;

    private Properties          elemMap;

    private SeleneseTestCase    stc       = new SeleneseTestCase();

    public TestMailLoginTasks(SeleniumUtils utils) {
        this.utils = utils;
        selenium = this.utils.getSelenium();
        elemMap = PropUtils.getProperties(PROP_NAME);
    }

    public void openSite() {
        selenium.open("/");
    }

    public void typeLoginTxtField(HashMap<String, Object> paraMap) {
        System.out.println("the elemMap is" + elemMap + "..............");
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_1), 30));
        stc.verifyTrue(utils.waitForElement((String) elemMap
        		.get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_2), 30));
        selenium.type((String) elemMap
                .get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_1),
                (String) paraMap
                        .get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_1));
        selenium.type((String) elemMap
                .get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_2),
                (String) paraMap
                        .get(TestMailLoginConstants.MAIL_LOGIN_TXT_FIELD_2));
    }

    public void clickLoginBtn() {
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailLoginConstants.MAIL_LOGIN_BTN), 30));
        selenium.click((String) elemMap
                .get(TestMailLoginConstants.MAIL_LOGIN_BTN));
    }

    public void verifyResult(HashMap<String, Object> paraMap) {
        stc.verifyTrue(selenium.isTextPresent((String) paraMap
                .get(TestMailLoginConstants.VERIFY_STRING)));
    }
}