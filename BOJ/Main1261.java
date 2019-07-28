package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1261 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]); 
		int m = Integer.parseInt(s[1]);
		int[][] maze = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
			
			
		} 
		
	}
}
