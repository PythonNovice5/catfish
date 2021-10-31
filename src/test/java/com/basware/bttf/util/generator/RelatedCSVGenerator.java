package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.RelatedItem;

import java.io.IOException;

public class RelatedCSVGenerator extends BundledCSVGenerator {

    public static void main( String[] args ) throws IOException

    {
        new BundledCSVGenerator().generateFile( "1234567890" , "content-loader-wibble.csv" );
    }

    @Override
    public String getHeaders() {
        return "Master item,Related Items";

    }

    @Override
    public String getLine(String uniqueId , RelatedItem itemToBundle )
    {
        String firstItem = uniqueId + itemToBundle.getRelatedMaster().getId();

        String fields   = String.join(",",firstItem,
                uniqueId + itemToBundle.getRelatedItem().getId());

        return fields;
    }
}
