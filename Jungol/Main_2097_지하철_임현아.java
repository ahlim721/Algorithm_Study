package hw;

import java.util.Scanner;

public class Main_2097_지하철_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 지하철 수
		int m = sc.nextInt(); // 목적역의 번호

		int[][] subway = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				subway[i][j] = sc.nextInt();
		}

		int[] min = new int[n + 1];
		String[] route = new String[n + 1];
		boolean[] visit = new boolean[n + 1];
		int cnt = 0;

		visit[1] = true;
		cnt++;
		route[1] = "1";
		for (int i = 2; i <= n; i++) {
			min[i] = subway[1][i];
			route[i] = route[1] + " " + i;
		}

		while (cnt != n) {

			int i = getMin(min, visit);
			if (i == Integer.MAX_VALUE) {// 모든 경로가 0인 경우

			} else {
				for (int j = 1; j <= n; j++) {
					if (min[j] > min[i] + subway[i][j]) {
						min[j] = min[i] + subway[i][j];
						route[j] = route[i] + " " + j;
					}
				}
			}
			visit[i] = true;
			cnt++;
		}

		System.out.println(min[m]);
		System.out.println(route[m]);
		
		sc.close();
	}

	private static int getMin(int[] min, boolean[] visit) {
		// TODO Auto-generated method stub
		int m = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i < min.length; i++) {
			if (visit[i])
				continue;

			if (min[i] != 0 && min[i] < m) {
				m = min[i];
				idx = i;
			}
		}
		return idx;
	}
}
