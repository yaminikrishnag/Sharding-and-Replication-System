package com.edu.storage.util;
/*class for downloading and integrating file
 * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class DownloadMerge {
	
	public static void main(String[] args){
		JSONConfigReader jsonconfigreader = new JSONConfigReader();
		CFGReader cfgReader = jsonconfigreader.readConfigFile();
		System.out.println(cfgReader.getDestDir1());
		System.out.println(cfgReader.getFileName());
		
		DownloadMerge downloadMerge = new DownloadMerge();
		downloadMerge.mergeFiles();
	}
	/*method to merge file*/
	 public void mergeFiles(){
			JSONConfigReader jsonconfigreader = new JSONConfigReader();
			CFGReader cfgReader = jsonconfigreader.readConfigFile();
			String sourceFile1Path = cfgReader.getDestDir1() + cfgReader.getFileName() + ".test1";
			String sourceFile2Path = cfgReader.getDestDir2() + cfgReader.getFileName() + ".test2";
			String sourceFile3Path =  cfgReader.getDestDir3() + cfgReader.getFileName() + ".test3";
			System.out.println(sourceFile1Path);
			System.out.println(sourceFile2Path);
			System.out.println(sourceFile3Path);
			String mergedFilePath = "\\test\\merged.txt";
	 
			File[] files = new File[3];
			files[0] = new File(sourceFile1Path);
			files[1] = new File(sourceFile2Path);
			files[2] = new File(sourceFile2Path);
			
			File mergedFile = new File(mergedFilePath);
	 
			mergeFiles(files, mergedFile);
			System.out.println("Merged:" + mergedFile.toString());
		
}

		public static void mergeFiles(File[] files, File mergedFile) {
	 
			FileWriter fstream = null;
			BufferedWriter out = null;
			try {
				fstream = new FileWriter(mergedFile, true);
				 out = new BufferedWriter(fstream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	 
			for (File f : files) {
				System.out.println("merging: " + f.getName());
				FileInputStream fis;
				try {
					fis = new FileInputStream(f);
					BufferedReader in = new BufferedReader(new InputStreamReader(fis));
	 
					String aLine;
					while ((aLine = in.readLine()) != null) {
						out.write(aLine);
						out.newLine();
					}
	 
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 
		
		}
}
