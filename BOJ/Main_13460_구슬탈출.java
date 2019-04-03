package acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13460_구슬탈출 {

	static class Bead {
		// 빨간구슬 위치
		int redX;
		int redY;
		// 파란구슬 위치
		int blueX;
		int blueY;
		// 개수
		int cnt;

		public Bead() {
		}

		public Bead(int redX, int redY, int blueX, int blueY, int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] map = new char[n][m];

		Bead bead = new Bead();
		bead.cnt = 0;
		int[] hole;

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					bead.redX = i;
					bead.redY = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'B') {
					bead.blueX = i;
					bead.blueY = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'O') {
					int[] tmp = { i, j };
					hole = tmp;
				}
			}
		}

		boolean[][][][] visit = new boolean[10][10][10][10];
		Queue<Bead> qb = new LinkedList<>();
		qb.add(bead);
		visit[bead.redX][bead.redY][bead.blueX][bead.blueY] = true;

		while (!qb.isEmpty()) {
			Bead out = qb.poll();
			if (out.cnt > 10) { // 10번 이하로 움직여서 뺄 수 없는 경우
				break;
			}

			// 빨간구슬과 파란구슬이 같은 라인에 있는 경우, 내리는 경우를 고려해야한다.
			/*
			 * 일단, 기본적으로 파란구슬을 먼저 굴린다고 가정한다. 1. 빨간구슬.X == 파란구슬.X 같은 행에 있을 때, 열을 고려 -->
			 * 빨간구슬.Y < 파란구슬.Y 일때 왼쪽으로 돌리는 부분을 빨간 구슬 먼저 --> 빨간구슬.Y > 파란구슬.Y 일때 오른쪽으로 돌리는 부분을
			 * 빨간 구슬 먼저 2. 빨간구슬.Y == 파란구슬.Y 같은 열에 있을 때, 행을 고려 --> 빨간구슬.X < 파란구슬.X 일때 위로 돌리는
			 * 부분을 빨간 구슬 먼저 --> 빨간구슬.X > 파란구슬.X 일때 아래로 돌리는 부분을 빨간 구슬 먼저.
			 */

			for (int i = 0; i < 4; i++) {
				int blueX = out.blueX;
				int blueY = out.blueY;
				boolean blueF = true;
				int redX = out.redX;
				int redY = out.redY;
				boolean redF = true;

				// 빨간색 먼저 내리는 경우.
				if ((blueX == redX && ((blueY > redY && i == 2) || (blueY < redY && i == 3)))
						|| (blueY == redY && ((blueX > redX && i == 0) || (blueX < redX && i == 1)))) {
					// 빨간 구슬 탐색
					while (true) {
						int rx = redX + dx[i];
						int ry = redY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (map[rx][ry] == '.') {
								redX = rx;
								redY = ry;
							}
							else if (map[rx][ry] == 'O') { // 빨간색 빠짐 
								redF = false; // 이 경우는 안되요
								redX = -1;
								redY = -1;
								break;
							} else { // 빨간색 안착
								redF = true;
								break;
							}
						}
					}

					// 파란 구슬 탐색
					while (true) {
						int rx = blueX + dx[i];
						int ry = blueY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (rx == redX && ry == redY) {
								blueF = true;
								break;
							}
							else if (map[rx][ry] == '.') {
								blueX = rx;
								blueY = ry;
							}
							else if (map[rx][ry] == 'O') {
								blueF = false; // 이 경우는 안되요
								break;
							} 
							else if (map[rx][ry] == '#'){
								blueF = true;
								break;
							}
						}
					}

				} else {
					// 파란 구슬이 빠지면 실패이므로, 파란 구슬 먼저 탐색
					while (true) {
						int rx = blueX + dx[i];
						int ry = blueY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (map[rx][ry] == '.') {
								blueX = rx;
								blueY = ry;
							}
							else if (map[rx][ry] == 'O') {
								blueF = false; // 이 경우는 안되요
								blueX = -1;
								blueY = -1;
								break;
							} else {
								blueF = true;
								break;
							}
						}
					}

					// 빨간 구슬 탐색
					while (true) {
						int rx = redX + dx[i];
						int ry = redY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (rx == blueX && ry == blueY) {
								redF = true;
								break;
							}
							else if (map[rx][ry] == '.') {
								redX = rx;
								redY = ry;
							}
							else if (map[rx][ry] == 'O') {
								redF = false; // 이 경우는 안되요
								break;
							} 
							else if (map[rx][ry] == '#'){
								redF = true;
								break;
							}
						}
					}
				}
				
				if (blueF && !redF) {// 파란색 공이 안빠지고 빨간색 공만 빠졌을 때
					System.out.println(out.cnt + 1);
					return;
				}
				if (blueF && redF) { // 둘다 안빠졌을 때는 Queue에 넣어야 한다.
					if(visit[redX][redY][blueX][blueY] == false) {
						System.out.println(out.cnt+1);
						for(int k=0; k<n; k++) {
							map[redX][redY] = 'R';
							map[blueX][blueY] = 'B';
							System.out.println(Arrays.toString(map[k]));
							map[redX][redY] = '.';
							map[blueX][blueY] = '.';
						}
						System.out.println();
						qb.add(new Bead(redX, redY, blueX, blueY, out.cnt + 1));
						visit[redX][redY][blueX][blueY] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
