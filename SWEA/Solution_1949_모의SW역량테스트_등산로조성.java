package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_모의SW역량테스트_등산로조성 {

	private static int n;
	private static int k;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			int start = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (start < map[i][j])
						start = map[i][j];
				}
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == start) {
						boolean[][] visit = new boolean[n][n];
						int max = dfs(i, j, map[i][j], false, visit);
						ans = ans < max ? max : ans;
					}
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	private static int dfs(int x, int y, int h, boolean isBool, boolean[][] visit) {
		int ans = 0;

		int max = 0;
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if (rx >= 0 && ry >= 0 && rx < n && ry < n && !visit[rx][ry]) {
				if (isBool) { // 깍은 적이 있다면
					if (h > map[rx][ry]) {
						max = dfs(rx, ry, map[rx][ry], isBool, visit);
					}
				} else { // 깍은 적이 없다면
					if (h > map[rx][ry]) {
						max = dfs(rx, ry, map[rx][ry], isBool, visit);
					} else {
						if(map[rx][ry] - k < h) {
							max = dfs(rx, ry, h-1, true, visit);
						}
					}
				}
				ans = max > ans ? max : ans;
			}
		}
		visit[x][y] = false;

		return ans + 1;
	}

}
