package com.basic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		{
			List l;
			Set s;
			Queue q;
			Map m;

			Collections c;
			ArrayList al;
			Vector v;
		}

		{
			List<Object> l1 = new ArrayList<>();
			List<String> l2 = new ArrayList<>();
			
			//l1 =l2; invalid
			
			
			List<? extends Object> l3 = new ArrayList<>();
			List<String> l4 = new ArrayList<>();
			
			l3 =l4;
		}

		{

			Hashtable<Integer, String> ht = new Hashtable<>();
			ht.put(1, "Shyam");
			// ht.put(null, null);

			Set<Entry<Integer, String>> es = ht.entrySet();// iterator

			Enumeration<Integer> keys = ht.keys();// enumeration

			// keySet
			// entrySet

			// keys
		}

		{
			HashMap<Integer, String> hm = new HashMap<>();

			// keySet
			// entrySet

		}

		{
			Vector<String> v = new Vector<>();
			v.add("abc");

			Enumeration<String> ele = v.elements();

			// elements

			// v.iterator()
		}

		{
			Stack<String> st = new Stack<>();

		}
		

	}

	
}
