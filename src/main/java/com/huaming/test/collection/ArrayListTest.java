package com.huaming.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(6);
		numList.add(3);
		numList.add(5);
		numList.add(7);
		numList.add(4);
		numList.add(2);
		List<Integer> subList = numList.subList(0, 4);
		System.out.println(Arrays.toString(subList.toArray()));
		System.out.println(Arrays.toString(numList.toArray()));
		Collections.sort(subList);
		System.out.println(Arrays.toString(subList.toArray()));
		System.out.println(Arrays.toString(numList.toArray()));
		Collections.shuffle(subList);
		System.out.println(Arrays.toString(subList.toArray()));
		System.out.println(Arrays.toString(numList.toArray()));
	}
}
