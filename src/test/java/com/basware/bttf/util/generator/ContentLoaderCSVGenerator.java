package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;

import java.io.IOException;
import java.util.List;

public class ContentLoaderCSVGenerator extends CsvGenerator<Item>
{
	public static void main( String[] args ) throws IOException
	{
		new ContentLoaderCSVGenerator().generateFile( "1234567890" , "content-loader-wibble.csv" );
	}

    @Override
    public String getHeaders()
    {
        return "Item ID,Item Name,Item Type,Delivery Item ID,Delivery Type,Unit of Measure,Number in an Order Unit,Unit Price,GBR Tax Code,TAX territory,Minimum Order Quantity,Quantity Interval,UNSPSC v8,Goods or Service?,Long Description,Keywords,Manufacturer Part Number,Manufacturer Name";
    }

    @Override
    public List<Item> getData()
    {
        return getUploadItemsList( testDataPath + "product-items.json" , Item[].class );
    }

    @Override
    public String getLine( String uniqueId , Item item )
    {
        if (item.getDeliveryId().contentEquals("NA"))
            item.setDeliveryId("NA");
        else
            item.setDeliveryId( uniqueId + item.getDeliveryId());


        String fields = String.join( "," , uniqueId + item.getId(),
                                            item.getShortDescription(),
                                            item.getitemType(),
                                            item.getDeliveryId(),
                                            item.getDeliveryType(),
                                            item.getUom(),
                                            item.getNumberInAnOrderUnit(),
                                            item.getPrice(),
                                            item.getMinOrderQty(),
                                            item.getQtyInterval(),
                                            item.getUnspsc(),
                                            item.getStandardType(),
                                            item.getLongDescription(),
                                            item.getKeywords(),
                                            item.getManPartId(),
                                            item.getManName()
         );

        return fields;
    }
}
