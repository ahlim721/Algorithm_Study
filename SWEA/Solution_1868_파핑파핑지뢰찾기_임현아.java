package com.ws;

import java.util.Scanner;

public class Solution_1868_������������ã��_������ {
	
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
		// �� �ڸ� ���ڸ� üũ
		int myNum = num(map, clicked, count, x, y);
		clicked[x][y] = true;
		
		// ����ؾ��� �� 
		for (int i = 0; i < 8; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			// ���Ⱑ������ Ȯ��
			if (rx >= 0 && ry >= 0 && rx < map.length && ry < map.length && map[rx][ry] != '*' && !clicked[rx][ry]) {
				int num = num(map, clicked, count, rx, ry);
				// ������ �κ��� 0 �� ���, �� �κп� ���� �ٽ� dfs
				if(num == 0) dfs(map, clicked, count, rx, ry);
				// ������ �κ��� 1�̰� ���� 0�� ����, Ŭ���� ���ش�.
				else if(myNum == 0) clicked[rx][ry] = true;
			}
		}

	}

	// ���� �ֺ��� *�� ������ 1 ������ 0
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
