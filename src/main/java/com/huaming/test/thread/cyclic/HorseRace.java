package com.huaming.test.thread.cyclic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
	public static final int FINISH_LINE = 25;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService execService = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRace(int nHorse,final int pause){
		barrier = new CyclicBarrier(nHorse, new Runnable(){
			public void run() {
				StringBuilder s = new StringBuilder();
				for(int i = 0;i<FINISH_LINE;i++){
					s.append("=");
				}
				System.out.println(s.toString());
				for(Horse horse:horses){
					System.out.println(horse.tracks());
				}
				for(Horse horse:horses){
					if(horse.getStrides()>=FINISH_LINE){
						System.out.println(horse +"won the race");
						execService.shutdownNow();
						return;
					}
				}
				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		for(int i = 0 ;i<nHorse;i++){
			Horse horse = new Horse(barrier);
			horses.add(horse);
			execService.execute(horse);
		}
		
	
	}
	
	public static void main(String[] args) {
		int nHorse = 7;
		int pause = 200;
		new HorseRace(nHorse,pause);
	}
}
