package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_5658_모의SW역량테스트_보물상자비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String tmp = br.readLine();
	
			// 한바퀴를 돌아야하므로, index를 관리하는 것보다 tmp를 두개를 연결해서 하는 것이 더 복잡하지 않다.
			String str = tmp + tmp;
	
			// 중복을 피하기 위한 방법.
			HashSet<String> hs = new HashSet<>();
			int start = 0;
			
			// 한바퀴를 다 돌았다면 밖으로 꺼내준다.
			while(start != n) {
				for(int i=start; i<start+n; i+=n/4) {
					hs.add(str.substring(i, i+n/4));
				}
				start++;
			}
			
			String[] a = new String[hs.size()];
			a = hs.toArray(a);
			
			// 어차피 아스키코드표 상으로, 알파벳이 더 크므로, String 상태로 정렬해도 상관없다.
			Arrays.sort(a);
			
			// 오름차순으로 정렬되었기 때문에 뒤에서 k번째 원소를 반환해준다.
			sb.append("#").append(t).append(" ").append(Long.parseLong(a[a.length - k], 16)).append("\n");
		}
		System.out.println(sb);
	}

}
