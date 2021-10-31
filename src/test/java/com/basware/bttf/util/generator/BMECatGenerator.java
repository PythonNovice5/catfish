package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class BMECatGenerator extends AbstractFileGenerator<Item>
{
    public static final String GENERATOR = "Basware Content Loader 4.2";
    public static final String LANGUAGE = "eng";
    public static final String CATALOG_ID = "Basware Test Cat #01";
    public static final String CATALOG_VERSION = "004.002";
    public static final String CATALOG_NAME = "Automatically generated catalogue for Basware automated Test Framework (Catfish)";
    public static final String TERRITORY = "GB";
    public static final String CURRENCY = "GBP";
    public static final String BUYER_NAME = "Buyer Org";
    public static final String SUPPLIER_NAME = "Supplier Org";

    public static void main( String[] args ) throws IOException
    {
        new BMECatGenerator().generateFile( "1234567890" , "bmecat-wibble.xml" );
    }

    public void generateFile( String uniqueId , String fileName ) throws IOException
    {
        LOGGER.debug( "generateBMEcatFile " + fileName + "\n");

        List<Item> productItems = getUploadItemsList( testDataPath + "product-items.json" , Item[].class );

        for (Item item : productItems)
        {
            item.setId( uniqueId + item.getId() );
            if (item.getDeliveryId().contentEquals("NA"))
                item.setDeliveryId("NA");
            else
                item.setDeliveryId( uniqueId + item.getDeliveryId());
        }

        String template = readFile( templatePath + "BMECat.vm" );

        /* ==================================
         *  Start and init Velocity context
         * ================================== */
        Velocity.init();
        VelocityContext context = new VelocityContext();

        // add model to context
        context.put( "generator"    , GENERATOR );
        context.put( "lang"         , LANGUAGE );
        context.put( "catId"        , CATALOG_ID );
        context.put( "catVer"       , CATALOG_VERSION );
        context.put( "catName"      , CATALOG_NAME );
        context.put( "territory"    , TERRITORY );
        context.put( "currency"     , CURRENCY );
        context.put( "buyerName"    , BUYER_NAME );
        context.put( "supplierName" , SUPPLIER_NAME );
        context.put( "productItems" , productItems );

        // generate and write output
        StringWriter writer = new StringWriter();
        Velocity.evaluate( context , writer , "BMECAT" , template );
        writer.close();

        // write output to file
        writeFile( writer , temporaryFilePath + fileName );
    }
}