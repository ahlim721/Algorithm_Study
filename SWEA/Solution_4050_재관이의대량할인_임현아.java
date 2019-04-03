package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인_임현아 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] clothes = new int[n];
			for (int i = 0; i < n; i++) {
				clothes[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(clothes);
			
			int price = 0;
			for (int i = n - 1; i >= 0; i--) {
				if((n-i) % 3 == 0) {
					continue;
				}
				else price += clothes[i];
			}
			
			sb.append("#").append(t).append(" ").append(price).append("\n");
		}
		System.out.print(sb);
	}
}
