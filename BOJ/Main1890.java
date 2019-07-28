package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main1890 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) { 
				map[i][j] = sc.nextInt();
			}
		}
		
		long[][] visit = new long[n][n];
		
		visit[n-1][n-1] = 1;
		long result = dps(map, visit, 0, 0);
		
		System.out.println(result);
		
		sc.close();
	}

	private static long dps(int[][] map, long[][] visit, int i, int j) {
		// TODO Auto-generated method stub
		if(visit[i][j] == 0 && map[i][j]!=0) {
			if(i+map[i][j] < map.length && j+map[i][j] < map.length) {
				visit[i][j] = dps(map, visit, i+map[i][j], j) + dps(map, visit, i, j+map[i][j]);
			}
			else if(i+map[i][j] < map.length) {
				visit[i][j] = dps(map, visit, i+map[i][j], j);
			}
			else if(j+map[i][j] < map.length) {
				visit[i][j] = dps(map, visit, i, j+map[i][j]);
			}
		}
		return visit[i][j];
	}

}
