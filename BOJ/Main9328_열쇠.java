package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9328_���� {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	private static int countOfFiles;
	private static String keys;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			String[] input = br.readLine().split(" ");

			int h = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);

			char[][] map = new char[h + 2][w + 2];
			for (int i = 0; i < h + 2; i++) {
				for (int j = 0; j < w + 2; j++)
					map[i][j] = '.';
			}

			for (int i = 1; i <= h; i++) {
				String s = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = s.charAt(j - 1);
				}
			}

			keys = br.readLine();
			countOfFiles = 0;
			
			// �ʿ� ��ȭ�� ������ �� ���� �ݺ�
			while (findKeys(w + 2, h + 2, map)) {}

			System.out.println(countOfFiles);

		}
	}

	// Ű, ��, ������ �߰��ϸ� '.' �� �ٲ��ְ�, �ʿ� ��ȭ�� �ִ� ���� üũ 
	private static boolean findKeys(int w, int h, char[][] map) {
		boolean flag = false;

		boolean[][] visit = new boolean[h][w];
		int[][] que = new int[h * w][2];
		int top = -1;
		int pre = -1;

		visit[0][0] = true;
		que[++top] = new int[] { 0, 0 };

		while (top != pre) {
			int[] dp = que[++pre];
			for (int i = 0; i < 4; i++) {
				int rx = dx[i] + dp[0];
				int ry = dy[i] + dp[1];
				if (rx >= 0 && ry >= 0 && rx < h && ry < w && !visit[rx][ry] && map[rx][ry] != '*') {
					if (map[rx][ry] == '.') { // �湮����
						visit[rx][ry] = true;
						que[++top] = new int[] { rx, ry };
					} else if (map[rx][ry] == '$') { // ������ ���
						countOfFiles++;
						flag = true;
						map[rx][ry] = '.';
						visit[rx][ry] = true;
						que[++top] = new int[] { rx, ry };
					} else if (65 <= map[rx][ry] && map[rx][ry] <= 90) { // �빮���� ���
						char key = (char) (map[rx][ry] + 32);
						if (keys.contains(key + "")) {
							flag = true;
							map[rx][ry] = '.';
							visit[rx][ry] = true;
							que[++top] = new int[] { rx, ry };
						}
					} else if (97 <= map[rx][ry] && map[rx][ry] <= 122) { // �ҹ����� ���
						keys += map[rx][ry];
						flag = true;
						map[rx][ry] = '.';
						visit[rx][ry] = true;
						que[++top] = new int[] { rx, ry };
					}
				}
			}
		}

		return flag;
	}

}
