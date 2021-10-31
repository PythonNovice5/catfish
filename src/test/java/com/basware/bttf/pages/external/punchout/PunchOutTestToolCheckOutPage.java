package com.basware.bttf.pages.external.punchout;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PunchOutTestToolCheckOutPage extends LoginPagePunchOutTool {
    protected static Logger LOGGER = Logger.getLogger( PunchOutTestToolCheckOutPage.class );


    @FindBy(xpath = "//textarea")
    public WebElement ItemDetails;

    public PunchOutTestToolCheckOutPage()
    {
        PageFactory.initElements( driver , this );
    }
    public String getExpectedUrl()
    {
        return "https://jupiter-buyers.procserveonline.com/punchout-test-tool/checkout";
    }

    public String getExpectedTitle()
    {
        return "Punchout Test Tool";
    }

    public LoginPagePunchOutTool verifyItemDetails() throws Exception {

        String s = getTextOfWebElement(ItemDetails);
        assertTrue("Item ID was not found",s.contains(props.get("ItemID")));
        LOGGER.debug("ITEM ID - "+props.get("ItemID")+" was found");

        String amount = props.get("ItemPriceWithoutTax");
        DecimalFormat decimalFormat = new DecimalFormat("0.#####");
        String result = decimalFormat.format(Double.valueOf(amount));

        assertTrue("Item Price was not matching Expected: "+result,s.contains(result));
        LOGGER.debug("Item Price verified successfully as - "+props.get("ItemPriceWithoutTax"));

        assertTrue("Item Currency was not same as in Shopping Basket",s.contains(props.get("ItemCurrency")));
        LOGGER.debug("Item Currency was same as in Shopping Basket as - "+props.get("ItemCurrency"));
        switchToNewWindow(new LoginPagePunchOutTool());
        return new LoginPagePunchOutTool();
    }

    public LoginPagePunchOutTool verifyExpressCheckoutDetails() throws Exception{
        String shoppingBasket = getTextOfWebElement(ItemDetails);
        Assert.assertTrue("Express Check out was not performed successfully",shoppingBasket.contains("EXPRESS"));
        LOGGER.debug("Express check out verified successfully ..");
        return new PunchOutTestToolCheckOutPage();

    }

    public LoginPagePunchOutTool verifyShoppingBasketOnOCIPunchin() throws Exception {

        String shoppingBasket = getTextOfWebElement(ItemDetails);
        String[] subStringShoppingBasket = shoppingBasket.split("\n");
        Map<String,Map<String,String> > data = new HashMap<>();
        for(String shoppingBasketEntry : subStringShoppingBasket)
        {
            Pattern pattern = Pattern.compile("(.*?)\\[(\\d+)] : (.*)");
            Matcher matcher = pattern.matcher(shoppingBasketEntry);
            if(matcher.matches()){
                data.putIfAbsent(matcher.group(2),new HashMap<>());
                data.get(matcher.group(2)).put(matcher.group(1),matcher.group(3));
            }
        }
        Map<String,Map<String,String> > data2 = new HashMap<>();
        for(Map<String,String> s3 :data.values())
        {
            data2.put(s3.get("NEW_ITEM-VENDORMAT"), s3);
        }

        //Verifying each item in the basket
        assertTrue(data2.containsKey("Automation-2"));
        assertEquals("1", data2.get("Automation-2").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("5", data2.get("Automation-2").get("NEW_ITEM-PRICE"));


        assertTrue(data2.containsKey("Automation-Bundle"));
        assertEquals("1", data2.get("Automation-Bundle").get("NEW_ITEM-QUANTITY"));
        assertEquals("1000",data2.get("Automation-Bundle").get("NEW_ITEM-PRICE"));

        assertTrue(data2.containsKey("Automation-5"));
        assertEquals("1", data2.get("Automation-5").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("800", data2.get("Automation-5").get("NEW_ITEM-PRICE"));

        assertTrue(data2.containsKey("Automation-6"));
        assertEquals("1", data2.get("Automation-6").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("800", data2.get("Automation-6").get("NEW_ITEM-PRICE"));

        assertTrue(data2.containsKey("Automation-7"));
        assertEquals("1", data2.get("Automation-7").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("800", data2.get("Automation-7").get("NEW_ITEM-PRICE"));

        assertTrue(data2.containsKey("AutomationMatrix-2"));
        assertEquals("1", data2.get("AutomationMatrix-2").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("8", data2.get("AutomationMatrix-2").get("NEW_ITEM-PRICE"));

        assertTrue(data2.containsKey("AutomationTemplate-01"));
        assertEquals("1", data2.get("AutomationTemplate-01").get("NEW_ITEM-QUANTITY"));
        assertEquals("80", data2.get("AutomationTemplate-01").get("NEW_ITEM-PRICE"));
        assertTrue( data2.get("AutomationTemplate-01").get("NEW_ITEM-CUST_FIELD2").contains("UOM=EA;EAN=Ultra Cotton;PRICE=100;Yes=Cotton Adult Long Sleeve;instruction=Double needle;SKU=AutomationTemplate-01;SUP=S"));

        assertTrue(data2.containsKey("CoderCatfish01"));
        assertEquals("1", data2.get("CoderCatfish01").get("NEW_ITEM-QUANTITY")); ;
        assertEquals("catfishcoder", data2.get("CoderCatfish01").get("NEW_ITEM-BW-ITEM-ACC-CODE"));
        assertEquals("catfishcoder", data2.get("CoderCatfish01").get("NEW_ITEM-CUST_FIELD3"));
        switchToNewWindow(new LoginPagePunchOutTool());
        return new LoginPagePunchOutTool();
    }

    public LoginPagePunchOutTool verifyShoppingBasketOnCXMLPunchin() throws Exception {

        String shoppingBasket = getTextOfWebElement(ItemDetails);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc =  dBuilder.parse(new InputSource(new StringReader(shoppingBasket)));

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("ItemIn");
        Map<String,Element> data2 = new HashMap<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("Current Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                data2.put(eElement.getElementsByTagName("SupplierPartID").item(0).getTextContent(),eElement);
            }
        }

        assertTrue(data2.containsKey("Automation-2"));
        assertEquals("5",data2.get("Automation-2").getElementsByTagName("Money").item(0).getTextContent());
        assertEquals("1",data2.get("Automation-2").getAttribute("quantity"));

        assertTrue(data2.containsKey("Automation-Bundle"));
        assertEquals("1000",data2.get("Automation-Bundle").getElementsByTagName("Money").item(0).getTextContent());
        assertEquals("1",data2.get("Automation-Bundle").getAttribute("quantity"));


        assertTrue(data2.containsKey("Automation-5"));
        assertEquals("800",data2.get("Automation-5").getElementsByTagName("Money").item(0).getTextContent());
        assertEquals("1",data2.get("Automation-5").getAttribute("quantity"));

        assertTrue(data2.containsKey("Automation-6"));
        assertEquals("800",data2.get("Automation-6").getElementsByTagName("Money").item(0).getTextContent());
        assertEquals("1",data2.get("Automation-6").getAttribute("quantity"));

        assertTrue(data2.containsKey("Automation-7"));
        assertEquals("800",data2.get("Automation-7").getElementsByTagName("Money").item(0).getTextContent());
        assertEquals("1",data2.get("Automation-7").getAttribute("quantity"));

        switchToNewWindow(new LoginPagePunchOutTool());
        return new LoginPagePunchOutTool();
    }
}
