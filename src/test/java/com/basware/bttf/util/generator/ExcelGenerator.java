package com.basware.bttf.util.generator;

import com.basware.bttf.util.generator.model.Item;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class ExcelGenerator extends AbstractFileGenerator<Item> {

    public static void main( String[] args ) throws IOException
    {
        new ExcelGenerator().generateFile( "1234567890" , "content-loader-wibble.xlsx" );
    }

    public void updateFile(int rownum,int colnum,String fileName, String valueToBeEntered) throws IOException{
        try {
            FileInputStream inputStream = new FileInputStream(new File(testDataPath+fileName));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet("Item Data");
            Row r = sheet.getRow(rownum-1);
            Cell c = r.getCell(colnum-1);
            c.setCellValue(valueToBeEntered);
            FileOutputStream outputStream = new FileOutputStream(testDataPath+fileName);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            LOGGER.debug("Successfully Updated Pricelist name .. ");

        } catch (IOException | EncryptedDocumentException
               ex) {
            ex.printStackTrace();
        }

    }


    public void generateFile(String uniqueId, String fileName) throws IOException {

        LOGGER.debug("generateFile " + fileName + "\n");
        String[] actualNames = {"Main Menu","Instructions","Examples","UOM Definitions","UNSPSC v8","UNSPSC v19","Item Data"};
        XSSFWorkbook workbook = new XSSFWorkbook();


        for (String actualName : actualNames) {
            workbook.createSheet(actualName);
        }

        XSSFSheet sheetName = workbook.getSheet("Item Data");
        int rowCount = 3;

            Row row = sheetName.createRow(rowCount);

            String[] headers = {"Item ID","Item Name","Item Type","Delivery Item ID","Delivery Type","Unit of Measure","Number in an Order Unit","Unit Price","No Tax Code","Minimum Order Quantity","Quantity Interval","UNSPSC v8","Goods or Service?","Long Description","Keywords","Manufacturer Part Number","Manufacturer Name"};
              for(int i = 0; i < headers.length; i++ ) {
                  row.createCell(i).setCellValue(headers[i]);
              }

       List<Item> items = getUploadItemsList( testDataPath + "product-items.json" , Item[].class );


        for(Item item: items){
            Row itemRow = sheetName.createRow(++rowCount);

            if (item.getDeliveryId().contentEquals("NA"))
                item.setDeliveryId("NA");
            else
                item.setDeliveryId( uniqueId + item.getDeliveryId());

            itemRow.createCell(0).setCellValue(uniqueId + item.getId());
            itemRow.createCell(1).setCellValue(item.getShortDescription());
            itemRow.createCell(2).setCellValue(item.getitemType());
            itemRow.createCell(3).setCellValue(item.getDeliveryId());
            itemRow.createCell(4).setCellValue(item.getDeliveryType());
            itemRow.createCell(5).setCellValue(item.getUom());
            itemRow.createCell(6).setCellValue(Integer.parseInt(item.getNumberInAnOrderUnit()));
            itemRow.createCell(7).setCellValue(Float.parseFloat(item.getPrice()));
            itemRow.createCell(8).setCellValue("");
            itemRow.createCell(9).setCellValue(Integer.parseInt(item.getMinOrderQty()));
            itemRow.createCell(10).setCellValue(Integer.parseInt(item.getQtyInterval()));
            itemRow.createCell(11).setCellValue(Integer.parseInt(item.getUnspsc()));
            itemRow.createCell(12).setCellValue(item.getStandardType());
            itemRow.createCell(13).setCellValue(item.getLongDescription());
            itemRow.createCell(14).setCellValue(item.getKeywords());
            itemRow.createCell(15).setCellValue(item.getManPartId());
            itemRow.createCell(16).setCellValue(item.getManName());
        }

        try (FileOutputStream outputStream = new FileOutputStream(temporaryFilePath + fileName)) {
            workbook.write(outputStream);
        }
    }
}
