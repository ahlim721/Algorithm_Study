package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_롤러코스터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=tc; t++) {
			ArrayList<int[]> rail = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				rail.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
//			rail.sort(new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					if(o2[0] * o1[1] + o2[1] > o1[0] * o2[1] + o1[1])
//						return 1;
//					return -1;
//				}
//			});
			
			rail.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					double op1 = ((double)o1[0] - 1 ) / (double)o1[1];
					double op2 = ((double)o2[0] - 1 ) / (double)o2[1];
					
					if(op2 - op1 > 0)
						return 1;
					return -1;
				}
				
			});
			
			long v = 1;
			for(int i=0; i<rail.size(); i++) {
				v = (((rail.get(i)[0] % 1000000007) * v) % 1000000007 + rail.get(i)[1]) % 1000000007;
			}
			v %= 1000000007;
			
			System.out.println("#" + t + " " + v);
		}
	}

}
