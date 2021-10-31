package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class PriceListDeliveryItemsDirectoryPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( PriceListDeliveryItemsDirectoryPage.class.getName() );

    public PriceListDeliveryItemsDirectoryPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceList/deliveryItemDirectory";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Price List Delivery Items";
    }

    public ManagePriceListDeliveryItemPage addDeliveryItem() throws Exception{
        pauseFor(2000);
        clickPlusBtn();
        return new ManagePriceListDeliveryItemPage();
    }

    public ManagePriceListPage clickDone(){
        clickDoneBtn();
        return new ManagePriceListPage();
    }


}
