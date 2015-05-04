package tse.tasks;

import java.util.HashMap;
import java.util.Properties;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import tse.utilities.PropUtils;
import tse.utilities.SeleniumUtils;

public class TestMailSendTasks {

    private final static String PROP_NAME = "tse/appObjects/mailSend.properties";

    private SeleniumUtils       utils;

    private Selenium            selenium;

    private Properties          elemMap;

    private SeleneseTestCase    stc       = new SeleneseTestCase();

    public TestMailSendTasks(SeleniumUtils utils) {
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
    
    public void clickCompose() {
    	stc.verifyTrue(utils.waitForElement((String) elemMap
    			.get(TestMailSendConstants.MAIL_SEND_COMPOSE_DOWN), 30));
    	selenium.mouseDown((String) elemMap
    			.get(TestMailSendConstants.MAIL_SEND_COMPOSE_DOWN));
    	stc.verifyTrue(utils.waitForElement((String) elemMap
    			.get(TestMailSendConstants.MAIL_SEND_COMPOSE_UP), 30));
    	selenium.mouseUp((String) elemMap
    			.get(TestMailSendConstants.MAIL_SEND_COMPOSE_UP));
	}
    
    public void typeMailField(HashMap<String, Object> paraMap) {
        System.out.println("the elemMap is" + elemMap + "..............");
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailSendConstants.MAIL_SEND_ADDRESS), 30));
        stc.verifyTrue(utils.waitForElement((String) elemMap
        		.get(TestMailSendConstants.MAIL_SEND_TITLE), 30));
        selenium.type((String) elemMap
                .get(TestMailSendConstants.MAIL_SEND_ADDRESS),
                (String) paraMap
                        .get(TestMailSendConstants.MAIL_SEND_ADDRESS));
        selenium.type((String) elemMap
                .get(TestMailSendConstants.MAIL_SEND_TITLE),
                (String) paraMap
                        .get(TestMailSendConstants.MAIL_SEND_TITLE));
    }

    public void clickSendBtn() {
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailSendConstants.MAIL_SEND_ACTION), 30));
        selenium.click((String) elemMap
                .get(TestMailSendConstants.MAIL_SEND_ACTION));
    }
    
    public void verifyResult(HashMap<String, Object> paraMap) {
        stc.verifyTrue(selenium.isTextPresent((String) paraMap
                .get(TestMailLoginConstants.VERIFY_STRING)));
    }
}