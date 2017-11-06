package com.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunningConcurrent implements  Runnable{
 
    @Override
    public void run() {
        System.out.println("Running ..start");
        try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        System.out.println("Running ..end");
    }
    
    
    public static void main(String[] args) throws Exception{
    	ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new RunningConcurrent());
        executorService.shutdown();
        while (!executorService.isTerminated()) {   }
        
        System.out.println("main ..end");
    }
}