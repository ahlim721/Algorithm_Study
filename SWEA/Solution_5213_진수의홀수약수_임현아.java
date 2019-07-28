package swexpert;

import java.util.Scanner;

public class Solution_5213_진수의홀수약수_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		long[] paper = new long[1000001];
		for(int i=1; i<1000001; i+=2) {
			for(int j=1; i*j<1000001; j++) {
				paper[i*j] += i;
			}
		}
		
		for(int i=1; i<1000001; i++) {
			paper[i] += paper[i-1];
		}
		
		for(int t=1; t<=tc; t++) {
			int l = sc.nextInt();
			int r = sc.nextInt();

			System.out.println("#" + t + " " + (paper[r] - paper[l-1]));
		}
		sc.close();
	}

}
