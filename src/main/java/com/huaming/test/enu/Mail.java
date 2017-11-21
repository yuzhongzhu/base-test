package com.huaming.test.enu;

import java.util.Iterator;

public class Mail {
	public static Iterable<Mail> generator(final int count){
		return new Iterable<Mail>() {
			int n = count;
			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					public boolean hasNext() {
						return n-- > 0;
					}

					public Mail next() {
						return new Mail();
					}
					
				};
			}
		};
	}
	public static void main(String[] args) {
		System.out.println(Mail.generator(10).iterator().hasNext());
	}
}
