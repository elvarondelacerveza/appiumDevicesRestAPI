package com.example.democrud.commons;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll(){
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getDao();

}
//public List<T> getAll() throws FileNotFoundException, IOException {
//try (FileReader reader = new FileReader("C:/SeleniumGrid/devices-info.json")) {
//	List<T> returnList = new ArrayList<>();
//	// Read JSON file
//	Object obj = JsonParser.parseReader(reader);
//	JsonObject device = (JsonObject) obj;
//	JsonArray devices = device.get("devices").getAsJsonArray();
//
//	for (JsonElement dev : devices) {
//		Device deviceInfo = new Device(dev.getAsJsonObject().get("deviceName").getAsString(),
//				dev.getAsJsonObject().get("version").getAsString(),
//				dev.getAsJsonObject().get("maxInstances").getAsInt(),
//				dev.getAsJsonObject().get("platform").getAsString(),
//				dev.getAsJsonObject().get("appPackage").getAsString(),
//				dev.getAsJsonObject().get("appActivity").getAsString(),
//				dev.getAsJsonObject().get("browser").getAsString(), 
//				true
//		);
//		returnList.add((T) deviceInfo);
//
//	}
//
//	return returnList;
//}