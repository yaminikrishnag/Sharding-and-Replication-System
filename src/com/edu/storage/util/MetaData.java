package com.edu.storage.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
/*class metadata for updating metadata file in homedirectory.
 * */
public class MetaData {

	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
	MetaData metaData = new MetaData();
		metaData.writeToMetaDataFile("test");
	}


	/*write to metadata file to update details*/
	public void writeToMetaDataFile(String str) throws FileNotFoundException, IOException {
	FileWriter fileWriter;
	try {
		
		
		JSONConfigReader jsonconfigreader = new JSONConfigReader();
		CFGReader cfgReader = jsonconfigreader.readConfigFile();
		System.out.println(cfgReader.getMetadatafile());
		File newFile = new File(cfgReader.getMetadatafile());
		
	    fileWriter = new FileWriter(newFile,true);
	    BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
	    bufferFileWriter.append(str);
	    bufferFileWriter.newLine();
	    bufferFileWriter.close();
	} catch (IOException ex) {
	   // Logger.getLogger(JsonTest.class.getName()).log(Level.SEVERE, null, ex);
	}
}
//	 public static void main(String[] args){
//			MetaData metaData = new MetaData();
//			metaData.writeToMetaDataFile("Server1:");
//
//	 }
	
	
	
	
}
