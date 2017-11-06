package com.basic;
//A palindrome number is a number that is same after reverse.
public class PalindromeNumber {
	public static void main(String args[]) {
		int r, sum = 0, temp;
		int n = 545;// It is the number variable to be checked for palindrome

		temp = n;
		while (n > 0) {
			r = n % 10; // getting remainder
			sum = (sum * 10) + r;
			n = n / 10;
		}
		if (temp == sum)
			System.out.println("palindrome number ");
		else
			System.out.println("not palindrome");
	}
}

//Get the number to check for palindrome
//Hold the number in temporary variable
//Reverse the number
//Compare the temporary number with reversed number
//If both numbers are same, print "palindrome number"
//Else print "not palindrome number"
