package acmicpc;

import java.util.Scanner;

// 욕심쟁이 판다
// n*n 크기의 대나무 숲에서 상하좌우로 움직일 때, 가장 긴 증가하는 수열의 길이를 찾는 문제.
// 각 점에서의 최대 증가 수열의 개수를 찾는다. 그것을 저장한다.
public class Main_1937_욕심쟁이판다 {

	private static int[][] bamboo;
	private static int[][] memo;
	private static int n;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		bamboo = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bamboo[i][j] = sc.nextInt();
			}
		}
		

		memo = new int[n][n];

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = dps(i, j);
				ans = ans < cnt ? cnt : ans;
			}
		}
		
		System.out.println(ans);

		sc.close();
	}

	private static int dps(int x, int y) {
		if(memo[x][y] != 0)
			return memo[x][y];
		
		int ans = 0;
		for(int i=0; i<4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if(rx >= 0 && rx < n && ry >= 0 && ry < n) {
				if(bamboo[x][y] < bamboo[rx][ry]) {
					int cnt = dps(rx, ry);;
					ans = ans < cnt ? cnt : ans;
				}
			}
		}
		
		memo[x][y] = ans + 1;
		
		return memo[x][y];
	}

}
