package com.huaming.test.ds.sort;

import java.util.Arrays;
/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * */
public class BubbleSort {
	public static void bubbleSort(int[] a) {
		for(int k= 0 ;k<a.length;k++){
			for(int i= 1 ;i<a.length-k;i++){
				int temp = a[i]; 
				if(a[i-1]>a[i]){
					a[i] = a[i-1];
					a[i-1] =temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		int []a = {6,1,3,4,7,2,8,0,9,5};
		bubbleSort(a);
 }
}
