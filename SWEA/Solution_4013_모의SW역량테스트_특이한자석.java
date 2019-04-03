package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4013_모의SW역량테스트_특이한자석 {

	private static int[][] magnet;

	public static void main(String[] args) throws Exception {
		// S : 1, N : 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int k = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < 8; j++)
					magnet[i][j] = Integer.parseInt(s[j]);
			}
			int[] point = new int[4]; // 현재 화살표 위치

			for (int i = 0; i < k; i++) {
				String[] s = br.readLine().split(" ");
				int sel = Integer.parseInt(s[0]) - 1;
				int loc = Integer.parseInt(s[1]);

				boolean[] isTurn = new boolean[4];

				turn(sel, loc, isTurn, point);
				
			}
			
			int sum = 0;
			sum += magnet[0][point[0]] == 0 ? 0 : 1;
			sum += magnet[1][point[1]] == 0 ? 0 : 2;
			sum += magnet[2][point[2]] == 0 ? 0 : 4;
			sum += magnet[3][point[3]] == 0 ? 0 : 8;
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static void turn(int sel, int loc, boolean[] isTurn, int[] point) {
		// TODO Auto-generated method stub
		isTurn[sel] = true;
		int t = loc == -1 ? 1 : -1;
		if (sel == 0) { // 오른쪽만 확인
			if (!isTurn[1]) {
				if (magnet[0][(point[0] + 2) % 8] != magnet[1][(point[1] + 6) % 8]) {
					turn(1, t, isTurn, point);
				}
			}
		} else if (sel == 1) {
			if (!isTurn[0]) { // 왼쪽 확인
				if(magnet[1][(point[1] + 6) % 8] != magnet[0][(point[0] + 2) % 8]) {
					turn(0, t, isTurn, point);
				}
			}
			if (!isTurn[2]) { // 오른쪽 확인
				if (magnet[1][(point[1] + 2) % 8] != magnet[2][(point[2] + 6) % 8]) {
					turn(2, t, isTurn, point);
				}
			}
		} else if (sel == 2) {
			if (!isTurn[1]) { // 왼쪽 확인
				if(magnet[2][(point[2] + 6) % 8] != magnet[1][(point[1] + 2) % 8]) {
					turn(1, t, isTurn, point);
				}
			}
			if (!isTurn[3]) { // 오른쪽 확인
				if (magnet[2][(point[2] + 2) % 8] != magnet[3][(point[3] + 6) % 8]) {
					turn(3, t, isTurn, point);
				}
			}
		} else {
			if (!isTurn[2]) { // 왼쪽 확인
				if(magnet[3][(point[3] + 6) % 8] != magnet[2][(point[2] + 2) % 8]) {
					turn(2, t, isTurn, point);
				}
			}
		}
		point[sel] = (point[sel] - loc + 8) % 8;
	}

}
