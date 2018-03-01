package com.wpy.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContructionTest {
	public static void test1() {

		String name = "ss";
		System.out.println(name);

		StringBuffer stringOne = new StringBuffer();
		stringOne.append("wpy");
		stringOne.append("sss");

		String stringTwo = "wpysss";
		if(stringOne.toString() == (stringTwo)) {
			System.out.println("ok");
		}

		String stringThree = "wpyss"+"s";
		if(stringTwo.equals(stringThree)) {
			System.out.println("ok2");
		}

		List list = new ArrayList();
		list.add(null);

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("w");
		linkedList.add("p");
		linkedList.add("y");
		System.out.println(linkedList.size());

		linkedList.remove(1);
		for (String string : linkedList) {

			System.out.println(string);
		}
	}

	
	


	public static void test2() {
		Set set = new HashSet<>();
		String name = "s";
		String name1 = new String("s");
		if (name == name1) {
			System.out.println("equals");
		}
		
		System.out.println(name.hashCode()+"--"+name1.hashCode());
		set.add(null);
		set.add(name);
		set.add(name1);
		
		System.out.println(set.size());
		
	}

	
	public static void test3() {
		Map map = new Hashtable<>();
		map.put(null, null);
		map.put("", null);
		System.out.println(map.size());
	}
	public static void main(String[] args) {
			test3();
	}
}
