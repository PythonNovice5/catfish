package com.basware.bttf.util.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public abstract class CsvGenerator<T> extends AbstractFileGenerator<T>
{
    public abstract String getHeaders();
    public abstract List<T> getData();
    public abstract String getLine( String uniqueId , T item );

    @Override
    public void generateFile( String uniqueId , String fileName ) throws IOException
    {
        LOGGER.debug( "generateFile " + fileName + "\n");

        StringWriter writer = new StringWriter();

        String header = getHeaders();
        writer.write(header);
        writer.append( System.lineSeparator() );

        List<T> productItems = getData();

        for( T item : productItems )
        {
            String fields = getLine( uniqueId , item );
            writer.append( fields );
            writer.append( System.lineSeparator() );
        }

        writer.flush();
        writer.close();

        // write output to file
        writeFile( writer , temporaryFilePath + fileName );
    }
}
