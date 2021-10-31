package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class OfficeDepotHomePage extends ExternalPage {

    public OfficeDepotHomePage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/billboard/"; }

    public String getExpectedTitle()
    {
        return "Office Supplies: Office Products and Office Furniture: Office Depot";
    }

    @FindBy(xpath = "//span[text()='Office Supplies']")
    public WebElement OfficeSupplies;

    @FindBy(linkText = "Diaries")
    public WebElement Diaries;

    @FindBy(linkText = "Ballpoint Pens")
    public WebElement BallpointPens;

    @FindBy(linkText = "Box Files")
    public WebElement BoxFiles;

    public ExternalPage clickElement(String elem) throws Exception {
        hoverToElement(OfficeSupplies);
        switch (elem){
            case "Box Files":
                waitUntillElementIsClickableAndClick(BoxFiles);
            case "Diaries":
                waitUntillElementIsClickableAndClick(Diaries);
            case "Ballpoint Pens":
                waitUntillElementIsClickableAndClick(BallpointPens);
                return new OfficeDepotBallPointPensPage();

        }

        return new OfficeDepotDiariesCalendersPage();
    }

}
