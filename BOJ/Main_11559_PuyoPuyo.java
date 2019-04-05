package day0405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11559_PuyoPuyo {
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[12][6];
		for(int i=0; i<12; i++) {
			String s = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int ans = 0;
		
		int cnt = -1;
		while(cnt != 0) {
			cnt = puyoBoom(map);
			if(cnt != 0) ans++;
			map = puyoFall(map);
		}
		
		System.out.println(ans);
	}

	private static char[][] puyoFall(char[][] map) {
		char[][] tmp = new char[12][6];
		for(int i=0; i<12; i++) Arrays.fill(tmp[i], '.');
		
		for(int i=0; i<6; i++) {
			int idx = 11;
			for(int j=11; j>=0; j--) {
				if(map[j][i] != '.') tmp[idx--][i] = map[j][i]; 
			}
		}
		
		return tmp;
	}

	private static int puyoBoom(char[][] map) {
		int ans = 0;
		boolean[][] visit = new boolean[12][6];
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(map[i][j] != '.' && !visit[i][j]) {
					if(bfs(map, visit, i, j)) ans++;
				}
			}
		}
		return ans;
	}
	
	private static boolean bfs(char[][] map, boolean[][] visit, int x, int y) {
		boolean ans = false;
		
		int[][] que = new int[72][2];
		int front = -1;
		int rear = -1;
		
		que[++front] = new int[] {x, y};
		visit[x][y] = true;
		
		while(front != rear) {
			int[] tmp = que[++rear];
			for(int i=0; i<4; i++) {
				int rx = tmp[0] + dx[i];
				int ry = tmp[1] + dy[i];
				if(rx >= 0 && ry >= 0 && rx < 12 && ry < 6 && !visit[rx][ry] && map[rx][ry] == map[x][y]) {
					que[++front] = new int[] {rx, ry};
					visit[rx][ry] = true;
				}
			}
		}
		
		if(front >= 3) {
			for(int i=0; i<=front; i++) {
				map[que[i][0]][que[i][1]] = '.';
			}
			ans = true;
		}
		
		return ans;
	}

}
