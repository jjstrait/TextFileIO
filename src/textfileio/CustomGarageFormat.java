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
    
    public String encode(List<Map<String,String>> dataFromApp){
        Map<String,String> sourceData = dataFromApp.get(0);
        String sTotalHours = sourceData.get("totalHours");
        String sTotalFees = sourceData.get("totalFees");
        
        return sTotalHours + "\n"+ sTotalFees +"\n";
    }
    public List<Map<String,String>> decode(List<String> dataFromFile){
        String sTotalHours = dataFromFile.get(0);
        String sTotalFees = dataFromFile.get(1);
        
        List<Map<String,String>> fileData = new ArrayList<>();
        Map<String,String> record = new HashMap();
        record.put("totalHours", sTotalHours);
        record.put("totalFees", sTotalFees);
        
        fileData.add(record);
        
    return fileData;
    }
    public static void main(String[] args) {
        CustomGarageFormat format = new CustomGarageFormat();
        List<Map<String,String>>data = new ArrayList();
        Map<String,String> record = new HashMap<>();
        
    }
}
