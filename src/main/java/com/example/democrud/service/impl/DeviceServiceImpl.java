package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.DeviceDaoAPI;
//import com.example.democrud.dao.api.PersonaDaoAPI;
import com.example.democrud.model.Device;
//import com.example.democrud.model.Persona;
import com.example.democrud.service.api.DeviceServiceAPI;

@Service
public class DeviceServiceImpl extends GenericServiceImpl<Device, Long> implements DeviceServiceAPI {

	@Autowired
	private DeviceDaoAPI deviceDaoAPI;
	
	@Override
	public CrudRepository<Device, Long> getDao() {
		return deviceDaoAPI;
	}

}
