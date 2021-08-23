package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String fileName, String propertyName)  {

		if (System.getProperty(propertyName) != null)
			return System.getProperty(propertyName);
		
		else 
		{
			FileReader reader = null;
			try {
				reader = new FileReader(fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Properties p=new Properties();  
			try {
				p.load(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p.getProperty(propertyName);
		}
		
		
		

	}
	
	
	
	public static void setProperty(String fileName, String propertyName) {
		
	}

}
