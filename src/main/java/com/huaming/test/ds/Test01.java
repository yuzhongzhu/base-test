package com.huaming.test.ds;

import java.util.Arrays;

/**
 * 完成一个5阶乘 5!=1*2*3*4*5
 * 但如果是50!如何解决
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int n = 50;
		int []num = new int[100];
		num[num.length-1] = 1;
		for(int i =1 ;i<=n;i++){
			for(int j = 0;j<num.length;j++){
				num[j] = num[j]*i;
			}
			for(int k = num.length-1;k>=0;k--){
				String numStr = String.valueOf(num[k]);
				if(numStr.length()>1){
					String subNum = numStr.substring(0,numStr.length()-1);
					num[k] = Integer.valueOf(numStr.substring(numStr.length()-1));
					if(k-1<0){
						break;
					}
					num[k-1] = num[k-1]+Integer.valueOf(subNum);
				}
				
				
			}
		}
		String result = Arrays.toString(num).replaceAll(",", "");
		result = result.substring(1,result.length()-1);
		System.out.println(result);
	}
	
	
}
