package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution_3378_스타일리쉬들여쓰기_임현아2 {

	static class rcs {
		int r, c, s;

		rcs(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t);
			LinkedList<rcs> RCS = new LinkedList<>();
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						RCS.add(new rcs(i, j, k));
					}
				}
			}

			String[] str = br.readLine().split(" ");
			int p = Integer.parseInt(str[0]);
			int q = Integer.parseInt(str[1]);

			int s = 0;
			int m = 0;
			int l = 0;

			for (int i = 0; i < p; i++) {
				String sen = br.readLine();
				int cntSpace = 0;
				int tmpS = s;
				int tmpM = m;
				int tmpL = l;
				boolean ifCnt = true;
				for (int j = 0; j < sen.length(); j++) {
					if (ifCnt && sen.charAt(j) == '.') {
						cntSpace++;
					} else {
						switch (sen.charAt(j)) {
						case '(':
							s++;
							break;
						case ')':
							s--;
							break;
						case '{':
							m++;
							break;
						case '}':
							m--;
							break;
						case '[':
							l++;
							break;
						case ']':
							l--;
							break;
						}
						ifCnt = false;
					}
				}
				if(tmpS == 0 && tmpM == 0 && tmpL == 0) continue;
				Iterator<rcs> it = RCS.iterator();
				while (it.hasNext()) {
					rcs tmp = it.next();
					if (tmp.r * tmpS + tmp.c * tmpM + tmp.s * tmpL != cntSpace)
						it.remove();
				}
				
			}
			if (RCS.size() == 0) {
				sb.append(" ").append(-1);
			} else {
				rcs tmp = RCS.get(0);
				s = 0;
				m = 0;
				l = 0;
				for (int i = 0; i < q; i++) {
					String sen = br.readLine();
					sb.append(" ").append(tmp.r * s + tmp.c * m + tmp.s * l);
					for (int j = 0; j < sen.length(); j++) {
						switch (sen.charAt(j)) {
						case '(':
							s++;
							break;
						case ')':
							s--;
							break;
						case '{':
							m++;
							break;
						case '}':
							m--;
							break;
						case '[':
							l++;
							break;
						case ']':
							l--;
							break;
						}
					}
				}
			}
			System.out.println(sb);
		}

	}
}
