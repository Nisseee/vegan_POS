
package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Edit {
    Edit(String id, String name, String categ, String cap, String quan,String price,String damage, int row) {
        
        String pathDB = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt";
        File f = new File(pathDB);
        try {
            Scanner scan = new Scanner(f);
            ArrayList<String> items = new ArrayList<>();
            
            while(scan.hasNextLine()) {
                items.add(scan.nextLine());
            }
            String updatedItem = id + "," + name + "," + categ + "," + cap + "," + quan + "," + price+ "," +damage;
            
            items.set(row, updatedItem);
            try (FileWriter fw = new FileWriter(f);PrintWriter out = new PrintWriter(fw)){
                for(int i = 0; i < items.size(); i++) {
                out.println(items.get(i));
                }
            }
        } catch(Exception ex) {
            // do nothing
        }
    }
}
