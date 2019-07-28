package com.ws;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_3124_�ּҽ��д�Ʈ��_������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			int[] vt = new int[v+1];
			// makeSet
			for(int i=1; i<=v; i++) {
				vt[i] = i;
			}
			
			int[][] ed = new int[e][3];
			
			for(int i=0; i<e; i++) {
				ed[i][0] = sc.nextInt();
				ed[i][1] = sc.nextInt();
				ed[i][2] = sc.nextInt();
			}
			
			Arrays.sort(ed, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2]-o2[2];
				}
			});
			
			int cnt = 0;
			long sum = 0;
			for(int i=0; i<ed.length; i++) {
				if(findSet(vt, ed[i][0]) != findSet(vt, ed[i][1])) {
					union(vt, ed[i][0], ed[i][1]);
					cnt++;
					sum+=ed[i][2];
				}
				if(cnt == v-1) break;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
	public static int findSet(int[] p, int x) {
		if (x == p[x]) return x;
		
		else {
			p[x] = findSet(p, p[x]); // Path Compression ���
			//rank[x] = 1; // �� �ʿ䰡 ����. ��ǥ���� ����(��ũ)�� �˸�ȴ�. ��������
			return p[x];
		}
	}

	public static void union(int[] p, int x, int y) {
		int px = findSet(p, x); // x�� ��ǥ�� �˾ƿ���
		int py = findSet(p, y); // y�� ��ǥ�� �˾ƿ���

		if (px != py) {// ���� �ٸ� ������ ���� ��ģ��.
			p[py] = px;
		}
	}

}
