package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.RelatedItem;
import com.basware.bttf.util.generator.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BundledCSVGenerator extends CsvGenerator<RelatedItem>
{
    public static void main( String[] args ) throws IOException

    {
        new BundledCSVGenerator().generateFile( "1234567890" , "content-loader-wibble.csv" );
    }

    @Override
    public String getHeaders() {
        return "Bundle master,Item or Matrix,Bundle component,Quantity Type,Component Type";

    }

    @Override
    public List<RelatedItem> getData()
    {
        ContentLoaderCSVGenerator itemGenerator = new ContentLoaderCSVGenerator();
        List<Item> items = new ArrayList<>(itemGenerator.getData());
        items.removeIf(item -> item.getitemType().equals("DELIVERY"));
        Item master = items.remove(0);
        items = items.subList(0, 4);
        List<RelatedItem> relatedItems = new ArrayList<>();
        for (Item item : items)
        {
            RelatedItem relatedItem = new RelatedItem();
            relatedItem.setRelatedMaster(master);
            relatedItem.setRelatedItem(item);
            relatedItems.add(relatedItem);
        }
        return relatedItems;
    }

    @Override
    public String getLine(String uniqueId , RelatedItem itemToBundle )
    {
        String firstItem = uniqueId + itemToBundle.getRelatedMaster().getId();

        String fields   = String.join(",",firstItem,
                          "ITEM",
                          uniqueId + itemToBundle.getRelatedItem().getId(),
                          "FIXED",
                          "OPTIONAL");

        return fields;
    }
}
