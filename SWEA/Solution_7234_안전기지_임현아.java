package swexpert;

import java.util.Scanner;

public class Solution_7234_안전기지_임현아 {
	
	static int[] dx = {0, 0, 0, 0, -1, -2, 1, 2};
	static int[] dy = {-1, -2, 1, 2, 0, 0, 0, 0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[][] local = new int[n+1][n+1];
			int b = sc.nextInt();
			for(int i=0; i<b; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				local[x][y]++;
				for(int j=0; j<8; j++) {
					int rx = x + dx[j];
					int ry = y + dy[j];
					if(rx >= 0 && ry >= 0 && rx <= n && ry <= n) {
						local[rx][ry]++;
					}
				}
			}
			
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					max = max < local[i][j] ? local[i][j] : max;
				}
			}
			
			System.out.println("#" + t + " " + max);
			
		}
		
	}

}
