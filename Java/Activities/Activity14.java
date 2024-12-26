package hello;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
           	File file = new File("src/main/File.txt");
        	File newFile = new File("src/main/newFile.txt");
        	
        	boolean fStatus = file.createNewFile();        	
            if(fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            
            boolean fStatusNew = newFile.createNewFile();        	
            if(fStatusNew) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            
            //get the file Object
            String fileUtil = FileUtils.getFile("src/main/File.txt");
            //Read file
            System.out.println("Data in file: " + fileUtil);
      
            
            //Create directory
            File destDir = new File("src/main/newDir");
        
            boolean bool = destDir.mkdir(); 
            if(bool){  
               System.out.println("Folder is created successfully");  
            }else{  
               System.out.println("Error Found!");  
            }
            
            //Read data from newFile.txt
            String fileNewUtil = FileUtils.readFileToString(newFile, "content on newFile.txt");
            System.out.println("Data in new file: " + fileNewUtil);
            
            //Copy file to directory
            FileUtils.copyFileToDirectory(newFile, destDir);
                  
            //Get file from new directory
            String newDirFile = FileUtils.getFile(destDir, "newFile.txt");
            System.out.println("new path of new file created: " + newDirFile);
           
        } catch(IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}