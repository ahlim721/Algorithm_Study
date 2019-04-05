package day0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_임현아 {

	static int[] p; // 부모를 저장할 배열
	static int[] rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			p = new int[n+1];
			rank = new int[n+1];
			makeSet();

			String ans = "";
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				switch (oper) {
				case 0:
					union(a, b);
					break;
				case 1:
					if(findSet(a) == findSet(b))
						ans += 1;
					else
						ans += 0;
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	public static void makeSet() {
		for(int i=0; i<p.length; i++) {
			p[i] = i; // 부모 : 자신의 index로 표시 or -1;
		}
	}
	
	public static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]); // Path Compression 기법
		}
		return p[x];
	}
	
	public static void union(int x, int y) {
		int px = findSet(x); // x의 대표자 알아오기
		int py = findSet(y); // y의 대표자 알아오기
		
		if(px != py) {// 서로 다른 집합일 때만 합친다. 
			link(px, py);
		}
	}

	/* x의 대표자의 집합과 y의 대표자의 집합을 합침. rank도 맞춤 */
	public static void link(int px, int py) {
		// TODO Auto-generated method stub
		if(rank[px] > rank[py]) { // 작은 쪽을 큰 쪽에 붙인다.
			p[py] = px; 
		} else {
			p[px] = py;
			if(rank[px] == rank[py]) { // 같은 경우는 rank값이 증가한다.
				rank[py]++; // 집합의 대표자 rank가 증가한다.
			}
		}
	}


}
