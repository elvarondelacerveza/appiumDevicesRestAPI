package com.example.democrud.util;


public class MobileInfo {

	public static boolean statusDeviceName(String name) {
		String resultado = "";
		ProcToString pts = new ProcToString("cmd.exe", "/C", "adb devices");
		boolean isConnected=false;
		try {
			pts.runProcess();
			if (pts.hasResult()) {
				resultado = pts.getResult();
				resultado = resultado.replace("List of devices attached", "");
				resultado = resultado.replace("\n", "");
				
				if (resultado.contains(name)) {
					isConnected = true;	
				}
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		return isConnected;
	}
		
}
