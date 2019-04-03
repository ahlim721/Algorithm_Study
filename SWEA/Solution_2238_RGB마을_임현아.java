package hw;

import java.util.Scanner;

public class Solution_2238_RGB마을_임현아{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] rgb = new int[n][3];
		for(int i=0; i<n; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();
		}
		
		for(int i=1; i<n; i++) {
			rgb[i][0] += rgb[i-1][1] > rgb[i-1][2] ? rgb[i-1][2] : rgb[i-1][1];
			rgb[i][1] += rgb[i-1][0] > rgb[i-1][2] ? rgb[i-1][2] : rgb[i-1][0];
			rgb[i][2] += rgb[i-1][1] > rgb[i-1][0] ? rgb[i-1][0] : rgb[i-1][1];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			min = min > rgb[n-1][i] ? rgb[n-1][i] : min;
		}
		
		System.out.println(min);
	}

}
