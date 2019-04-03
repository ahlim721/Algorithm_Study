package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_모의SW역량테스트_수영장 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] fee = new int[4];
			for(int i=0; i<4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[][] use = new int[2][18];
			for(int i=3; i<15; i++) {
				use[0][i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=3; i<18; i++) {
				use[1][i] = use[1][i-1] + use[0][i]*fee[0];
				use[1][i] = use[1][i] > use[1][i-1] + fee[1] ? use[1][i-1] + fee[1] : use[1][i];
				use[1][i] = use[1][i] > use[1][i-3] + fee[2] ? use[1][i-3] + fee[2] : use[1][i];
				use[1][i] = use[1][i] > fee[3] ? fee[3] : use[1][i];
			}
			
			int ans = use[1][17];
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
