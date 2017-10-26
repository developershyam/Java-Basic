package com.test;

public class ForLabeledExample {
	public static void main(String[] args) {
		
		aa: for (int i = 1; i <= 3; i++) {
			
			bb: for (int j = 1; j <= 3; j++) {
				
				if (i == 2 && j == 2) {
					break aa;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}

//output
//1 1
//1 2
//1 3
//2 1