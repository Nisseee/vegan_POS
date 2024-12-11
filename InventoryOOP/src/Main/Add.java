
package Main;

import java.io.*;

public class Add {
    Add(String ID, String name, String category, String capital, String stocks, String sales) throws IOException {
        try {
                String pathDB = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt"; 
                FileWriter dataFile = new FileWriter(pathDB, true);
                
                String data = (ID+ "," +name+ "," +category+ "," +capital+ "," +stocks+ "," +sales+ "," +"0\n");
                dataFile.append(data);
                dataFile.close();



            } catch (FileNotFoundException ex) {
                
            } 
        
    }
}
