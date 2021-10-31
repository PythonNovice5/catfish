package com.basware.bttf.pages.product_manager.supplier.supplier_delegation;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaswareUkDashBoardPage extends ProductManagerPage {


    public BaswareUkDashBoardPage(){
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return "otis/home.html?cid";
    }

    @Override
    public String getExpectedTitle() {
        return "Basware UK Dashboard";
    }




}
