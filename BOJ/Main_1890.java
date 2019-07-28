package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1890 {
	// public static long cnt = 0;
	public static int[][] map;
	public static int[] dx = { 1, 0 };// 아래 오른쪽 순
	public static int[] dy = { 0, 1 };
	// public static Node[] node;
	public static long[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N]; // map
		memo = new long[N][N]; // memoization

		// map값 입력
		for (int tc = 0; tc < N; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int i = 0; i < N; i++) {
				map[tc][i] = Integer.parseInt(st.nextToken());
			}
		}

		memo[0][0] = 1;
		// bfs();
		System.out.println(dp(N - 1, N - 1));

	}// end of main

	public static void bfs() {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(0);
		qy.offer(0);

		while (!qx.isEmpty() && !qy.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for (int i = 0; i < 2; i++) {
				int nx = x + dx[i] * map[x][y];
				int ny = y + dy[i] * map[x][y];

				if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && map[nx][ny] != 0) {
					memo[nx][ny]++;
/////////////////////
					System.out.println(" x : " + x + " y : " + y + "nx : " + nx + " ny : " + ny);
					for (int b = 0; b < memo.length; b++) {
						for (int h = 0; h < memo.length; h++) {
							System.out.print(memo[b][h] + " ");
						}
						System.out.println();
					}
//////////////////
					if (!(nx == map.length - 1 && ny == map.length - 1)) {
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
			if (x >= 10 && y >= 10)
				break;
		}
	}

	public static long dp(int x, int y) {
		// memo[0][0] = 0;

		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo.length; j++) {
				if (j + map[i][j] < memo.length && j + map[i][j] > 10)
					memo[i][j + map[i][j]] += memo[i][j];
			}
		}

		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo.length; j++) {
				if (j + map[i][j] < memo.length && j + map[i][j] > 10)
					memo[j + map[i][j]][i] += memo[i][j];
			}
		}

		/////////////////////
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo.length; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
		//////////////////

		for (int i = 11; i < memo.length; i++) {
			for (int j = 11; j < memo.length; j++) {
				if (j + map[i][j] < memo.length)
					memo[i][j + map[i][j]] += memo[i][j];
			}
		}

		////////////////////////
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo.length; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
		////////////////////////////

		memo[x][y] = 0;

		for (int i = 0; i < x; i++) {
			if (i + map[i][y] == y)
				memo[x][y] += memo[i][y];
			if (i + map[x][i] == x)
				memo[x][y] += memo[x][i];
		}
		return memo[x][y];
	}

}// end of class