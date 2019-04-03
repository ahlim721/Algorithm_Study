package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발_임현아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] wbr = new int[n][3];
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					if(s.charAt(j) == 'W') wbr[i][0]--;
					else if(s.charAt(j) == 'B') wbr[i][1]--;
					else if(s.charAt(j) == 'R') wbr[i][2]--;
				}
				for(int j=0; j<3; j++) wbr[i][j] += m;
			}
			
			int[][] ans = new int[n][3];
			
			// 흰색이 올 수 있는 경우.
			ans[0][0] = wbr[0][0];
			for(int i=1; i<n-2; i++) {
				ans[i][0] = ans[i-1][0] + wbr[i][0];
			}
			
			// 파란색이 올 수 있는 경우.
			ans[1][1] = ans[0][0] + wbr[1][1];
			for(int i=2; i<n-1; i++) {
				ans[i][1] = (ans[i-1][0] < ans[i-1][1] ? ans[i-1][0] : ans[i-1][1]) + wbr[i][1];
			}
			
			// 빨간색이 올 수 있는 경우.
			ans[2][2] = ans[1][1] + wbr[2][2];
			for(int i=3; i<n; i++) {
				ans[i][2] = (ans[i-1][1] < ans[i-1][2] ? ans[i-1][1] : ans[i-1][2]) + wbr[i][2];
			}
			
			sb.append("#").append(t).append(" ").append(ans[n-1][2]).append("\n");
		}
		System.out.print(sb);
	}

}
