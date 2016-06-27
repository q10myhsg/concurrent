package fc.itcast;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class FCHashMap {
	
	

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("1", "1");
		HashMap<String, String> chm1 = new HashMap<String, String>();
		chm1.put("1", "1");
		Hashtable<String, String> chm2= new Hashtable<String, String>();
		chm2.put("1", "1");

	}

}
