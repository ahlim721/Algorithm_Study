package com.hw;

import java.util.Scanner;

public class Solution_1263_사람네트워크2_임현아 {
	
	static final int M = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[][] gp = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i==j) gp[i][j] = sc.nextInt();
					else {
						gp[i][j] = sc.nextInt();
						if(gp[i][j] == 0) gp[i][j] = M;
					}
				}
			}
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					if(k == i) continue;
					for(int j=0; j<n; j++) {
						if(k == j || i == j) continue;
						gp[i][j] = gp[i][j] < gp[i][k]+gp[k][j] ? gp[i][j] : gp[i][k]+gp[k][j];
					}
				}
			}
			
			int min = M;
			for(int i=0; i<n; i++) {
				int sum=0;
				for(int j=0; j<n; j++) {
					sum+=gp[i][j];
				}
				min = min > sum ? sum : min;
			}
			
			System.out.println(min);
		}
	}

}
