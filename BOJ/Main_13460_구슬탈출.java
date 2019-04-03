package acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13460_����Ż�� {

	static class Bead {
		// �������� ��ġ
		int redX;
		int redY;
		// �Ķ����� ��ġ
		int blueX;
		int blueY;
		// ����
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
			if (out.cnt > 10) { // 10�� ���Ϸ� �������� �� �� ���� ���
				break;
			}

			// ���������� �Ķ������� ���� ���ο� �ִ� ���, ������ ��츦 ����ؾ��Ѵ�.
			/*
			 * �ϴ�, �⺻������ �Ķ������� ���� �����ٰ� �����Ѵ�. 1. ��������.X == �Ķ�����.X ���� �࿡ ���� ��, ���� ��� -->
			 * ��������.Y < �Ķ�����.Y �϶� �������� ������ �κ��� ���� ���� ���� --> ��������.Y > �Ķ�����.Y �϶� ���������� ������ �κ���
			 * ���� ���� ���� 2. ��������.Y == �Ķ�����.Y ���� ���� ���� ��, ���� ��� --> ��������.X < �Ķ�����.X �϶� ���� ������
			 * �κ��� ���� ���� ���� --> ��������.X > �Ķ�����.X �϶� �Ʒ��� ������ �κ��� ���� ���� ����.
			 */

			for (int i = 0; i < 4; i++) {
				int blueX = out.blueX;
				int blueY = out.blueY;
				boolean blueF = true;
				int redX = out.redX;
				int redY = out.redY;
				boolean redF = true;

				// ������ ���� ������ ���.
				if ((blueX == redX && ((blueY > redY && i == 2) || (blueY < redY && i == 3)))
						|| (blueY == redY && ((blueX > redX && i == 0) || (blueX < redX && i == 1)))) {
					// ���� ���� Ž��
					while (true) {
						int rx = redX + dx[i];
						int ry = redY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (map[rx][ry] == '.') {
								redX = rx;
								redY = ry;
							}
							else if (map[rx][ry] == 'O') { // ������ ���� 
								redF = false; // �� ���� �ȵǿ�
								redX = -1;
								redY = -1;
								break;
							} else { // ������ ����
								redF = true;
								break;
							}
						}
					}

					// �Ķ� ���� Ž��
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
								blueF = false; // �� ���� �ȵǿ�
								break;
							} 
							else if (map[rx][ry] == '#'){
								blueF = true;
								break;
							}
						}
					}

				} else {
					// �Ķ� ������ ������ �����̹Ƿ�, �Ķ� ���� ���� Ž��
					while (true) {
						int rx = blueX + dx[i];
						int ry = blueY + dy[i];
						if (rx >= 0 && rx < n && ry >= 0 && ry < m) {
							if (map[rx][ry] == '.') {
								blueX = rx;
								blueY = ry;
							}
							else if (map[rx][ry] == 'O') {
								blueF = false; // �� ���� �ȵǿ�
								blueX = -1;
								blueY = -1;
								break;
							} else {
								blueF = true;
								break;
							}
						}
					}

					// ���� ���� Ž��
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
								redF = false; // �� ���� �ȵǿ�
								break;
							} 
							else if (map[rx][ry] == '#'){
								redF = true;
								break;
							}
						}
					}
				}
				
				if (blueF && !redF) {// �Ķ��� ���� �Ⱥ����� ������ ���� ������ ��
					System.out.println(out.cnt + 1);
					return;
				}
				if (blueF && redF) { // �Ѵ� �Ⱥ����� ���� Queue�� �־�� �Ѵ�.
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
