package swea;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Solution_홈방법서비스 {

	// initialize operation cost
	static int[] operCost = new int[23];

	// n -> (내부 정사각영역) (k)
	// 1 -> 1 (1) , 3 -> 1 (2) , 5 -> 3 (3) , 7 -> 3 (4)
	// 9 -> 5 (5) , 11 -> 5 (6), 13 -> 7 (7), 15 -> 7 (8)
	// 17 -> 9 (9), 19 -> 9 (10), 21 -> 11 (11), 23 -> 11 (12)
	// 13 13 15 15 17 17 19 19 21 43 -> 21 (22)
	public static void initCost() {
		for (int i = 1; i < operCost.length; i++) {
			operCost[i] = (i * i) + ((i - 1) * (i - 1));
		}
	}

	public static void main(String[] args) throws Exception {

		initCost();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int maxCost = 0;
			int[][] loc = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					loc[i][j] = Integer.parseInt(st.nextToken());
					if (loc[i][j] == 1)
						maxCost += m;
				}
			}

			int maxK = findMaxK(maxCost);

			int maxCount = -1;
			// 해당 위치에서 1,2,3,4분면으로 영역 체크.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					boolean[][] visit = new boolean[n][n];
					for (int k = 0; k < maxK; k++) {
						int cntK = 0;

						// 1사분면 방문
						cntK += get1Count(loc, visit, i, j, k);
						
						// 2사분면 방문
						cntK += get2Count(loc, visit, i, j, k);

						// 3사분면 방문
						cntK += get3Count(loc, visit, i, j, k);

						// 4사분면 방문
						cntK += get4Count(loc, visit, i, j, k);
						
						cnt += cntK;
						
						if(operCost[k + 1] <= cnt * m && maxCount < cnt)
							maxCount = cnt;
							
					}
				}
				
			}
			System.out.println("#" + t + " " + maxCount);

		}
	}

	private static int get1Count(int[][] loc, boolean[][] visit, int x, int y, int k) {

		int count = 0;

		for (int i = 0; i <= k; i++) {
			int dx = x - i;
			int dy = y - k + i;

			if (dx >= 0 && dx < visit.length && dy >= 0 && dy < visit[0].length && !visit[dx][dy]) {
				visit[dx][dy] = true;
				if (loc[dx][dy] == 1)
					count++;
			}
		}

		return count;
	}

	private static int get2Count(int[][] loc, boolean[][] visit, int x, int y, int k) {

		int count = 0;

		for (int i = 0; i <= k; i++) {
			int dx = x - i;
			int dy = y + k - i;

			if (dx >= 0 && dx < visit.length && dy >= 0 && dy < visit[0].length && !visit[dx][dy]) {
				visit[dx][dy] = true;
				if (loc[dx][dy] == 1)
					count++;
			}
		}

		return count;
	}

	private static int get3Count(int[][] loc, boolean[][] visit, int x, int y, int k) {

		int count = 0;

		for (int i = 0; i <= k; i++) {
			int dx = x + i;
			int dy = y + k - i;

			if (dx >= 0 && dx < visit.length && dy >= 0 && dy < visit[0].length && !visit[dx][dy]) {
				visit[dx][dy] = true;
				if (loc[dx][dy] == 1)
					count++;
			}
		}

		return count;
	}

	private static int get4Count(int[][] loc, boolean[][] visit, int x, int y, int k) {

		int count = 0;

		for (int i = 0; i <= k; i++) {
			int dx = x + i;
			int dy = y - k + i;

			if (dx >= 0 && dx < visit.length && dy >= 0 && dy < visit[0].length && !visit[dx][dy]) {
				visit[dx][dy] = true;
				if (loc[dx][dy] == 1)
					count++;
			}
		}

		return count;
	}

	private static int findMaxK(int maxCost) {
		for (int i = 0; i < operCost.length - 1; i++) {
			if (operCost[i] <= maxCost && operCost[i + 1] > maxCost)
				return i;
		}
		return operCost.length - 1;
	}

}
