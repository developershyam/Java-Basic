package com.basic.dsa;

public class StackStaticImp {
	 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public StackStaticImp(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(int entry) throws Exception{
        if(this.isStackFull()){
            throw new Exception("Stack overflow...");
        }
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public long peek() {
        return stackArr[top];
    }
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
    
    /**
     * This method returns true if the stack is full
     * @return
     */
    public void printStack() {
        for(int i=0; i<=top;i++){
        	System.out.print(stackArr[i]+ (i<top?", ":""));
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        StackStaticImp stack = new StackStaticImp(5);
        for(int i=1;i<6;i++){
            try {
            	stack.push(i);
            	stack.printStack();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        for(int i=1;i<6;i++){
            try {
                stack.pop();
                stack.printStack();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}