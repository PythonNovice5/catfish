package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PriceListDirectoryPage extends ProductManagerDirectoryPage<PriceListDirectoryPage> {
    protected static Logger LOGGER = Logger.getLogger(PriceListDirectoryPage.class.getName());


    @FindBy( xpath="//button[@name='btn-sortBy']/span" )
    public WebElement SortFilterValue ;

    @FindBy( xpath="//button[@name='btn-filter']//span" )
    public WebElement SortPerPageValue;

    @FindBy(id="modalConfirmOk")
    public WebElement DeleteConfirm;

    @FindBy(id = "resultsShown_1")
    public WebElement ResultsShownTop;

    // Buttons
    @FindBy(linkText = "Create")
    public WebElement priceListsDirectoryButtonCreate;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[1]/div[2]/a")
    public WebElement priceListsDirectoryFirstPriceListButtonManage;

    // First Price List Details
    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[1]/div[1]/strong/a")
    public WebElement priceListsDirectoryFirstPriceListName;


    String PlusBtn = "//span[@class=glyphicon glyphicon-plus]";

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[1]/div[1]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListReference;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[1]/div[2]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListStatus;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[1]/div[3]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListKeywords;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[2]/div[1]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListType;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[2]/div[2]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListCurrency;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[2]/div[2]/div[3]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListItems;

    @FindBy(xpath = "//div[@id='pricelistTable']/div[1]/div/div[3]/div[2]")
    public WebElement priceListsDirectoryFirstPriceListDescription;


    // Sort by
    @FindBy(linkText = "Relevance")
    public WebElement priceListsDirectoryDropDownSortRelevance;

    @FindBy(linkText = "Name")
    public WebElement priceListsDirectoryDropDownSortName;

    @FindBy(linkText = "Last modified")
    public WebElement priceListsDirectoryDropDownSortLastModified;

    // Filters
    @FindBy(xpath = "//a[normalize-space(text())='All']")
    public WebElement priceListsDirectoryFilterAll;

    @FindBy(xpath = "//a[normalize-space(text())='Standard']")
    public WebElement priceListsDirectoryFilterStandard;

    @FindBy(xpath = "//a[normalize-space(text())='Punchout']")
    public WebElement priceListsDirectoryFilterPunchout;

    @FindBy(xpath = "//a[normalize-space(text())='New']")
    public WebElement priceListsDirectoryFilterNew;

    @FindBy(xpath = "//a[normalize-space(text())='Unpublished']")
    public WebElement priceListsDirectoryFilterUnpublished;

    @FindBy(xpath = "//a[normalize-space(text())='Published']")
    public WebElement priceListsDirectoryFilterPublished;

    @FindBy(xpath = "//a[normalize-space(text())='Modified']")
    public WebElement priceListsDirectoryFilterModified;

    @FindBy(xpath = "//a[normalize-space(text())='Withdrawn']")
    public WebElement priceListsDirectoryFilterWithdrawn;

    @FindBy(xpath = "//a[normalize-space(text())='Linked to agreements']")
    public WebElement priceListsDirectoryFilterLinkedToAgreements;

    @FindBy(xpath = "//a[normalize-space(text())='Not linked to any agreement']")
    public WebElement priceListsDirectoryFilterNotLinkedToAnyAgreement;

    @FindBy(xpath = "//a[normalize-space(text())='With items']")
    public WebElement priceListsDirectoryFilterWithItems;

    @FindBy(xpath = "//a[normalize-space(text())='Without items']")
    public WebElement priceListsDirectoryFilterWithoutItems;

    @FindBy(xpath = "//span[@title='Delete']")
    public WebElement DeleteBtn;

    public PriceListDirectoryPage() {
        PageFactory.initElements(driver, this);
    }

    public String getExpectedUrl() {
        return getBaseUrl() + "/products/priceList";
    }

    public String getExpectedTitle() {
        return "Product Manager: Price Lists";
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(new HashMap<String,WebElement>()
        {{
            put("Relevance",priceListsDirectoryDropDownSortRelevance);
            put("Name",priceListsDirectoryDropDownSortName);
            put("Last modified",priceListsDirectoryDropDownSortLastModified);
        }});

    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "All", priceListsDirectoryFilterAll );
                    put( "Standard", priceListsDirectoryFilterStandard );
                    put( "Punchout", priceListsDirectoryFilterPunchout );
                    put( "New", priceListsDirectoryFilterNew );
                    put( "Unpublished", priceListsDirectoryFilterUnpublished );
                    put( "Published", priceListsDirectoryFilterPublished );
                    put( "Modified", priceListsDirectoryFilterModified );
                    put( "Withdrawn", priceListsDirectoryFilterWithdrawn );
                    put( "Linked to Agreement(s)", priceListsDirectoryFilterLinkedToAgreements );
                    put( "Not linked to any Agreement", priceListsDirectoryFilterNotLinkedToAnyAgreement );
                    put( "With Items", priceListsDirectoryFilterWithItems );
                    put( "Without Items", priceListsDirectoryFilterWithoutItems );
                }}
        );
    }


    public boolean getShowingResults(String regex, long first, long second, long total) throws ParseException {

        waitUntilDisplayed(directoryResultsCountLabel);
        String resultsCountStr = directoryResultsCountLabel.getText();

        LOGGER.debug("getShowingResults() - resultsCountStr = '" + resultsCountStr + "'");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(resultsCountStr);
        matcher.find();

        long _first = NumberFormat.getInstance().parse(matcher.group(1)).longValue();
        long _second = NumberFormat.getInstance().parse(matcher.group(2)).longValue();
        long _total = NumberFormat.getInstance().parse(matcher.group(3)).longValue();

        return (first == _first) && (second == _second) && (total == _total);
    }

    public String getFirstPriceListFieldValue(String fieldName) throws Exception {
        String fieldValue = "";
        waitUntilDisplayed(priceListsDirectoryFirstPriceListName);
        switch (fieldName) {
            case "Name":
//                waitUntilDisplayed(priceListsDirectoryFirstPriceListName);
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListName);
                break;
            case "Reference":
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListReference);
                break;
            case "Status":
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListStatus);
                break;
            case "Keywords":
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListKeywords);
                break;
            case "Type":
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListType);
                break;
            case "Currency":
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListCurrency);
                break;
            case "Items":
                int actualNumber = Integer.parseInt(priceListsDirectoryFirstPriceListItems.getText());

                long giveUpAt = System.currentTimeMillis()+ 7000;

                while (System.currentTimeMillis() < giveUpAt && actualNumber == 0) {
                    pauseFor(2000);
                    driver.navigate().refresh();
                }
                fieldValue = getTextOfWebElement(priceListsDirectoryFirstPriceListItems);
                break;
            case "Description":
                fieldValue = priceListsDirectoryFirstPriceListDescription.getText();
                break;
        }
        return fieldValue;
    }

    public void enterValueIntoField(String value, String fieldName) throws InterruptedException {
        switch (fieldName) {
            case "Keywords": {
                directoryInputSearch.sendKeys(value);
                break;
            }
            case "Search":
                if (value.contains("PriceListName")) {
                    LOGGER.debug("PRICE LIST NAME ----------  " + props.get("plName"));
                    directoryInputSearch.sendKeys(props.get("plName"));
                    break;
                }
                directoryInputSearch.sendKeys(value);
        }
    }

    public ProductManagerPage clickButton(String buttonName) throws Exception {
        switch (buttonName) {
            case "Clear Keywords":
                return clickButtonClearKeywords();
            case "Search":
                return clickButtonSearch();
            case "Plus":
                clickAddBtn(PlusBtn);
                return new PriceListDirectoryPage();
            case "Delete":
//                DeleteBtn.click();
                waitUntillElementIsClickableAndClick(DeleteBtn);
                waitUntillElementIsClickableAndClick(DeleteConfirm);
//                if (isModalAlertPresent() == true) {
//                    clickModalAlertButton("accept");
//                }
                return new PriceListDirectoryPage();

        }
        return null;
    }

    public CreatePriceListPage clickButtonCreate() {
        priceListsDirectoryButtonCreate.click();
        return new CreatePriceListPage();
    }

    public ManagePriceListPage clickFirstPriceListNameClick() {
        priceListsDirectoryFirstPriceListName.click();
        return new ManagePriceListPage();
    }

    public ManagePriceListPage clickFirstPriceListButtonManage() {
        priceListsDirectoryFirstPriceListButtonManage.click();
        return new ManagePriceListPage();
    }

    public PriceListDirectoryPage checkFilter(String filter) throws Exception {

        LOGGER.debug("Verifying Filter --- " + filter.toUpperCase() + "\n");
        try {
            switch (filter) {
                case "Standard":
                    getFirstPriceListFieldValue("Type");
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Type"), filter);
                    break;
                case "Punchout":
                    getFirstPriceListFieldValue("Type");
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Type"), filter);
                    break;
                case "New":
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Status"), filter);
                    break;
                case "Unpublished":
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Status"), filter);
                    break;
                case "published":
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Status"), filter);
                    break;
                case "Modified":
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Status"), filter);
                    break;
                case "Withdrawn":
                    assertEquals("Unexpected value", getFirstPriceListFieldValue("Status"), filter);
                    break;
                case "With Items":
                    assertTrue("No Item was found with the price list", Integer.parseInt(getFirstPriceListFieldValue("Items")) > 0);
                    break;
                case "Without Items":
                    assertTrue("Unexpected Item was found with the price list", Integer.parseInt(getFirstPriceListFieldValue("Items")) == 0);
                    break;
            }
            LOGGER.debug("Filter --- " + filter.toUpperCase() + "verified successfully");
        } catch (Exception e) {
            String actualValue = getTextOfWebElement(ResultsShownTop);
            assertEquals("Unexpected value", "0-0 / 0", actualValue);
            LOGGER.debug("Filter --- " + filter.toUpperCase() + " verified successfully with values - " + actualValue);

        }
        return new PriceListDirectoryPage();
    }
}
