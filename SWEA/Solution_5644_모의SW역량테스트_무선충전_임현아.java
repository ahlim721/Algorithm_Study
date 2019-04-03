package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_모의SW역량테스트_무선충전_임현아 {

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			StringTokenizer A = new StringTokenizer(br.readLine(), " ");
			StringTokenizer B = new StringTokenizer(br.readLine(), " ");

			boolean[][][] map = new boolean[11][11][a];
			int[] AP = new int[a];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				AP[i] = Integer.parseInt(st.nextToken());

				// 마름모 윗부분
				for (int j = l; j > 0; j--) {
					if (x - j <= 0)
						continue;
					for (int k = -1 * (l - j); k <= (l - j); k++) {
						if (y + k <= 0 || y + k > 10)
							continue;
						map[x - j][y + k][i] = true;
					}
				}
				// 마름모 아래부분
				for (int j = l; j >= 0; j--) {
					if (x + j > 10)
						continue;
					for (int k = -1 * (l - j); k <= (l - j); k++) {
						if (y + k <= 0 || y + k > 10)
							continue;
						map[x + j][y + k][i] = true;
					}
				}

			}

			// 사용자 배정
			int sum = 0;
			int[] userA = { 1, 1 };
			int[] userB = { 10, 10 };
			for (int i = 0; i <= m; i++) {
				int dirA = 0;
				int dirB = 0;
				if (i != 0) {
					dirA = Integer.parseInt(A.nextToken());
					dirB = Integer.parseInt(B.nextToken());
				}

				userA[0] = userA[0] + dx[dirA];
				userA[1] = userA[1] + dy[dirA];

				userB[0] = userB[0] + dx[dirB];
				userB[1] = userB[1] + dy[dirB];

				sum += maxSum(map[userA[0]][userA[1]], map[userB[0]][userB[1]], AP);
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}

	private static int maxSum(boolean[] A, boolean[] B, int[] AP) {
		// TODO Auto-generated method stub
		int ans = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] && !B[j])
					ans = ans < AP[i] ? AP[i] : ans;
				else if (!A[i] && B[j])
					ans = ans < AP[j] ? AP[j] : ans;
				else if (A[i] && B[j]) {
					if (i == j)
						ans = ans < AP[i] ? AP[i] : ans;
					else 
						ans = ans < (AP[i] + AP[j]) ? AP[i] + AP[j] : ans;
				}
			}
		}

		return ans;
	}

}
