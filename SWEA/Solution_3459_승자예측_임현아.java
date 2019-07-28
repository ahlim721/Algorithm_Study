package com.ws;

import java.util.Scanner;

public class Solution_3459_승자예측_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			long num = sc.nextLong();

			while(num >= 2) {
				num -= 2;
				num /= 4;
			}
			
			String result = num == 1 ? "Bob" : "Alice";
			System.out.println("#" + t + " " + result);
		}
		
	}

}


class 선생님승자예측{
	
	public void code() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			long num = sc.nextLong();
			System.out.print("#" + t + " ");
			
			long a = 0;
			long b = 1;
			
			while(true) {
				a = (a * 2 + 1) * 2;
				if(num < a) {
					System.out.println("Bob");
					break;
				}
				b = (b * 2 + 1) * 2;
				if(num < b) {
					System.out.println("Alice");
					break;
				}
			}
		}
	}
	
}