package swexpert;

import java.util.Scanner;

public class Solution_6485_삼성시의버스노선_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[][] bus = new int[n][2];
			int[] station = new int[5001];
			for(int i=0; i<n; i++) {
				bus[i][0] = sc.nextInt(); // 버스 출발
				bus[i][1] = sc.nextInt(); // 버스 도착
			}
			for(int i=0; i<n; i++) {
				for(int j=bus[i][0]; j<=bus[i][1]; j++) {
					station[j]++;
				}
			}
			int p = sc.nextInt();
			System.out.print("#" + t + " ");
			for(int i=0; i<p; i++) {
				System.out.print(station[sc.nextInt()] + " ");
			}
			System.out.println();
 		}
	}

}
