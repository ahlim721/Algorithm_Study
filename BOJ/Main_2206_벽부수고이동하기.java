package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2206_벽부수고이동하기 {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		short[][] map = new short[n][m];
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = (short) (tmp.charAt(j) - '0');
			}
		}
		
		int[] start = {0, 0, 1, 0}; // 0 : x, 1 : y, 2 : len, 3 : 벽을 뚫었는지 확인
		int min = bfs(map, start);
		
		System.out.println(min);
	}

	private static int bfs(short[][] map, int[] start) {
		// TODO Auto-generated method stub
		boolean[][] visit = new boolean [map.length][map[0].length];
		boolean[][] bool = new boolean [map.length][map[0].length];
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visit[0][0] = true;
		bool[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] w = q.poll();
			
			if(w[0] == map.length-1 && w[1] == map[0].length-1) {
				return w[2];
			}
			
			for(int i=0; i<4; i++) {
				int rx = w[0] + dx[i];
				int ry = w[1] + dy[i];
				if(rx >= 0 && rx < map.length && ry >= 0 && ry < map[0].length && !visit[rx][ry]) {
					if(w[3] == 0) {
						if(map[rx][ry] == 1 && !bool[rx][ry]) {
							q.add(new int[] {rx, ry, w[2] + 1, 1});
							bool[rx][ry] = true;
						} else if(map[rx][ry] == 0) {
							q.add(new int[] {rx, ry, w[2] + 1, w[3]});
							visit[rx][ry] = true;
						}
					} else {
						if(map[rx][ry] == 0) {
							q.add(new int[] {rx, ry, w[2] + 1, w[3]});
							bool[rx][ry] = true;
						}
					}
					
				}
			}

		}
		
		return -1;
	}
}
