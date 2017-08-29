package com.huaming.test.ds.sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int[] a){
		System.out.println("原始顺序："+Arrays.toString(a));
		for(int i = 1;i<a.length;i++){
			if(a[i]<a[i-1]){
				for(int j=i;j>=1;j--){
					if(a[j]<a[j-1]){
						int temp = a[j];
						a[j] = a[j-1];
						a[j-1] = temp;
					}else{
						
						break;
					}
				}
			}
			System.out.println(i+"次排序"+Arrays.toString(a));

		}
	}
}
