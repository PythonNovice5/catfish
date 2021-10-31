package com.basware.bttf.support;

import com.basware.bttf.util.TestProperties;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Thread.sleep;

public class UploadFile
{
    protected static Logger LOGGER = Logger.getLogger( UploadFile.class.getName() );

    public int uploadFile(String fileToUploadLocation)
    {

        try {
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        int timeInSeconds = 3;

        //String autoItExecutable = (new File("").getAbsolutePath() + "\\src\\test\\resources\\executables\\uploadFile.exe");
        String autoItExecutable = (new File("").getAbsolutePath() + "\\src\\test\\resources\\executables\\uploadFile-File_Uploadx64.exe");

        if ( !Files.isReadable( Paths.get(autoItExecutable) ) ){
            System.out.println("*** WARNING " + autoItExecutable + " is not readable ***");
        }

        if ( !Files.isReadable( Paths.get(autoItExecutable) ) ){
            System.out.println("*** WARNING " + autoItExecutable + " is not executable ***");
        }

        try{
            Process p = Runtime.getRuntime().exec( autoItExecutable + " " + fileToUploadLocation + " " + Integer.toString(timeInSeconds) );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("*** IOException is " + e + " ***");
        }

        try {
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        System.out.println("**********************************************************");
        System.out.println("*** Upload Starts ........................................");

        return 0;
    }

}
