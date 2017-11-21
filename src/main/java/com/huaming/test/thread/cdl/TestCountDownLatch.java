package com.huaming.test.thread.cdl;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch implements Runnable{
	public static CountDownLatch countDownLatch = new CountDownLatch(4);
    public int thread;
    public TestCountDownLatch(int thread){
    	this.thread = thread;
    }
	public void run() {
		
		if(thread==2){
			System.out.println(thread+"开始等待");
			try {
				countDownLatch.await();
				System.out.println(thread+"结束等待");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(thread);
		countDownLatch.countDown();
		
	}
	public static void main(String[] args) {
		for(int i = 0 ;i<5;i++){
			new Thread(new TestCountDownLatch(i)).start();
			
		}
	}

}
