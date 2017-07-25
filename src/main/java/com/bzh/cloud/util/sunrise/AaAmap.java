package com.bzh.cloud.util.sunrise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AaAmap<K,V> extends HashMap<String, V>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public AaAmap
	(Map<String, V> map){
		for(Iterator<Entry<String, V>> it=map.entrySet().iterator();it.hasNext();){
			Entry<String, V> en=it.next();
			this.put( Underline2Camel.underline2Camel(en.getKey(), true),en.getValue());
		}
	}

}
