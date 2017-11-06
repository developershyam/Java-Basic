package com.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableConcurrent  implements Callable<Integer>{
 
	int number;
	 
	@Override
    public Integer call() throws Exception {
    	System.out.println("Callable ..start");
        int fact = 1;
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        System.out.println("Callable ..end");
        return fact;
    }
    
    
    public static void main(String[] args) throws Exception{
    	ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new CallableConcurrent());
        executorService.shutdown();
        
        //while(!future.isDone()){};
        future.get();
        
        System.out.println("main ..end");
    }
}