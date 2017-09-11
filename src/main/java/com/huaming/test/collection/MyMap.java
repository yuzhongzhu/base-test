package com.huaming.test.collection;

public interface MyMap<K,V> {
	public V get(K k);
	public void put(K k,V v);
	public interface Entry<K,V>{
		public K getKey();
		public V getValue();
	}
}
