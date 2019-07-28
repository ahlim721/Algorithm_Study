package com.hw;

import java.util.Scanner;

public class Solution_1213_String_ÀÓÇö¾Æ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=0; t<10; t++) {
			int tc = sc.nextInt();
			String word = sc.next();
			String str = sc.next();
			
			int cnt = 0;
			for(int i=0; i<str.length()-word.length()+1; i++) {
				if(word.equals(str.substring(i, i+word.length()))) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
