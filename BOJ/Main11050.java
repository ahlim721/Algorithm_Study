package acmicpc;

import java.util.Scanner;

public class Main11050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 1;
		int tmp = k;
		
		for(int i=0; i<tmp; i++) {
			result*=n--;
		}
		for(int i=0; i<tmp; i++) {
			result/=k--;
		}
		
		System.out.println(result);
	}

}
