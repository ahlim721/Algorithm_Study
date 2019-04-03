package ws;

import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] mountain = new int[n];

			for (int i = 0; i < n; i++) {
				mountain[i] = sc.nextInt();
			}

			int ans = 0;

			int up = 0;
			int down = 0;
			for (int i = 1; i < n; i++) {
				if (mountain[i] > mountain[i - 1]) { // 증가하는 부분이면
					if (down != 0) {
						ans += (up * down);
						up = 0;
						down = 0;
					}
					up++;
				} else {
					down++;
				}
			}
			if (up != 0 && down != 0) {
				ans += (up * down);
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
