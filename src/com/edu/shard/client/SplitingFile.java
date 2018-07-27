package com.edu.shard.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.edu.storage.util.CFGReader;
import com.edu.storage.util.JSONConfigReader;

/*
 * class containing method to split file into parts and send to server
 */
public class SplitingFile {
	  private String source;
      protected File sourceFile;
      protected FileInputStream input;
      protected int progress;
      protected int r;
      
     
      public SplitingFile(String source){
          try {
              this.source = source;
              sourceFile = new File(this.source);
              input = new FileInputStream(sourceFile);
          } catch (FileNotFoundException ex) {
              System.out.println("Source file not found, exit.");
          }
      }
      
      public void deleteFileParts(int n, String file, String extension){
		  JSONConfigReader jsonconfigreader = new JSONConfigReader();
		  CFGReader cfgReader = jsonconfigreader.readConfigFile();
    	  for(int i = 0; i<n; i++ ){
        	  File fileObj = new File(file  + "." + extension + "." + i);
        	  System.out.println(file  + "." + extension + "." + i);
        	  System.out.println("number of files :" + n);
        	  System.out.println("file deleted:"+ fileObj.delete());
          }
      }
      /*
       * method to split file into parts and send to server
       */
      public void splitFileIntoParts(String filePath, int n, String extension){
          int part = 0;
          int byteCopied = 0;
          
        System.out.println("extension*******"+ extension);
          
       	if ((extension.equals("dat") && part < n) || (extension.equals("part") && part < n-1)){
          
          try{
              FileOutputStream[] smallFileStream = new FileOutputStream[n];
              File[] smallFile = new File[n];
              
              for(int i = 0; i<n; i++ ){
      			  JSONConfigReader jsonconfigreader = new JSONConfigReader();
      			  CFGReader cfgReader = jsonconfigreader.readConfigFile();

            	  smallFile[i] = new File(filePath + "." + extension + "." + i);
            	  
                  smallFileStream[i] = new FileOutputStream(smallFile[i]);
                  System.out.println("part"+i+" created.");
              }
              
              File f = new File(filePath);
              //copy to split parts
              f.length();
       //       this.sourceFile.length();
              try{
                  while((r = input.read())!=-1){
                	  
                      if(smallFile[part].length()<(f.length()/3)){
                          smallFileStream[part].write((byte)r);
                          System.out.print("byteCopied "+byteCopied+ " ");
                          System.out.print("progress "+ progress+ " ");
                          System.out.println("part"+part+" ");
                          System.out.println(smallFile[part].length());
                          byteCopied++;
                          progress = (int)((byteCopied*100)/f.length());
                      }
                      else{
                          smallFileStream[part].write((byte)r);
                          part++;
                          byteCopied++;
                          progress = (int)((byteCopied*100)/f.length());
                          System.out.print("progress "+ progress+ " ");
                      }
                  }
                  progress = 100;
              }
              catch(IOException ex){
            	  System.out.println(extension);
                  ex.printStackTrace();
              }
              
              for(int i = 0; i<n; i++){
                  smallFileStream[i].close();
              }
          }
          catch(Exception ex){
        	  System.out.println(extension);
              ex.printStackTrace();
          }
        }
      }
}

