package com.edu.storage.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.Instant;
 
import static java.lang.System.out;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

public class FileMetadataExample {
	private String Path;
    protected File PathFile;
    protected FileInputStream input;

	//public static void main(String[] args) throws IOException {
		
//        Path MetaClient1 = Paths.get("C:/Users/bmk/SourceStorageLocation");//Reading the client file
//        Path MetaServer1 = Paths.get("C:/Users/bmk/ShardStorageServer1");// Reading the server1 file
//        Path MetaServer2 = Paths.get("C:/Users/bmk/ShardStorageServer2");// Reading the server 2 file
//        Path MetaServer3 = Paths.get("C:/Users/bmk/ShardStorageServer3");// Reading the server3  file     
  
//        getAttributesOneByOne(MetaServer1);
//       
//        
//        getAttributesOneByOne(MetaServer2);
//      
//        
//        getAttributesOneByOne(MetaServer3);
    //}
 
   
 
    public void getAttributesOneByOne(Path file)
            throws IOException {
        out.printf("%nMetadata of '%s':%n", file.toString());
      
    
        out.println("size     : " + Files.size(file));
        
        out.println("owner    : " + Files.getOwner(file).getName());
        out.println("modification time: "
                + Files.getLastModifiedTime(file));
    
    }

   
}


