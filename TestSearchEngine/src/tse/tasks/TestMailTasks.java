package tse.tasks;

import java.util.HashMap;
import java.util.Properties;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

import tse.utilities.PropUtils;
import tse.utilities.SeleniumUtils;

public class TestMailTasks {

    private final static String PROP_NAME = "tse/appObjects/mailPages.properties";

    private SeleniumUtils       utils;

    private Selenium            selenium;

    private Properties          elemMap;

    private SeleneseTestCase    stc       = new SeleneseTestCase();

    public TestMailTasks(SeleniumUtils utils) {
        this.utils = utils;
        selenium = this.utils.getSelenium();
        elemMap = PropUtils.getProperties(PROP_NAME);
    }

    public void openSite() {
        selenium.open("/");
    }

    public void typeLoginTxtField(HashMap<String, Object> paraMap) {
        System.out.println("get into typing!!!!!!!!!!!");
        System.out.println("the elemMap is" + elemMap + "..............");
        stc.verifyTrue(utils.waitForElement((String) elemMap.get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_1), 30));
        stc.verifyTrue(utils.waitForElement((String) elemMap.get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_2), 30));
        selenium.type((String) elemMap.get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_1),
                (String) paraMap.get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_1));
        selenium.type((String) elemMap
                .get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_2),
                (String) paraMap
                        .get(TestMailConstants.MAIL_LOGIN_TXT_FIELD_2));
    }

    public void clickLoginBtn() {
        System.out.println("Clicked!!!!!!!!!!!");
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_LOGIN_BTN), 30));
        selenium.click((String) elemMap
                .get(TestMailConstants.MAIL_LOGIN_BTN));
    }
    
    public void clickComposeBtn() {
    	stc.verifyTrue(utils.waitForElement((String) elemMap
    			.get(TestMailConstants.MAIL_COMPOSE), 30));
    	selenium.mouseDown((String) elemMap
    			.get(TestMailConstants.MAIL_COMPOSE));
    	stc.verifyTrue(utils.waitForElement((String) elemMap
    			.get(TestMailConstants.MAIL_COMPOSE), 30));
    	selenium.mouseUp((String) elemMap
    			.get(TestMailConstants.MAIL_COMPOSE));
	}
    
    public void typeMailField(HashMap<String, Object> paraMap) {
        System.out.println("the elemMap is" + elemMap + "..............");
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_SEND_ADDRESS), 30));
        stc.verifyTrue(utils.waitForElement((String) elemMap
        		.get(TestMailConstants.MAIL_SEND_TITLE), 30));
        selenium.type((String) elemMap
                .get(TestMailConstants.MAIL_SEND_ADDRESS),
                (String) paraMap
                        .get(TestMailConstants.MAIL_SEND_ADDRESS));
        selenium.type((String) elemMap
                .get(TestMailConstants.MAIL_SEND_TITLE),
                (String) paraMap
                        .get(TestMailConstants.MAIL_SEND_TITLE));
    }

    public void clickSendBtn() {
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_SEND_ACTION), 30));
        selenium.click((String) elemMap
                .get(TestMailConstants.MAIL_SEND_ACTION));
    }
    
    //click checkbox of the first mail in inbox
    public void clickCheckBox() {
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_CHECK_BOX), 30));
        selenium.click((String) elemMap
                .get(TestMailConstants.MAIL_CHECK_BOX));
    }
    
    //click delete, using mouseDown mouseUp
    public void clickDelete() {
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_DELETE_BTN), 30));
        selenium.mouseDown((String) elemMap
                .get(TestMailConstants.MAIL_DELETE_BTN));
        stc.verifyTrue(utils.waitForElement((String) elemMap
                .get(TestMailConstants.MAIL_DELETE_BTN), 30));
        selenium.mouseUp((String) elemMap
                .get(TestMailConstants.MAIL_DELETE_BTN));
    }
    // public void verifyResult(HashMap<String, Object> paraMap) {
    //     stc.verifyTrue(selenium.isTextPresent((String) paraMap
    //             .get(TestMailConstants.VERIFY_STRING)));
    // }
}