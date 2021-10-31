package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;

import java.io.IOException;
import java.util.List;

public class AgentAgreementCSVGenerator extends CsvGenerator<Item> {

    public static void main( String[] args ) throws IOException
    {
        new AgentAgreementCSVGenerator().generateFile( "1234567890" , "agent-wibble.csv" );
    }

    @Override
    public String getHeaders() {
        return "Item ID,Item Name,Unit of Measure,Units per UOM,Unit Price,Min Order Quantity,Quantity Interval,UNSPSC v19,Long Description,Keywords,Content Tag,Manufacturer Part Number,Manufacturer Name,Image URL,Custom Field 1=Custom Value 1,Custom Field 2=Custom Value 2,Custom Field 3=Custom Value 3";
    }

    @Override
    public List<Item> getData() {
        return getUploadItemsList( testDataPath + "product-items.json" , Item[].class );
    }

    @Override
    public String getLine(String uniqueId, Item item) {
        String fields = String.join( "," , uniqueId + item.getId(),
                item.getShortDescription(),
                item.getUom(),
                item.getNumberInAnOrderUnit(),
                item.getPrice(),
                item.getMinOrderQty(),
                item.getQtyInterval(),
                item.getUnspsc(),
                item.getLongDescription(),
                item.getKeywords(),
                "",
                item.getManPartId(),
                item.getManName(),
                "https://secure.i.telegraph.co.uk/multimedia/archive/03476/autumn-winkworth_3476791k.jpg",
                "",
                "",
                ""
        );

        return fields;
    }
}
