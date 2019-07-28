package acmicpc;

import java.util.Scanner;

public class Main2775 {
	
	public static int[][] apart;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		apart = new int[15][15];
		for(int i=0; i<15; i++) {
			for(int j=1; j<15; j++) {
				if(i==0) apart[i][j] = j;
				else {
					apart[i][j] = apart[i-1][j] + apart[i][j-1];
				}
			}
		}
		int tc = sc.nextInt();
		for(int i=0; i<tc; i++) {
			System.out.println(apart[sc.nextInt()][sc.nextInt()]);
		}
	}
}
