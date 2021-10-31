package com.basware.bttf;

import com.basware.bttf.config.SpringConfig;
import com.basware.bttf.util.TestProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions (
        snippets = SnippetType.CAMELCASE,
        plugin = {"html:target/cucumber-html-report","rerun:rerun.txt","json:target/home.json"},
        features = "src/test/resources/features",
        tags = {"@BuyTemplatedItem,@PORItemE2E,@ItemTemplate,@StandardItem,@ItemWithTemplateItem,@ContractItem,@DeliveryItem,@OrgLists,@buyer_agreements,@BuyerAgreementDirectory,@SupplierAgreementDirectory,@Approvals,@rfq,@marketplace_search_and_compare,@groups_directory,@groups,@Views,@contentTag,@Categories,@ItemDirectoryFilters,@ItemDirectoryOrderBy,@ftr,@PunchOutItem,@Coder,@ProductManagerPriceList,@PriceListDirectoryFilters,@AgreementFilterCheckInPricelist,@MatrixItem,@ShoppingLists,@CreatePOAndVerifyDT,@RFQOld,@DocumentTracker"}
)

public class RunCukesTest
{
}
