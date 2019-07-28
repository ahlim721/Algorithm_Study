package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[] vt = new int[v+1];
		int[][] ed = new int[e][3];
		for (int i = 0; i < e; i++) {
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
		
		makeSet(vt);
		
		int cnt = 1;
		int sum = 0;
		for(int i=0; i<e; i++) {
			if(getSet(vt, ed[i][0]) != getSet(vt, ed[i][1])) {
				sum += ed[i][2];
				union(vt, ed[i][0], ed[i][1]);
				cnt++;
			}
			if(cnt >= v) break;
		}
		System.out.println(sum);
	}

	private static void union(int[] vt, int i, int j) {
		// TODO Auto-generated method stub
		int x = getSet(vt, i);
		int y = getSet(vt, j);
		if(x > y) vt[x] = y;
		else vt[y] = x;
	}

	private static int getSet(int[] vt, int i) {
		// TODO Auto-generated method stub
		if(vt[i] != i) {
			vt[i] = getSet(vt, vt[i]);
		}
		return vt[i];
	}

	private static void makeSet(int[] vt) {
		// TODO Auto-generated method stub
		for(int i=0; i<vt.length; i++) {
			vt[i] = i;
		}
	}

}
