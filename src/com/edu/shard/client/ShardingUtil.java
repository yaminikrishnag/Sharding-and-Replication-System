package com.edu.shard.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import com.edu.storage.util.CFGReader;
import com.edu.storage.util.JSONConfigReader;
/*
 * 
 */

public class ShardingUtil {

	public ShardingUtil() {
	}
/*method to shardToServer to split the file into required no of server */
	public void shardToServers(Socket[] sockArr, int shardToNumberOfServers, String filePathToShard, String extension) {
		try {
			JSONConfigReader jsonconfigreader = new JSONConfigReader();
			CFGReader cfgReader = jsonconfigreader.readConfigFile();//creating json object to read parameters from json configfile.json

			SplitingFile sp = new SplitingFile(filePathToShard);//SplitingFile class object to call splitFileIntoParts
			
			sp.splitFileIntoParts(filePathToShard, shardToNumberOfServers, extension);

			for (int i=0; i<shardToNumberOfServers;i++){
				dataTransfer(sockArr[i], filePathToShard + "." + extension + "." + i);
			}
			
			sp.deleteFileParts(shardToNumberOfServers, filePathToShard, extension);
			
		} catch (FileNotFoundException ex) {
			System.out.println("Source File Not Found.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
/*method to transfer the data to servers*/
	public static void dataTransfer(Socket sock, String fileLocation) throws IOException {
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		OutputStream outputStream = null;

		// creating connection between sender and receiver
		try {
			System.out.println("data transfer to server..." + fileLocation + sock.getInetAddress().getHostAddress() + ":" + sock.getPort());
			try {
				// creating object to send file
				File file = new File(fileLocation);
				byte[] byteArray = new byte[(int) file.length()];
				fileInputStream = new FileInputStream(file);
				bufferedInputStream = new BufferedInputStream(fileInputStream);

				bufferedInputStream.read(byteArray, 0, byteArray.length);
//				 // this instructions perform base64encoding before file is sent
				System.out.println("Ecoding file into Base64");
			     String bytesContent = DatatypeConverter.printBase64Binary(byteArray);
			     System.out.println("test"+bytesContent);
			      
				
				System.out.println("socket" + sock);
				// sending file through socket
				outputStream = sock.getOutputStream();
				System.out.println("Sending " + fileLocation + "( size: " + byteArray.length + " bytes)");
				
				outputStream.write(bytesContent.getBytes(), 0, bytesContent.length());
				outputStream.flush(); // flushing socket

				System.out.println("Done."); // file has been sent
			} finally {
				if (bufferedInputStream != null)
					bufferedInputStream.close();
				if (outputStream != null)
					outputStream.close();
				if (sock != null)
					sock.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}