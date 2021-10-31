package com.basware.bttf.steps.bdd.glue.product_manager.supplier.media;

import com.basware.bttf.pages.product_manager.supplier.media.UploadFilesPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.support.UploadFile;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadFilesPageSteps extends AbstractSteps {
    @When("on Upload Files page - I upload '([^\"']*)' file$")
    public void addFiles(String fileName) throws Exception{
        UploadFilesPage uploadFilesPage = (UploadFilesPage)getCurrentPage();
        setCurrentPage(uploadFilesPage.addFiles(fileName));
    }


    @Then("on Upload Files page - I check that '([^\"']*)' upload status is '([^\"']*)'$")
    public void checkFileStatus(String fileName,String fileStatus) throws Exception{
        UploadFilesPage uploadFilesPage = (UploadFilesPage)getCurrentPage();
        setCurrentPage(uploadFilesPage.checkFileStatus(fileName,fileStatus));
    }

}
