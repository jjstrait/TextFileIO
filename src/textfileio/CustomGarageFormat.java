/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public class CustomGarageFormat implements TextFileFormatStrategy{
    
    private final String TOTAL_HOURS_ID = "totalHours";
    private final String TOTAL_FEES_ID = "totalFees";
    
    public String encode(List<Map<String,String>> dataFromApp) throws IllegalArgumentException{
        String lineFeed = "\n";
        
        if(dataFromApp == null){
        throw new IllegalArgumentException("Map from app is null");
        }
        
        Map<String,String> sourceData = dataFromApp.get(0);
        String sTotalHours = sourceData.get(TOTAL_HOURS_ID);
        String sTotalFees = sourceData.get(TOTAL_FEES_ID);
        
        return sTotalHours + lineFeed+ sTotalFees +lineFeed;
    }
    
    
    public List<Map<String,String>> decode(List<String> dataFromFile) throws IllegalArgumentException{
        if(dataFromFile == null){
        throw new IllegalArgumentException("No lines from file read. list is null");
        }
        String sTotalHours = dataFromFile.get(0);
        String sTotalFees = dataFromFile.get(1);
        
        List<Map<String,String>> fileData = new ArrayList<>();
        Map<String,String> record = new HashMap();
        record.put(TOTAL_HOURS_ID, sTotalHours);
        record.put(TOTAL_FEES_ID, sTotalFees);
        
        fileData.add(record);
        
    return fileData;
    }
    public static void main(String[] args) {
        CustomGarageFormat format = new CustomGarageFormat();
        List<Map<String,String>>data = new ArrayList();
        Map<String,String> record = new HashMap<>();
        
    }
}
