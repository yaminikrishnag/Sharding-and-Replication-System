/* class representing Server1ShardingServer which always waiting for client request */
package com.edu.shard.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.edu.storage.util.CFGReader;
import com.edu.storage.util.JSONConfigReader;
import com.edu.storage.util.MetaData;

public class Server2ShardingServer {

	private static Socket socket;

	public static void main(String[] args) {
		try {

			JSONConfigReader jsonconfigreader = new JSONConfigReader();// creating json object to read  parameters from json  configfile.json
			CFGReader cfgReader = jsonconfigreader.readConfigFile();
			int port = cfgReader.getShard2PortNumberShardingServer();
			ServerSocket serverSocket = new ServerSocket(port);// server socket object to listen to client project
			System.out.println("Server2 Started and listening to the port " + port);

			while (true) {
				System.out.println("Server2ShardingServer .........");
				socket = serverSocket.accept();// accepting client request
				InputStream is = socket.getInputStream();

				System.out.println("Server2ShardingServer...... before writing");
				
				String serverFilePathToWrite = cfgReader.getDestDir2() + cfgReader.getFileName() + ".test1." + "part." +"1";// reading path to store  the file  on server
				File newFile = new File(serverFilePathToWrite);
				System.out.println("path:" + newFile.getPath());
				FileOutputStream outputstream = new FileOutputStream(newFile);

				byte[] bytes = new byte[16 * 1024];
				int count;/* reading the bytes from client request */
				while ((count = is.read(bytes)) > 0) {
					outputstream.write(bytes, 0, count);
				}
				outputstream.flush();
				outputstream.close();//flushing bytes
				outputstream=null;
				is.close();
				is=null;
				System.gc();
				/*calling metadata file to create to store the updated results*/
				MetaData metaData = new MetaData();
				metaData.writeToMetaDataFile("Server2ShardingServer:" + new File(serverFilePathToWrite).getName() + ":" + newFile.length());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				socket=null;
			} catch (Exception e) {
			}
		}
	}
}
