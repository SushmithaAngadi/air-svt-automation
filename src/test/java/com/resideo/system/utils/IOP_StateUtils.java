package com.resideo.system.utils;

public class IOP_StateUtils {
		private static IOP_StateUtils instance = null;


		public static IOP_StateUtils getInstance() {
			if (instance == null)
				instance = new IOP_StateUtils();
			return instance;
		}
		
		private String ipAddress = null;
		
		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}
		
		public String getIPAddress() {
			return this.ipAddress;
		}

}
