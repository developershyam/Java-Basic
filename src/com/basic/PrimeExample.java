package com.basic;
//Prime number is a number that is greater than 1 and divided by 1 or itself.
//Note: 0 and 1 are not prime numbers. The 2 is the only even prime number because all the other even numbers can be divided by 2.
class PrimeExample {
	public static void main(String args[]) {
		int i, m = 0, flag = 0;
		int n = 17;// it is the number to be checked
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i == 0) {
				System.out.println("Number is not prime");
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println("Number is prime");
	}
}
