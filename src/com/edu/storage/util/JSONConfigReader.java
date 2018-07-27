package com.edu.storage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JSONConfigReader {

	public CFGReader readConfigFile() {
		CFGReader cfgReader = null;
		try {
			File jsonInputFile = new File("C:/valueit/projectsus/ShardStorageProject/src/com/edu/storage/util/configfile.json");
		
			
			
			InputStream is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);
			JsonObject Obj = reader.readObject();
			reader.close();

			String homedir = Obj.getString("homedir");
			String destdir1 = Obj.getString("destdir1");
			String destdir2= Obj.getString("destdir2");
			String destdir3 = Obj.getString("destdir3");
			String shard1ipaddress = Obj.getString("shard1ipaddress");
			String shard2ipaddress = Obj.getString("shard1ipaddress");
			String shard3ipaddress = Obj.getString("shard1ipaddress");
			String shard1ipaddressshardingserver = Obj.getString("shard1ipaddressshardingserver");
			String shard2ipaddressshardingserver = Obj.getString("shard1ipaddressshardingserver");
			String shard3ipaddressshardingserver = Obj.getString("shard1ipaddressshardingserver");
			int portnumber1 = Obj.getInt("shard1portnumber");
			int portnumber2 = Obj.getInt("shard2portnumber");
			int portnumber3 = Obj.getInt("shard3portnumber");
			int portnumber1shardingserver = Obj.getInt("shard1portnumbershardingserver");
			int portnumber2shardingserver = Obj.getInt("shard2portnumbershardingserver");
			int portnumber3shardingserver = Obj.getInt("shard3portnumbershardingserver");
			String fileName = Obj.getString("fileName");
			int numberofservers = Obj.getInt("numberofservers");
			String metadatafile= Obj.getString("metadatafile");
			
			cfgReader = new CFGReader(homedir, destdir1,destdir2,destdir3, shard1ipaddress, shard2ipaddress, shard3ipaddress,portnumber1,portnumber2,portnumber3,fileName,numberofservers,metadatafile,
					shard1ipaddressshardingserver, shard2ipaddressshardingserver, shard3ipaddressshardingserver,
					portnumber1shardingserver, portnumber2shardingserver, portnumber3shardingserver
					);

			System.out.println(cfgReader.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cfgReader;

	}
	
	 public static void main(String[] args){
	 JSONConfigReader r = new JSONConfigReader();
	 r.readConfigFile();
	 }

}
