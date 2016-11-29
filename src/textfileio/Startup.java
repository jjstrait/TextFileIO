/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public class Startup {
    public static void main(String[] args) throws IOException {
        String filePath =  "src"+File.separatorChar+"Garage.txt";
    try{
    TextFileFormatStrategy format = new CustomGarageFormat();
    TextWriterStrategy writer = new TextFileWriter(format,filePath);
    TextReaderStrategy reader = new TextFileReader(format,filePath);
    
    FileService info = new FileService(reader,writer);
    
    
    
    
    List<Map<String,String>> garageData = new ArrayList<>();
    Map<String,String> record = new HashMap();
    record.put("totalHours", "65.3");
    record.put("totalFees", "55.2");
    garageData.add(record);
    info.writeToFile(garageData, false);
    System.out.println(info.readFile());
    }catch(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
        
    }
    
}
