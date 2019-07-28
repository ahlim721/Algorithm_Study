package com.ws;

import java.util.Scanner;

public class Solution_2007_패턴마디의길이_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			String s = sc.next();
			String w = s.charAt(0)+"";
			s = s.substring(1, s.length());
			while(s.length() >= w.length()) {
				if(!s.substring(0, w.length()).equals(w)) {
					w += s.charAt(0);
					s = s.substring(1,s.length());
				} else {
					break;
				}
			}
			System.out.println("#" + t + " " + w.length());
		}
	}	

}
