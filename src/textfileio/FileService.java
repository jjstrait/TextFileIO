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
public class FileService {
    private TextReaderStrategy reader;
    private TextWriterStrategy writer;

    public FileService() {
    }

    public FileService(TextReaderStrategy reader, TextWriterStrategy writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    public TextReaderStrategy getReader() {
        return reader;
    }
    
    
    public void setReader(TextReaderStrategy reader) throws IllegalArgumentException {
        if(reader == null){
        throw new IllegalArgumentException("Reader is null");
        }
        this.reader = reader;
    }
    
     public List<Map<String,String>> readFile() throws IOException{
         return reader.readFile();
     }

    public TextWriterStrategy getWriter() {
        return writer;
    }

    public void setWriter(TextWriterStrategy writer) throws IllegalArgumentException{
        if(writer == null){
        throw new IllegalArgumentException("Writer is null");
        }
        this.writer = writer;
    }
     public void writeToFile(List<Map<String,String>> info, boolean isAppedable) throws IOException{
         writer.writeToFile(info, isAppedable);
     }
    
    
}
