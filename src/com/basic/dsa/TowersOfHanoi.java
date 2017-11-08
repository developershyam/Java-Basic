package com.basic.dsa;

import java.util.Stack;

public class TowersOfHanoi {

	public void doTOH(int n, String source, String auxiliary, String destination, boolean showInfo) {
		   if(showInfo) {
			   showInfo=false;
			   System.out.println("source: "+source+", destination: "+destination+", auxiliary: "+auxiliary);
		   }
	       if (n == 1) {
	           System.out.println("Disc:"+n+"  --  "+source + " -> " + destination);
	       } else {
	    	   doTOH(n - 1, source, destination, auxiliary, showInfo);
	           System.out.println("Disc:"+n+"  --  "+source + " -> " + destination);
	           doTOH(n - 1, auxiliary, source, destination, showInfo);
	       }
	   }

	   public static void main(String[] args) {
	       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
	       int discs = 3;
	       towersOfHanoi.doTOH(discs, "P1", "P2", "P3", true);
	       towersOfHanoi.doTOH();
	   }
	   
	   public  void doTOH() {
		   Stack<Integer> source = new Stack<>();
		   Stack<Integer> dest = new Stack<>();
		   Stack<Integer> aux = new Stack<>();
		   int disc =2;
		   for (int i = 1; i <= disc ; i++) {
			   source.push(i);
		   }
		   System.out.println(source);
		   while(dest.size()< disc) {
			   
			   if(disc%2==0) {
				   aux.push(source.pop());
				   dest.push(source.pop());
			   }else {
				   dest.push(source.pop());
				   aux.push(source.pop());
			   }
			   dest.push(aux.pop());
		   }
		   System.out.println(dest);
		   

	}
}
