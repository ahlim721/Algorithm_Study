package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16234_인구이동 {

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	private static int n;
	private static int l;
	private static int r;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		r = Integer.parseInt(s[2]);

		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(s[j]);
		}

		int day = 0;
		while (true) {
			int area = 1;
			int[] pp = new int[n * n + 1];
			int[][] move = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (move[i][j] == 0) { // 방문한적이없다면,
						int[] t = { i, j };
						pp[area] = bfs(a, move, area, t);
						area++;
					}
				}
			}
									
			if(area == n*n+1) break;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					a[i][j] = pp[move[i][j]];
				}
			}
			day++;
		}
		
		System.out.println(day);
	}

	private static int bfs(int[][] a, int[][] move, int area, int[] t) {
		boolean[][] visit = new boolean[n][n];

		int cnt = 1;
		int sum = a[t[0]][t[1]];
		
		Queue<int[]> qLoc = new LinkedList<>();
		qLoc.add(t);
		visit[t[0]][t[1]] = true;
		move[t[0]][t[1]] = area;
	
		while (!qLoc.isEmpty()) {
			int[] g = qLoc.poll();
			for (int i = 0; i < 4; i++) {
				int rx = g[0] + dx[i];
				int ry = g[1] + dy[i];
				if (rx >= 0 && ry >= 0 && rx < n && ry < n) {
					int cha = Math.abs(a[g[0]][g[1]] - a[rx][ry]);
					if(!visit[rx][ry] && cha >= l && cha <= r) {
						int[] tmp = {rx, ry};
						qLoc.add(tmp);
						visit[rx][ry] = true;
						move[rx][ry] = area;
						cnt++;
						sum += a[rx][ry];
					}
				}
			}
		}

		return sum / cnt;
	}

}
