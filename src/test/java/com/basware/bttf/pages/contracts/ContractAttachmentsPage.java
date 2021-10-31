package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContractAttachmentsPage extends ContractsPage {

    @FindBy(linkText = "Add Attachment")
    private WebElement addAttachmentButton;

    @FindBy(name = "attachment")
    private WebElement chooseFile;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/attachment";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Manage Attachments";
    }

    public ContractAttachmentsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddAttachment()
    {
        addAttachmentButton.click();
    }

    public void chooseFileToAttach()
    {
       chooseFile.sendKeys(getFilePath()+"pdf -02.pdf");
    }

    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }

}
