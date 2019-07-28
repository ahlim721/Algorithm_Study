package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main3184 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		// 맵을 생성
		char[][] map = new char[x][y];
		for (int i = 0; i < x; i++) {
			String tmp = sc.next();
			for (int j = 0; j < y; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		int v = 0; // 늑대의 개수
		int o = 0; // 양의 개수
		
		boolean[][] visit = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!visit[i][j] && map[i][j] != '#') {
					int[] ws = new int[2]; // 0은 늑대, 1은 양
					dfs(visit, map, ws, i, j);
					v += ws[0] >= ws[1] ? ws[0] : 0;
					o += ws[1] > ws[0] ? ws[1] : 0;
				}
			}
		}
		System.out.println(o + " " + v);
	}

	private static void dfs(boolean[][] visit, char[][] map, int[] ws, int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		if (map[x][y] == 'v')
			ws[0]++;
		else if (map[x][y] == 'o')
			ws[1]++;
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if (rx >= 0 && rx < map.length && ry >= 0 && ry < map[0].length && map[rx][ry] != '#' && !visit[rx][ry]) {
				dfs(visit, map, ws, rx, ry);
			}
		}
	}

}
