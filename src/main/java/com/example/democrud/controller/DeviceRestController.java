package com.example.democrud.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrud.model.Device;
//import com.example.democrud.model.Persona;
import com.example.democrud.service.api.DeviceServiceAPI;
import com.example.democrud.util.MobileInfo;


@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class DeviceRestController {

	@Autowired
	private DeviceServiceAPI deviceServiceAPI;

	@GetMapping(value = "/all")
	public List<Device> getAll() throws FileNotFoundException, IOException {
		return deviceServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Device find(@PathVariable Long id) {
		return deviceServiceAPI.get(id);
	}
	@GetMapping(value = "/validate/{id}")
	public boolean validate(@PathVariable Long id) {
		return MobileInfo.statusDeviceName(deviceServiceAPI.get(id).getDeviceName());
	}

	@PostMapping(value = "/save")
//	public ResponseEntity<Device> save(@RequestBody Device dev) {
	public ResponseEntity<Device> save(@RequestBody Device dev) {
		// Mandar los parametros del requestBody en su lugar se debera de llenar y mandarle esos valores de manera dinamica 
		
		Device obj = deviceServiceAPI.save(dev);
		return new ResponseEntity<Device>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Device> delete(@PathVariable Long id) {
		Device dev = deviceServiceAPI.get(id);
		if (dev != null) {
			deviceServiceAPI.delete(id);
		}else {
			return new ResponseEntity<Device>(dev, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Device>(dev, HttpStatus.OK);
	}
	
	//Get Device Valide si el Dispositivo Existe
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Device> update(@PathVariable Long id, @RequestBody Device dev){
		Device toUpdate = deviceServiceAPI.get(id);
		if (toUpdate != null) {
			toUpdate.setDeviceName(dev.getDeviceName());
			toUpdate.setOs(dev.getOs());
			toUpdate.setOsversion(dev.getOsversion());
			toUpdate.setAppPackage(dev.getAppPackage());
			toUpdate.setAppActivy(dev.getAppActivy());
			toUpdate.setBrowser(dev.getBrowser());
			toUpdate.setIp(dev.getIp());
			toUpdate.setPort(dev.getPort());	
			toUpdate.setApklocation(dev.getApklocation());				
			toUpdate.setMaxInstances(dev.getMaxInstances());
			toUpdate.setConnected(dev.isconnected());
			
			Device obj = deviceServiceAPI.save(toUpdate);
			return new ResponseEntity<Device>(obj, HttpStatus.OK);
		}else {
			return new ResponseEntity<Device>(deviceServiceAPI.get(id), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
