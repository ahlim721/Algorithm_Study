package day0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_모의SW역량테스트_숫자만들기_임현아 {

	private static int max;
	private static int min;
	private static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			int n = Integer.parseInt(br.readLine());
			
			int[] oper = new int[4];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) 
				oper[i] = Integer.parseInt(st.nextToken());
			
			num = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			dfs(oper, 1, n, num[0]);
			
			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[] oper, int idx, int n, int result) {
		if(idx == n) {
			max = max < result ? result : max;
			min = min > result ? result : min;
		}
		else {
			for(int i=0; i<4; i++) {
				if(oper[i] > 0) {
					oper[i]--;
					switch (i) {
					case 0: // '+'
						dfs(oper, idx + 1, n, result + num[idx]);
						break;
					case 1: // '-'
						dfs(oper, idx + 1, n, result - num[idx]);
						break;
					case 2: // '*'
						dfs(oper, idx + 1, n, result * num[idx]);
						break;
					case 3: // '/'
						dfs(oper, idx + 1, n, result / num[idx]);
						break;
					}
					oper[i]++;
				}
			}
		}
	}

}
