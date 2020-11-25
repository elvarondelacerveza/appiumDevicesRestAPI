package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Device;


public interface DeviceDaoAPI extends CrudRepository<Device, Long> {

}
