package com.edu.shard.client;

import java.net.InetAddress;
import java.net.Socket;

import com.edu.storage.util.CFGReader;
import com.edu.storage.util.Download;
import com.edu.storage.util.JSONConfigReader;


/*
 * Class for that reads json file, connects to servers for file transfer, i.e., sharding
 */
public class Client {
	
	
	
	public static void main(String args[]) {
		try {
			JSONConfigReader jsonconfigreader = new JSONConfigReader();//creating json object to read parameters from json configfile.json
			CFGReader cfgReader = jsonconfigreader.readConfigFile();
			Socket[] sockArr = new Socket[cfgReader.getNumberOfServers()];//socket objects to connect to multiple server
			sockArr[0] = new Socket(
						InetAddress.getByName(cfgReader.getShard1IPAddress()),
						cfgReader.getShard1PortNumber());
			sockArr[1] = new Socket(
						InetAddress.getByName(cfgReader.getShard2IPAddress()),
						cfgReader.getShard2PortNumber());
			sockArr[2] = new Socket(
						InetAddress.getByName(cfgReader.getShard3IPAddress()),
						cfgReader.getShard3PortNumber());
			ShardingUtil shardUtil = new ShardingUtil();//Shardingutil class object to call shard to server method which splits to multiple methods
			shardUtil.shardToServers(sockArr, 
						cfgReader.getNumberOfServers(),
						cfgReader.getHomeDir() + cfgReader.getFileName(), "dat");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
