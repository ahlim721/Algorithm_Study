package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_5658_����SW�����׽�Ʈ_�������ں�й�ȣ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String tmp = br.readLine();
	
			// �ѹ����� ���ƾ��ϹǷ�, index�� �����ϴ� �ͺ��� tmp�� �ΰ��� �����ؼ� �ϴ� ���� �� �������� �ʴ�.
			String str = tmp + tmp;
	
			// �ߺ��� ���ϱ� ���� ���.
			HashSet<String> hs = new HashSet<>();
			int start = 0;
			
			// �ѹ����� �� ���Ҵٸ� ������ �����ش�.
			while(start != n) {
				for(int i=start; i<start+n; i+=n/4) {
					hs.add(str.substring(i, i+n/4));
				}
				start++;
			}
			
			String[] a = new String[hs.size()];
			a = hs.toArray(a);
			
			// ������ �ƽ�Ű�ڵ�ǥ ������, ���ĺ��� �� ũ�Ƿ�, String ���·� �����ص� �������.
			Arrays.sort(a);
			
			// ������������ ���ĵǾ��� ������ �ڿ��� k��° ���Ҹ� ��ȯ���ش�.
			sb.append("#").append(t).append(" ").append(Long.parseLong(a[a.length - k], 16)).append("\n");
		}
		System.out.println(sb);
	}

}
