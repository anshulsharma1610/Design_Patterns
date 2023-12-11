package com.example.generalstore;

import com.example.generalstore.Builder.ItemBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class FileUtil {
	private static final Logger LOGGER = Logger.getLogger(FileUtil.class.getName());
	
	 
public static List<String>  getFileData(String fileName) {
     File file = new File(fileName);
     if(!file.exists())
     {
         System.out.println(file.getAbsoluteFile());
         try {
             file.createNewFile();
         } catch (IOException ex) {
                 System.err.println("Error while creating file");
             Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
	 FileReader fr = null;
	 BufferedReader br = null;
	 List<String> data = new ArrayList<String>();
	 try {
		 fr = new FileReader(fileName);
		 br = new BufferedReader(fr);
		 while (br.ready()) {
			 String line = br.readLine();
			 data.add(line);
		 }
	 }
	 catch(Exception e) {
		 LOGGER.log(Level.SEVERE,"Exception while reading the file",e);
	 }
	 finally {
		 try {
			fr.close();
			br.close();
		} catch (IOException e) {
                    LOGGER.log(Level.SEVERE,"Exception while closing the file",e);
			e.printStackTrace();
		}
	 }
	 return data;
 }
 
 
 public static BufferedReader getFileReader(String filename) {
	 File f  = new File(filename);
	 if(!f.exists()) {
		 try {
		 f.createNewFile();
		 }
		 catch(Exception e) {
                         LOGGER.log(Level.SEVERE,"Exception while creating the file",e);
		 }
	 }
	  BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(filename));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  return br;
	  }
//    public static void writeToFile(String filename, ItemBuilder itemBuilder) {
//        try {
//            FileWriter fw = new FileWriter(filename, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter out = new PrintWriter(bw);
//            out.println(itemBuilder.getItemID());
//            out.println(itemBuilder.getItemName());
//            out.println(itemBuilder.getItemPrice());
//            out.println(itemBuilder.getItemCategory());
//            out.println(itemBuilder.getItemManufact());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void newFile(String filename) {
        try {
            // Delete existing file
            File existingFile = new File(filename);
            if (existingFile.exists()) {
                existingFile.delete();
            }

            // Create a new file
            existingFile.createNewFile();

            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println("Item Name,ItemCategory,ItemPrice, ItemManufacturer");

            out.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(String filename, ItemBuilder itemBuilder, boolean createHeader) {
        try {
            // Delete existing file
            File existingFile = new File(filename);
            if (existingFile.exists()) {
                existingFile.delete();
            }

            // Create a new file
            existingFile.createNewFile();

            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            // Check if headers need to be created
            if (createHeader) {
                out.println("ItemID,ItemName,ItemPrice,ItemCategory,ItemManufact");
            }

            out.println(itemBuilder.getItemID() + ","
                    + itemBuilder.getItemName() + ","
                    + itemBuilder.getItemPrice() + ","
                    + itemBuilder.getItemCategory() + ","
                    + itemBuilder.getItemManufact());

            out.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
 public static void appendEntryToFile(String fileName, ItemBuilder itemBuilder){
     FileWriter fr= null;
     BufferedWriter bw = null ;
     try {
          fr = new FileWriter(fileName,true);
          bw = new BufferedWriter(fr);
          bw.append(itemBuilder.getItemID()+",");
          bw.append(itemBuilder.getItemName()+",");
          bw.append(itemBuilder.getItemPrice()+",");
          bw.append(itemBuilder.getItemCategory()+",");
          bw.append(itemBuilder.getItemManufact()+"\n");
     } catch (IOException ex) {
         LOGGER.log(Level.SEVERE, "error while reading the file", ex);
     }
     finally{
        try {
            if(bw !=null){
                bw.close();
            }
            if(fr!= null){
                fr.close();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "erroe while closing the file", ex);
        }
     }
 }

    public static void createOrder(String fileName, List<ItemAPI> items){
        FileWriter fr= null;
        BufferedWriter bw = null ;
        try {
            fr = new FileWriter(fileName,true);
            bw = new BufferedWriter(fr);
            for (ItemAPI item : items) {
                // Customize the format based on your needs
//                bw.append(item.getItemID() + ",");
                bw.append(item.itemDescription() + ",");
                bw.append(item.getItemPrice() + ",");
//                bw.append(item.getItemCategory() + ",");
                bw.append(item.getItemManufact() + "\n");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "error while reading the file", ex);
        }
        finally{
            try {
                if(bw !=null){
                    bw.close();
                }
                if(fr!= null){
                    fr.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "erroe while closing the file", ex);
            }
        }
    }
 
    public static void removeEntryInFile(String fileName, String lineData)
    {
        FileReader fin = null;
        BufferedReader bin = null;
        FileWriter fout = null;
        BufferedWriter bout = null;

        String tempFileName = fileName + "temp";
        try {
            fin = new FileReader(fileName);
            bin = new BufferedReader(fin);
            fout = new FileWriter(tempFileName);
            bout = new BufferedWriter(fout);
            
            while(bin.ready()){
                String currentLine = bin.readLine();
                if(!currentLine.equals(lineData)){
                    bout.write(currentLine+"\n");
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "error while reading the file", ex);
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                }
                if (fin != null) {
                    fin.close();
                }
                if (bout != null) {
                    bout.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "erroe while closing the file", ex);
            }
        }
        new File(tempFileName).renameTo(new File(fileName));
    }
    
    public static void modifyEntryInFile(String fileName, String oldData, String newData)
    {
        FileReader fin = null;
        BufferedReader bin = null;
        FileWriter fout = null;
        BufferedWriter bout = null;

        String tempFileName = fileName + "temp";
        try {
            fin = new FileReader(fileName);
            bin = new BufferedReader(fin);
            fout = new FileWriter(tempFileName);
            bout = new BufferedWriter(fout);
            
            while(bin.ready()){
                String currentLine = bin.readLine();
                if(currentLine.equals(oldData)){
                    bout.write(newData+"\n");
                }
                else{
                    bout.write(currentLine+"\n");
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "error while reading the file", ex);
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                }
                if (fin != null) {
                    fin.close();
                }
                if (bout != null) {
                    bout.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "erroe while closing the file", ex);
            }
        }
        
        new File(tempFileName).renameTo(new File(fileName));
    }


    public static void createOrder(String fileName, List<ItemAPI> items, double discount, double shippingCost, double orderCost) {
        FileWriter fr= null;
        BufferedWriter bw = null ;
        try {
            fr = new FileWriter(fileName,true);
            bw = new BufferedWriter(fr);

            for (ItemAPI item : items) {
                // Customize the format based on your needs
                bw.append(item.itemDescription() + ",");
                bw.append(item.getItemPrice() + ",");
                bw.append(item.getItemManufact() + "\n");
            }

            // Write header for additional information
            bw.append("\n" + "Discount,").append("Shipping Cost,").append("Order Cost\n");

            // Write discount, shipping cost, and order cost
            bw.append(discount + ",").append(shippingCost + ",").append(orderCost + "\n");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "error while reading the file", ex);
        }
        finally{
            try {
                if(bw !=null){
                    bw.close();
                }
                if(fr!= null){
                    fr.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "erroe while closing the file", ex);
            }
        }
    }
}


