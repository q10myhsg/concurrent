package test.fc.concurrent;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/**
 * java.util.concurrent.ConcurrentNavigableMap 是一个支持并发访问的 java.util.NavigableMap，它还能让它的子 map 具备并发访问的能力。所谓的 "子 map" 
 * 指的是诸如 headMap()，subMap()，tailMap() 之类的方法返回的 map。
 * 
 * NavigableMap本质是一个根据key排序的map,方便快速排序，检索
 *
subMap() 方法返回原始 map 中，键介于 from(包含) 和 to (不包含) 之间的子 map。示例如下：
 * */
public class ConcurrentNavigableMapExample {

	public static void main(String... strings) {
		ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("5", "3");
		
		
//		System.out.println(map.floorKey("3"));
		
		System.out.println(map.headMap("2"));
		System.out.println(map.tailMap("2"));
	}

	// map.subMap("a",true);

}
