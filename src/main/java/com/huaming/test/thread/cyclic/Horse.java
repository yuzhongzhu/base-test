package com.huaming.test.thread.cyclic;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	private static CyclicBarrier barrier;
	
	public synchronized int getStrides(){
		return strides;
	}
	public Horse(CyclicBarrier barrier){
		Horse.barrier = barrier;
	}
	
	public String toString(){
		return "Horse "+ id +" ";
	}
	
	public String tracks(){
		StringBuilder s = new StringBuilder();
		for(int i =0; i<getStrides();i++){
			s.append("*");
		}
		s.append(id);
		return s.toString();
	}
	public void run() {
		System.out.println(id);
		try {
			while(!Thread.interrupted()){
				synchronized(this){
					strides += rand.nextInt(3);
				}
				barrier.await();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
