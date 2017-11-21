package com.huaming.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		int n = 2;
		while(n>0){
			for(int i = 0 ; i<10;i++){
				exec.execute(new LiftOff());
			}
			n--;
			try {
				exec.awaitTermination(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(exec.isTerminated());
			System.out.println(exec.isShutdown());
		}
		
		
	}
}
