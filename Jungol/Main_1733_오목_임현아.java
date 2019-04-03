package hw;

import java.util.Scanner;

public class Main_1733_오목_임현아 {

	public static int[] dx = { 0, 1, 1, -1 };
	public static int[] dy = { 1, 1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] pann = new int[20][20];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				pann[i][j] = sc.nextInt();
			}
		}

		boolean[][][] visit = new boolean[20][20][4];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (pann[i][j] != 0) { // 누군가의 바둑이 판에 있을 때
					for (int d = 0; d < 4; d++) {
						int cnt = dfs(visit, pann, i, j, d, pann[i][j]);
						if (cnt == 5) {
							System.out.println(pann[i][j]);
							System.out.println(i + " " + j);
							return;
						}
					}
				}
			}
		}

		System.out.println(0);
	}

	private static int dfs(boolean[][][] visit, int[][] pann, int i, int j, int d, int p) {
		// TODO Auto-generated method stub
		if (i <= 0 || i >= 20 || j >= 20 || pann[i][j] != p || visit[i][j][d])
			return 0;
		else {
			if (d != 3)
				visit[i][j][d] = true;
			return dfs(visit, pann, i + dx[d], j + dy[d], d, p) + 1;
		}
	}

}
