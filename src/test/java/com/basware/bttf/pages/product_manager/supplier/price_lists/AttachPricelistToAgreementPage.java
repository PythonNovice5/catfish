package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.SupplierManageAgreementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AttachPricelistToAgreementPage extends ProductManagerDirectoryPage {


    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+"/products/attachPriceList/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Select Agreement Price List";
    }

    public AttachPricelistToAgreementPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void searchPriceList()
    {
        directoryInputSearch.sendKeys(props.get("plName"));
        clickButtonSearch();
    }

    public SupplierManageAgreementPage addPricelistToAgreement() {

        pauseFor(1000);
        long giveUpAt = System.currentTimeMillis()+ 5000;

        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-plus']")).size() ==0)
        {
            pauseFor(1000);
            driver.navigate().refresh();
        }
        clickPlusBtn();
        return new SupplierManageAgreementPage();
    }

}
