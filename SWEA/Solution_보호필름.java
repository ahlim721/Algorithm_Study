package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_보호필름 {
	
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] film = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					film[i][j] = Integer.parseInt(st.nextToken());
			}

			int[] medi = new int[d];
			Arrays.fill(medi, -1);
			
			ans = Integer.MAX_VALUE;
			getAnswer(medi, film, 0, d, k);
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void getAnswer(int[] medi, int[][] film, int color, int d, int k) {
		boolean isVerified = verify(film, medi, k);
		if(isVerified) {
			int cnt = getMediCount(medi, d);
			ans = ans > cnt ? cnt : ans;
		} else if (color == d) {
			return;
		} else {
			medi[color] = 0;
			getAnswer(medi, film, color + 1, d, k);
			
			medi[color] = 1;
			getAnswer(medi, film, color + 1, d, k);
			
			medi[color] = -1;
			getAnswer(medi, film, color + 1, d, k);
		}
	}

	private static int getMediCount(int[] tmp, int d) {
		int ans = 0;
		for(int i=0; i<d; i++)
			if(tmp[i] != -1)
				ans++;
		return ans;
	}

	private static boolean verify(int[][] film, int[] medi, int k) {

		for (int i = 0; i < film[0].length; i++) {
			int opt = -1;
			int len = 0;
			int maxLen = 0;
			for (int j = 0; j < film.length; j++) {
				int color = medi[j] == -1 ? film[j][i] : medi[j];
				if (color != opt) {
					if (len > maxLen)
						maxLen = len;
					opt = color;
					len = 1;
				} else {
					len++;
				}
			}
			if (len > maxLen)
				maxLen = len;
			if (maxLen < k)
				return false;
		}

		return true;
	}

}
