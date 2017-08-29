package com.huaming.test.ds.sort;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args) {
		int []a = {4,3,6,5,1,2,7,9};
		InsertSort.insertSort(a);
		System.out.println("最终："+Arrays.toString(a));
	}
}
