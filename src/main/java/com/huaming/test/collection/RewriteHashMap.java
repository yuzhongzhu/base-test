package com.huaming.test.collection;

public class RewriteHashMap<K,V> implements MyMap<K, V> {
	private static int defaultLength = 1<<4;
	private static double defaultLdf = 0.75;
	private int useSize;
	private Entry<K,V> table[];

	public V get(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	public void put(K k, V v) {
		// TODO Auto-generated method stub
		
	}
	
	class Entry<K,V> implements MyMap.Entry<K, V>{
		K k;
		V v;
		Entry<K, V> next;
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
