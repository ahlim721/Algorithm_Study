package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_���簢��Ż�� {

	private static int n;
	private static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		short[][] map = new short[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = Short.parseShort(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		// ���簢���� ����. 0 : h, 1 : w
		int[] info = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		// ����� ����. 0 : Sr, 1 : Sc
		int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0 };
		// ������ ����. 0 : Fr, 1 : Fc
		int[] dest = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

		int ans = bfs(map, info, start, dest);

		System.out.println(ans);

	}

	private static int bfs(short[][] map, int[] info, int[] start, int[] dest) {
		// TODO Auto-generated method stub
		int ans = -1;

		boolean[][] visit = new boolean[n + 1][m + 1];
		Queue<int[]> que = new LinkedList<>();

		que.add(start);
		visit[start[0]][start[1]] = true;

		while (!que.isEmpty()) {
			int[] rec = que.poll();

			if (rec[0] == dest[0] && rec[1] == dest[1]) {
				ans = rec[2];
				break;
			}

			// �������� ���� ���
			if (rec[1] > 1 && !visit[rec[0]][rec[1] - 1]) { // �ϴ� �������� �� ���� �ִٸ�
				boolean flag = true;
				for (int i = rec[0]; i < rec[0] + info[0]; i++) {
					if (map[i][rec[1] - 1] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					que.add(new int[] { rec[0], rec[1] - 1, rec[2] + 1 });
					visit[rec[0]][rec[1] - 1] = true;
				}
			}

			// ���������� ���� ���
			if (rec[1] + info[1] <= m && !visit[rec[0]][rec[1] + 1]) { // �ϴ� ���������� �� ���� �ִٸ�
				boolean flag = true;
				for (int i = rec[0]; i < rec[0] + info[0]; i++) {
					if (map[i][rec[1] + info[1]] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					que.add(new int[] { rec[0], rec[1] + 1, rec[2] + 1 });
					visit[rec[0]][rec[1] + 1] = true;
				}
			}

			// �������� ���� ���
			if (rec[0] > 1 && !visit[rec[0] - 1][rec[1]]) { // �ϴ� �������� �� ���� �ִٸ�
				boolean flag = true;
				for (int i = rec[1]; i < rec[1] + info[1]; i++) {
					if (map[rec[0] - 1][i] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					que.add(new int[] { rec[0] - 1, rec[1], rec[2] + 1 });
					visit[rec[0] - 1][rec[1]] = true;
				}
			}

			// �Ʒ������� ���� ���
			if (rec[0] + info[0] <= n && !visit[rec[0] + 1][rec[1]]) { // �ϴ� �Ʒ������� �� ���� �ִٸ�
				boolean flag = true;
				for (int i = rec[1]; i < rec[1] + info[1]; i++) {
					if (map[rec[0] + info[0]][i] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					que.add(new int[] { rec[0] + 1, rec[1], rec[2] + 1 });
					visit[rec[0] + 1][rec[1]] = true;
				}
			}
		}
		
		return ans;
	}

}
