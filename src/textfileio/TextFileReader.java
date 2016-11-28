/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public class TextFileReader implements TextReaderStrategy {
    private TextFileFormatStrategy format;
    private String filePath;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    public TextFileReader(TextFileFormatStrategy format, String filePath) {
        this.format = format;
        this.filePath = filePath;
    }
    
    
    @Override
    public List<Map<String,String>> readFile() throws IOException{
    File data = new File(filePath);
    BufferedReader in = null;
        List<String> lines = new ArrayList<>();
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  lines.add(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
                in.close(); 
     return format.decode(lines);
    }

    @Override
    public TextFileFormatStrategy getFromat() {
        return format;
    }

    @Override
    public void setFromat(TextFileFormatStrategy fromat) {
        if(format == null){
        throw new IllegalArgumentException("Format is null");
        }
        this.format = fromat;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        if(filePath == null || filePath.isEmpty()){
            throw new IllegalArgumentException("File path is empty");
        }
        this.filePath = filePath;
    }
    
    
    
}
