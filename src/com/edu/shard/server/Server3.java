package com.edu.shard.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.edu.shard.client.ShardingUtil;
import com.edu.storage.util.CFGReader;
import com.edu.storage.util.JSONConfigReader;
import com.edu.storage.util.MetaData;
/* class representing server 3 which always waiting for client request */

public class Server3 {

	private static Socket socket;
	public static void main(String[] args) {
		String serverFilePathToWrite = "";
		String shardFileExtension = ".test3";
		try {

			JSONConfigReader jsonconfigreader = new JSONConfigReader();
			CFGReader cfgReader = jsonconfigreader.readConfigFile();// creating json object to read  parameters from json  configfile.json
			int port = cfgReader.getShard3PortNumber();
			ServerSocket serverSocket = new ServerSocket(port);// server socket object to listen to client project
			System.out.println("Server3 Started and listening to the port " + port);
			serverFilePathToWrite = cfgReader.getDestDir3() + cfgReader.getFileName()+shardFileExtension;// reading path to store  the file  on server
			while (true) {
				System.out.println("Server3 .........");
				socket = serverSocket.accept();// accepting client request
				InputStream is = socket.getInputStream();

				System.out.println("before writing");
				File newFile = new File(serverFilePathToWrite);
				System.out.println("path:" + newFile.getPath());
				FileOutputStream outputstream = new FileOutputStream(newFile);

				byte[] bytes = new byte[16 * 1024];
				int count;/* reading the bytes from client request */
				while ((count = is.read(bytes)) > 0) {
					outputstream.write(bytes, 0, count);
				}
				outputstream.close();
				outputstream.flush();
				outputstream = null;
				is.close();
				is= null;
				
				try {
					socket.close();
					socket=null;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
//				// shard to remaining servers
//				System.out.println("sharding the file to other servers file name is :"+serverFilePathToWrite);
//				shardToOtherServers(serverFilePathToWrite);

				MetaData metaData = new MetaData();
				metaData.writeToMetaDataFile("Server3:" + new File(serverFilePathToWrite).getName() + ":" + newFile.length());
				
				/*calling metadata file to create to store the updated results*/	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	private static void shardToOtherServers(String serverFilePathToWrite) {
		JSONConfigReader jsonconfigreader = new JSONConfigReader();
		CFGReader cfgReader = jsonconfigreader.readConfigFile();
		Socket[] socketArr = new Socket[cfgReader.getNumberOfServers()-1];
		
		try {
				socketArr[0] = new Socket(InetAddress.getByName(cfgReader.getShard1IPAddressShardingServer()), cfgReader.getShard1PortNumberShardingServer());
				socketArr[1] = new Socket(InetAddress.getByName(cfgReader.getShard2IPAddressShardingServer()), cfgReader.getShard2PortNumberShardingServer());
		
			// read the file split multiple, copy to other two servers
			ShardingUtil shardUtil = new ShardingUtil();
			shardUtil.shardToServers(socketArr, socketArr.length, serverFilePathToWrite, "part");
			
			for(int i = 0; i<socketArr.length; i++){
					socketArr[i].close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
