package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PriceListCsvGenerator extends CsvGenerator<Item>
{
    public static void main( String[] args ) throws IOException
    {
        new PriceListCsvGenerator().generateFile( "1234567890" , "csv-wibble.csv" );
    }

    @Override
    public String getHeaders()
    {
        return "Item name,Supplier Item ID,Order UOM,Increment,Number of base units,Quantity,Price,Tax Code,Delivery Item";
    }

    @Override
    public List<Item> getData()
    {
        ContentLoaderCSVGenerator itemGenerator = new ContentLoaderCSVGenerator();
        List<Item> items = new ArrayList<>(itemGenerator.getData());
        items.removeIf(item -> item.getitemType().equals("DELIVERY"));
        return  items;
    }

    @Override
    public String getLine(String uniqueId, Item item)
    {
        if (item.getitemType().contentEquals("STANDARD"))
            item.setId(uniqueId + item.getId());

            String fields   = String.join(",",item.getShortDescription(),
                    item.getId(),
                    "EA",
                     "1",
                     "1",
                     "1",
                     "200",
                     "S",
                     "NA");

        return fields;
    }
}
