package com.basic.thread;

import java.util.concurrent.BlockingQueue;

import com.basic.dto.Message;

public class BlockingQueueConsumer implements Runnable{

private BlockingQueue<Message> queue;
    
    public BlockingQueueConsumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            Thread.sleep(3000);
            while((msg = queue.take()).getMsg() !="exit"){
            	Thread.sleep(100);
            	System.out.println("Consumed "+msg.getMsg());
            }
            System.out.println("Consumer exit: "+msg.getMsg());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}