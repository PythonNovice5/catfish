package com.basware.bttf.util.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class AbstractFileGenerator<T>
{
    protected static Logger LOGGER = Logger.getLogger( AbstractFileGenerator.class.getName() );

    protected final static String templatePath = "src/test/resources/generator/templates/";
    public final static String testDataPath = "src/test/resources/generator/test_data/";
    protected final static String temporaryFilePath = "src/test/resources/testdata/temp/";

    public abstract void generateFile( String uniqueId , String fileName ) throws IOException;

    public List<T> getUploadItemsList( String fileName , Class<T[]> _class )
    {
        ObjectMapper jsonSlurper = new ObjectMapper();

        String path = null;
        List<T> items = null;

        try
        {
            items = Arrays.asList( jsonSlurper.readValue( readFile( fileName ) , _class ) );
        }
        catch( IOException e )
        {
            LOGGER.error( "<T> getUploadItemsList() - error reading file: " + fileName , e );
            System.exit(-1);
        }

        return items;
    }

    public List<String> getUploadItemsList( String fileName )
    {
        String path = null;
        List<String> items = null;

        try
        {
            String[] data = readFile( fileName ).split( "\n" );
            items = Arrays.asList( data );
        }
        catch( IOException e )
        {
            LOGGER.error( "getUploadItemsList() - error reading file: " + fileName , e );
            System.exit(-1);
        }

        return items;
    }

    public String readFile( String fileName ) throws IOException
    {
        LOGGER.debug( "fileName: " + fileName );

        Path path = FileSystems.getDefault().getPath( fileName ).toAbsolutePath();

        if( path.toFile().exists() )
        {
            List<String> data = Files.readAllLines( path , Charset.forName("UTF-8"));
            return String.join("\n", data);
        }
        else
        {
            LOGGER.error( "readFile() - file does not exist: " + path );
            System.exit(-1);
        }

        return null;
    }

    public void writeFile( Writer writer , String fileName ) throws IOException
    {
        OutputStreamWriter os = new OutputStreamWriter( new FileOutputStream( fileName ) , StandardCharsets.UTF_8 );
        BufferedWriter bufferedWriter = new BufferedWriter( os );
       // BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( fileName ) );

        bufferedWriter.write( writer.toString() );
        bufferedWriter.close();
    }

    public static void deleteFile()
    {
        File file = new File( temporaryFilePath );
        String[] myTempFiles;
        if (file.exists() && file.isDirectory())
        {
            myTempFiles = file.list();
            for (int i=0; i < myTempFiles.length; i++)
            {
                File myFileToDelete = new File(file, myTempFiles[i]);
                myFileToDelete.delete();
            }
        }
        else
        {
            file.mkdir();
        }
    }

    public boolean doesFileExist(String file)
    {
        File f = new File( temporaryFilePath + file );

        if(f.exists() && !f.isDirectory())
        {
            return true;
        }

        return false;
    }


   public void generateZipFile(String path, String zipFilePath) throws IOException {
           FileOutputStream zipFileName = new FileOutputStream(temporaryFilePath +zipFilePath);
           ZipOutputStream zipOut = new ZipOutputStream(zipFileName);
           File fileToZip = new File(temporaryFilePath +path);
           FileInputStream fis = new FileInputStream(fileToZip);
           ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
           zipOut.putNextEntry(zipEntry);
           byte[] bytes = new byte[1024];
           int length;
           while ((length = fis.read(bytes)) >= 0) {
               zipOut.write(bytes, 0, length);
           }
           zipOut.close();
           fis.close();
           zipFileName.close();
       }

}
