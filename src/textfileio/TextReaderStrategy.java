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
public interface TextReaderStrategy {

    public String getFilePath();

    public TextFileFormatStrategy getFromat();

    public List<Map<String, String>> readFile() throws IOException;

    public void setFilePath(String filePath);

    public void setFromat(TextFileFormatStrategy fromat);
    
}
