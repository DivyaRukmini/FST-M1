package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {

	public static String readFileToString(File fileUtil, String string) {
		String newData = string + " is added from method";
		//return data from the file newFile.txt
		return newData;
		
	}

	public static String getFile(File destDir, String string) {
		destDir.toString();
		String newPath = destDir + "\\" + string;
		return newPath;
	}

	public static void copyFileToDirectory(File file, File destDir) {
		Path source = file.toPath(); 
        Path destination = destDir.toPath();   
		try {  
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);  
            System.out.println("File copied successfully using traditional I/O.");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		
	}

	public static String getFile(String str) throws IOException {
		Path file = Path.of(str);
		String dataOfFile = Files.readString(file);
		return dataOfFile;
	}

}
