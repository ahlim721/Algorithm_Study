package acmicpc;

import java.util.Scanner;

public class Main1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = Integer.toBinaryString(n);
		
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '1') cnt++;
		}
		
		System.out.println(cnt);
	}
}
