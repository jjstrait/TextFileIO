/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public interface TextWriterStrategy {

    String getFilePath();

    TextFileFormatStrategy getFromat();

    void setFilePath(String filePath);

    void setFromat(TextFileFormatStrategy fromat);

    public void writeToFile(List<Map<String,String>> info, boolean isAppedable) throws IOException;
    
}
