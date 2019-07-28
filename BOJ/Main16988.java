package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main16988 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int m = Integer.parseInt(str.split(" ")[1]);
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		ArrayList<int[][]> arr = new ArrayList<>();
		boolean[][] visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2 && !visit[i][j]) {
					// [0][0] : size, [0][1] : loc, [1] : 1¹ÙµÏµ¹, [2] : 2¹ÙµÏµ¹
					int[][] check = new int[3][2];
					dfs(map, visit, check, i, j);
					arr.add(check);
				}
			}
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i)[0][0]);
			System.out.print(" " +arr.get(i)[0][1]);
			System.out.print(" " +arr.get(i)[1][0]);
			System.out.print(" " +arr.get(i)[1][1]);
			System.out.print(" " +arr.get(i)[2][0]);
			System.out.println(" " +arr.get(i)[2][1]);
		}
		
	}

	private static void dfs(int[][] map, boolean[][] visit, int[][] check, int x, int y) {
		// TODO Auto-generated method stub
		check[0][0]++;
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if (rx >= 0 && ry >= 0 && rx < map.length && ry < map[0].length) {
				if (map[rx][ry] == 2 && !visit[rx][ry]) {
					dfs(map, visit, check, rx, ry);
				} else if (map[rx][ry] == 0) {
					if (!(rx == check[1][0] && ry == check[1][1]) && !(rx == check[2][0] && ry == check[2][1])) {
						if (check[0][1] < 2) {
							check[0][1]++;
							check[check[0][1]][0] = rx;
							check[check[0][1]][1] = ry;
						} else {

							check[0][1]++;
						}
					}
				}
			}
		}
	}
}
