package com.basware.bttf.steps.bdd.glue.shopping.punchin_out;

import com.basware.bttf.pages.external.punchout.LoginPagePunchOutTool;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Given;

public class PunchInSteps extends AbstractSteps {
    @Given("I log into POTT")
    public void loginToPunchOutTestTool()
    {
        LoginPagePunchOutTool loginPagePunchOutTool = new LoginPagePunchOutTool();
        loginPagePunchOutTool.loadPunchOutPage(driver);
        setCurrentPage(loginPagePunchOutTool);
    }
}
