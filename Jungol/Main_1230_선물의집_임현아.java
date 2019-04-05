package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1230_선물의집_임현아 {
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	private static int max = Integer.MIN_VALUE;
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visit = new boolean[n][n];
		dfs(visit, 0, 0, map[0][0] == 2 ? 1 : 0);

		System.out.println(max);
	}

	private static void dfs(boolean[][] visit, int x, int y, int sum) {
		if(x == n-1 && y == n-1) max = max < sum ? sum : max;
		else {
			visit[x][y] = true;
			for(int i=0; i<4; i++ ) {
				int rx = x + dx[i];
				int ry = y + dy[i];
				if(rx >= 0 && ry >= 0 && rx < n && ry < n && !visit[rx][ry]) {
					if(map[rx][ry] == 2) {
						dfs(visit, rx, ry, sum + 1);
					}
					else if(map[rx][ry] == 0) {
						dfs(visit, rx, ry, sum);
					}
				}
			}
			visit[x][y] = false;
		}
	}

}
