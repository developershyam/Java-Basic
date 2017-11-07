package com.basic.thread;

import java.util.concurrent.BlockingQueue;

import com.basic.dto.Message;

public class BlockingQueueProducer implements Runnable {

    private BlockingQueue<Message> queue;
    
    public BlockingQueueProducer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=1; i<=10; i++){
            Message msg = new Message(""+i);
            try {
            	Thread.sleep(100);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
            System.out.println("Produced exit: "+msg.getMsg());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
