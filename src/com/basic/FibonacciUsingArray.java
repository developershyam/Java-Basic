package com.basic;

public class FibonacciUsingArray {

	public static void main(String[] args) {
		
		int count=10;
		int fArr[] = new int[count];
		fArr[0]=0; fArr[1] =1;
		for(int i=2; i<count; i++){
			fArr[i] = fArr[i-1]+fArr[i-2];
		}
		
		for(int i=0; i<count; i++){
			System.out.print(" "+fArr[i]);
		}
		
		

	}

}
//output
//0 1 1 2 3 5 8 13 21 34
