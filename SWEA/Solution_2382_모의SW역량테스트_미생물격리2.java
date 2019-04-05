package day0405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_2382_모의SW역량테스트_미생물격리2 {
	
	static class MicroCell {
		int x, y, cnt, rcnt, dir;
		
		MicroCell(int x, int y, int cnt, int rcnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.rcnt = rcnt;
			this.dir = dir;
		}
	}
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			
			// 약품 처리를 초기화
			for(int i=0; i<n; i++) {
				map[0][i] = -1;
				map[i][0] = -1;
				map[n-1][i] = -1;
				map[i][n-1] = -1;
			}
			
			ArrayList<MicroCell> list = new ArrayList<>();
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				list.add(new MicroCell(x, y, cnt, cnt, dir));
				
				map[x][y] = cnt;
			}
			
			// for(int i=0; i<n; i++) System.out.println(Arrays.toString(map[i]));
			
			while(m != 0) {
				for(MicroCell mc : list) {
					moveCell(map, mc);
				}
			}
			
		}
	}

	private static void moveCell(int[][] map, MicroCell mc) {
		mc.x += dx[mc.dir];
		mc.y += dy[mc.dir];
		if(mc.x == 0 || mc.y == 0 || mc.x == n-1 || mc.y == n-1) {
			mc.cnt /= 2;
			mc.dir = mc.dir == 1 ? 2 : mc.dir == 2 ? 1 : mc.dir == 3 ? 4 : 3;
		}
		else if(map[mc.x][mc.y] != 0) {
			
		}
	}

}
