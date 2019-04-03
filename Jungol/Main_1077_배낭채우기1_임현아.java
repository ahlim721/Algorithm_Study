package ws;

import java.util.Scanner;

public class Main_1077_배낭채우기1_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] bag = new int[w+1];

		int[][] jam = new int[n][2]; // 0 : 무게 , 1 : 값어치
		for(int i=0; i<n; i++) {
			jam[i][0] = sc.nextInt();
			jam[i][1] = sc.nextInt();
			for(int j=1; jam[i][0]*j<w; j++) {
				bag[jam[i][0]*j] = bag[jam[i][0]*j] < jam[i][1]*j ? jam[i][1]*j : bag[jam[i][0]*j]; 
			}
		}
		
		for(int i=1; i<=w; i++) {
			for(int j=1; j<i/2; j++) {
				bag[i] = bag[i] < bag[j] + bag[i-j] ? bag[j] + bag[i-j] : bag[i];
			}
		}
		
		System.out.println(bag[w]);
		sc.close();
	}

}
