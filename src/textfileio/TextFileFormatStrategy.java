/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public interface TextFileFormatStrategy {
    public String encode(List<Map<String,String>> dataFromApp);
    public List<Map<String,String>> decode(List<String> dataFromFile);
    
    
}
