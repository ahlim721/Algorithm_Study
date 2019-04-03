package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4672_���������Ӹ����_������ {
	
	/* 'abccb' ���� A��� �Ӹ������ ������� ��,
	 * a�� 1��, b�� 2��, c�� 2���� ���´�.
	 * 1 => 1 ('a')
	 * 2 => 1 ('bb')�� ���Ե� �Ӹ����, + 2 ('b')
	 * 2 => 1 ('cc')�� ���Ե� �Ӹ����, + 2 ('c')
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int[] alpha = new int[26];
			String s = br.readLine();
			
			// �� �ڸ��� ���ĺ��� ������ ����.
			for(int i=0; i<s.length(); i++) {
				alpha[s.charAt(i) - 'a']++;
			}
			
			int ans = 0;
			for(int i=0; i<alpha.length; i++) {
				int mul = 0;
				// ������ ���ĺ��� ���Ͽ�, (alpha[i]-j+1)���� ���ĺ��� ���Ե� �Ӹ������ ������ �����ش�.
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
