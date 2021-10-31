package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockCsvGenerator extends CsvGenerator<Item> {
    public static void main( String[] args ) throws IOException
    {
        new StockCsvGenerator().generateFile( "1234567890" , "stock-wibble.csv" );
    }

    @Override
    public String getHeaders()
    {
        return "sku,location,quantity";
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

        String fields   = String.join(",",item.getId(),
                "London",
                "1");

        return fields;
    }
}
