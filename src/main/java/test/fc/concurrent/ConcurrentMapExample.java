package test.fc.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
	public static void main(String...strings){
		ConcurrentMap<String,String> cm = new ConcurrentHashMap<String,String>();
		cm.put("1", "1");
		Object o = cm.get("1");
		if(o!=null){
			System.out.println(o);
		}
	}
}
