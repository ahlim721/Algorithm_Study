package com.ws;

import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기_임현아 {
	
	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {-1, 1, -1, 0, 1, -1, 0, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			char[][] map = new char[n][n];
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			int[][] count = new int[n][n];
			boolean[][] clicked = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == '.' && !clicked[i][j]) {
						dfs(map, clicked, count, i, j);
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static void dfs(char[][] map, boolean[][] clicked, int[][] count, int x, int y) {
		// TODO Auto-generated method stub
		// 내 자리 숫자만 체크
		int myNum = num(map, clicked, count, x, y);
		clicked[x][y] = true;
		
		// 고려해야할 점 
		for (int i = 0; i < 8; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			// 진출가능한지 확인
			if (rx >= 0 && ry >= 0 && rx < map.length && ry < map.length && map[rx][ry] != '*' && !clicked[rx][ry]) {
				int num = num(map, clicked, count, rx, ry);
				// 진출할 부분이 0 인 경우, 그 부분에 대해 다시 dfs
				if(num == 0) dfs(map, clicked, count, rx, ry);
				// 진출할 부분이 1이고 내가 0일 때는, 클릭만 해준다.
				else if(myNum == 0) clicked[rx][ry] = true;
			}
		}

	}

	// 현재 주변에 *가 있으면 1 없으면 0
	private static int num(char[][] map, boolean[][] clicked, int[][] count, int x, int y) {
		// TODO Auto-generated method stub
		if(clicked[x][y]) return count[x][y];
		
		for(int i=0; i<8; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if(rx >= 0 && ry >= 0 && rx < map.length && ry < map.length && map[rx][ry] == '*') {
				count[x][y] = 1;
				break;	
			}
		}
		return count[x][y];
	}

	

}
