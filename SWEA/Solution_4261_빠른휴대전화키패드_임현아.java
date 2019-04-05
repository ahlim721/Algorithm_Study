package day0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4261_빠른휴대전화키패드_임현아 {

	static String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			String s = str[0];
			int n = Integer.parseInt(str[1]);

			int ans = 0;
			str = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				String dic = str[i];
				if (dic.length() == s.length()) {
					boolean flag = true;
					for (int j = 0; j < s.length(); j++) {
						if (!keypad[s.charAt(j) - '0'].contains(dic.charAt(j) + "")) {
							flag = false;
							break;
						}
					}
					if(flag) ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
