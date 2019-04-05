package day0405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_모의SW역량테스트_탈주범검거 {

	private static int n;
	private static int m;
	private static int r;
	private static int c;
	private static int l;
	private static int[][] map;
	
	private static int[][] dx = {{0}, {-1, 1, 0, 0}, {-1, 1, 0, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {-1, 0, 0, 0}};
	private static int[][] dy = {{0}, {0, 0, -1, 1}, {0, 0, 0, 0}, {0, 0, -1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, -1, 0}, {0, 0, -1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ").append(bfs()).append("\n");
		}
		System.out.print(sb);
	}

	private static int bfs() {
		int ans = 0;
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {r, c, map[r][c], 1});
		visit[r][c] = true;
		ans++;
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			if (tmp[3] < l) {
				for (int i = 0; i < 4; i++) {
					int rx = tmp[0] + dx[tmp[2]][i];
					int ry = tmp[1] + dy[tmp[2]][i];
					if (rx >= 0 && ry >= 0 && rx < n && ry < m && !visit[rx][ry] && map[rx][ry] != 0) {
						boolean canGo = false;
						switch(map[rx][ry]) {
						case 1:
							canGo = true;
							break;
						case 2:
							if(i == 0 || i == 1) canGo = true;
							break;
						case 3:
							if(i == 2 || i == 3) canGo = true;
							break;
						case 4:
							if(i == 1 || i == 2) canGo = true;
							break;
						case 5:
							if(i == 0 || i == 2) canGo = true;
							break;
						case 6:
							if(i == 0 || i == 3) canGo = true;
							break;
						case 7:
							if(i == 1 || i == 3) canGo = true;
							break;
						}
						if(canGo) {
							que.add(new int[] { rx, ry, map[rx][ry], tmp[3] + 1 });
							visit[rx][ry] = true;
							ans++;
						}
						
					}
				}
			}
		}
		
		return ans;
	}

}
