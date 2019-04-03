package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4672_수진이의팰린드롬_임현아 {
	
	/* 'abccb' 으로 A라는 팰린드롬을 만들었을 때,
	 * a는 1개, b는 2개, c는 2개를 갖는다.
	 * 1 => 1 ('a')
	 * 2 => 1 ('bb')가 포함된 팰린드롬, + 2 ('b')
	 * 2 => 1 ('cc')가 포함된 팰린드롬, + 2 ('c')
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int[] alpha = new int[26];
			String s = br.readLine();
			
			// 각 자리의 알파벳의 개수를 센다.
			for(int i=0; i<s.length(); i++) {
				alpha[s.charAt(i) - 'a']++;
			}
			
			int ans = 0;
			for(int i=0; i<alpha.length; i++) {
				int mul = 0;
				// 각각의 알파벳에 대하여, (alpha[i]-j+1)개의 알파벳이 포함된 팰린드롬의 개수를 세어준다.
				for(int j=1; j<=alpha[i]; j++) {
					mul += j;
				}
				ans += mul;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
