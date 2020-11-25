package com.example.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String devicename;
	@Column
	private String os;
	@Column
	private String osversion;
	@Column
	private String apppackage;

	@Column
	private String appactivity;

	@Column
	private String browser;

	@Column
	private String ip;
	@Column
	private String port;
	@Column
	private String apklocation;

	@Column
	private Integer maxinstances;

	@Column
	private boolean isconnected;

	public Device() {

	}

	

	public Device(String devicename, String os, String osversion, String apppackage, String appactivity, String browser,
			String ip, String port, String apklocation, Integer maxinstances, boolean isconnected) {
		super();
		this.devicename = devicename;
		this.os = os;
		this.osversion = osversion;
		this.apppackage = apppackage;
		this.appactivity = appactivity;
		this.browser = browser;
		this.ip = ip;
		this.port = port;
		this.apklocation = apklocation;
		this.maxinstances = maxinstances;
		this.isconnected = isconnected;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}



	public String getOsversion() {
		return osversion;
	}



	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getPort() {
		return port;
	}



	public void setPort(String port) {
		this.port = port;
	}



	public String getApklocation() {
		return apklocation;
	}



	public void setApklocation(String apklocation) {
		this.apklocation = apklocation;
	}



	public boolean isconnected() {
		return isconnected;
	}

	public void setConnected(boolean isConnected) {
		this.isconnected = isConnected;
	}

	public String getDeviceName() {
		return devicename;
	}

	public void setDeviceName(String deviceName) {
		this.devicename = deviceName;
	}



	public Integer getMaxInstances() {
		return maxinstances;
	}

	public void setMaxInstances(Integer maxInstances) {
		this.maxinstances = maxInstances;
	}


	public String getAppPackage() {
		return apppackage;
	}

	public void setAppPackage(String appPackage) {
		this.apppackage = appPackage;
	}

	public String getAppActivy() {
		return appactivity;
	}

	public void setAppActivy(String appActivity) {
		this.appactivity = appActivity;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

}
