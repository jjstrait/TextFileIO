/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jstra
 */
public class TextFileWriter implements TextWriterStrategy {
     private TextFileFormatStrategy format;
    private String filePath;

    public TextFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public TextFileWriter(TextFileFormatStrategy format, String filePath) {
        this.format = format;
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(List<Map<String,String>> info, boolean isAppedable) throws IOException{
    File data = new File(filePath);
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(data, isAppedable)));
	  out.print(format.encode(info));
	  out.close();  // be sure you close your streams when done!!
	
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
