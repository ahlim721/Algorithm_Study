package ws;

import java.util.Scanner;

public class Solution_3143_가장빠른문자열타이핑_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String a = sc.next();
			String b = sc.next();

			int typing = 0;
			for (int i = 0; i < a.length();) {
				int len = compare(a, b, i);
				if(len == 0) len++;
				i += len;
				typing += len == b.length() ? 1 : len;
			}
			
			sb.append("#").append(t).append(" ").append(typing).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	private static int compare(String a, String b, int x) {
		// TODO Auto-generated method stub
		int i = 0;

		for (i = 0; i < b.length(); i++) {
			if (x + i >= a.length() || a.charAt(x + i) != b.charAt(i)) {
				break;
			}
		}

		return i;
	}

}
