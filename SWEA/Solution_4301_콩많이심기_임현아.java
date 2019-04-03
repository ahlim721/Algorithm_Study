package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_임현아 {

	private static int[][] map;

	public static void main(String[] args) throws Exception {
		
		makeBeans(1000, 1000);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int ans = countBeans(n, m);

			System.out.println("#" + t + " " + ans);
		}
	}

	private static int countBeans(int n, int m) {
		// TODO Auto-generated method stub
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) ans++;
			}
		}
		return ans;
	}

	private static void makeBeans(int n, int m) {
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					if (i - 2 >= 0)
						map[i - 2][j] = -1;
					if (i + 2 < n)
						map[i + 2][j] = -1;
					if (j - 2 >= 0)
						map[i][j - 2] = -1;
					if (j + 2 < m)
						map[i][j + 2] = -1;
				}
			}
		}
	}

}
