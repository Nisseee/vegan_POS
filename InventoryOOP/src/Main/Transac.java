
package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Transac {
    Transac(String ID, String name, String category, String quantity, String price, String total, String profit) throws IOException {
        String pathDB = System.getProperty("user.dir") + "\\src\\DB\\StockOut.txt";
        File f = new File(pathDB);
        
        try {
            Scanner scan = new Scanner(f);
            ArrayList<String> items = new ArrayList<>();
                while(scan.hasNextLine()) {
                    items.add(scan.nextLine());
                }
            
            System.out.println( "newSiz"+ items.size());
             
            if(items.isEmpty()){
                try {
                    
                    FileWriter dataFile = new FileWriter(pathDB, true);
                    
                    String data = (ID+ "," +name+ "," +category+ "," +quantity+ "," +price+ "," +total+ "," +profit+"\n");
                    dataFile.append(data);
                    dataFile.close();
                    
                } catch (FileNotFoundException ex) {
                    
                }
            }else{
                
                    
                int u = 0;
                for(int i = 0; i < items.size(); i++) {
                    String data = items.get(i);
                    String[] split = data.split(",");
                    
                    if (split[1].equals(name)){
                        String  oldQ = split[3];
                        String  oldT = split[5];
                        String  oldP = split[6];
                        float newQ = Float.parseFloat(quantity) + Float.parseFloat(oldQ);
                        float newT = Float.parseFloat(total) + Float.parseFloat(oldT);
                        float newP = Float.parseFloat(profit) + Float.parseFloat(oldP);
                        String updatedItem = ID + "," + name + "," + category + "," + Float.toString(newQ) + "," + price + "," + Float.toString(newT)+ "," +Float.toString(newP);

                        items.set(i, updatedItem);
                    }else{
                        u++; 
                    }
                }
                if (u == items.size()){
                    String data = (ID+ "," +name+ "," +category+ "," +quantity+ "," +price+ "," +total+ "," +profit);
                    items.add(data);
                }
                try (FileWriter fw = new FileWriter(f);PrintWriter out = new PrintWriter(fw)){
                    
                    for(int i = 0; i < items.size(); i++) {
                        out.println(items.get(i));
                    }
                }
            }
        }catch(IOException ex) {
            // do nothing
        }
         
        
//         
        
    }
}
