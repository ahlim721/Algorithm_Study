package day0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_���μ�����_������ {

	static int[] p; // �θ� ������ �迭
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
			p[i] = i; // �θ� : �ڽ��� index�� ǥ�� or -1;
		}
	}
	
	public static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]); // Path Compression ���
		}
		return p[x];
	}
	
	public static void union(int x, int y) {
		int px = findSet(x); // x�� ��ǥ�� �˾ƿ���
		int py = findSet(y); // y�� ��ǥ�� �˾ƿ���
		
		if(px != py) {// ���� �ٸ� ������ ���� ��ģ��. 
			link(px, py);
		}
	}

	/* x�� ��ǥ���� ���հ� y�� ��ǥ���� ������ ��ħ. rank�� ���� */
	public static void link(int px, int py) {
		// TODO Auto-generated method stub
		if(rank[px] > rank[py]) { // ���� ���� ū �ʿ� ���δ�.
			p[py] = px; 
		} else {
			p[px] = py;
			if(rank[px] == rank[py]) { // ���� ���� rank���� �����Ѵ�.
				rank[py]++; // ������ ��ǥ�� rank�� �����Ѵ�.
			}
		}
	}


}
