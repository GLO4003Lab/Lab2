package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import java.util.HashMap;
import java.util.Map;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.exceptions.ComponentNotFoundException;

public class ServiceLocator {
	
	private static Map<Class<?>,Object> components = new HashMap<>();
	
	public static <T> void register(Class<T> typeClass, T object){
		if(!components.containsKey(typeClass))
			components.put(typeClass, object);
	}
	 
	@SuppressWarnings("unchecked")
	public static <T> T resolve(Class<T> typeClass){
		if(!components.containsKey(typeClass))
			throw new ComponentNotFoundException();
		return (T)components.get(typeClass);
	}

}
