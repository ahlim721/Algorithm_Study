package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_모의SW역량테스트_활주로건설_임현아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];

			int ans = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			for (int i = 0; i < n; i++) {
				int[] row = new int[n];
				int[] col = new int[n];
				for (int j = 0; j < n; j++) {
					row[j] = map[j][i];
					col[j] = map[i][j];
				}
				if (check(row, x))
					ans++;
				if (check(col, x))
					ans++;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean check(int[] map, int x) {

		boolean[] visit = new boolean[map.length];

		int a = map[0];
		for (int i = 1; i < map.length; i++) {
			if (a < map[i])
				a = map[i];
			else if (map[i] == a - 1) {
				for (int j = 0; j < x; j++) {
					if (i + j < map.length && map[i + j] == map[i]) {
						visit[i + j] = true;
					} else {
						return false;
					}
				}
				a = map[i + x - 1];
				i = i + x - 1;
			} else if (map[i] < a - 1) {
				return false;
			}
		}

		int b = map[map.length - 1];
		for (int i = map.length - 2; i >= 0; i--) {
			if (b < map[i])
				b = map[i];
			else if (map[i] == b - 1) {
				for (int j = 0; j < x; j++) {
					if (i - j >= 0 && map[i - j] == map[i] && !visit[i - j]) {
						visit[i - j] = true;
					} else {
						return false;
					}
				}
				b = map[i - x + 1];
				i = i - x + 1;
			} else if (map[i] < b - 1) {
				return false;
			}
		}

		return true;
	}

}
