package com.ws;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1247_SW�����ذ�����3����_�������_������ {
	
	static int MIN = 300001;
	
	public static void backtrack(int[][] rot, int[] a, int k, int input) {

		int[] c = new int[a.length]; // a�� ���Ե��� �ʴ� �ĺ� �ε����� �����ϴ� �迭

		if (k == input) { // ���� ��Ʈ
			processSolution(rot, a, k); // ������ ����ϱ�
		} else { // ��� ��Ʈ
			int ncnads = makeCandidates(a, k, input, c); // �ĺ��� ����� ncnads - �ĺ��� ����
			for (int i = 0; i < ncnads; i++) {
				a[k] = c[i]; // ���� �ܰ迡 �ĺ��� �ϳ��� ����
				backtrack(rot, a, k + 1, input); // �����ܰ踦 �����ϵ��� k+1�ܰ踦 ���ȣ��
			}
		}
	}
	
	private static int makeCandidates(int[] a, int k, int n, int[] c) {
		// TODO Auto-generated method stub
		
		// ���� ���� a�� ���Ե� �ε����� �ľ��ϱ� ���� �迭 - ���� ��� false�� �ʱ�ȭ��. 
		boolean[] in_perm = new boolean[n + 1];

		// ���� a�� ���Ե� �ε��� ��ġ�� true�� ��ȯ.
		for (int i = 0; i < k; i++) {
			in_perm[a[i]] = true;
		}

		int ncands = 0; // �ĺ����� ����
		
		// in_perm�� ���, �ٸ� �迭�� ���� �ε����� ���� ������, 1���� ����.
		for (int i = 1; i <= n; i++) {
			if (in_perm[i] == false) {	// ����, a�� ���Ե��� �ʾҴٸ� �ĺ����̴�.
				c[ncands] = i;	// c �迭�� �ε��� ����. 
				ncands++;
			}
		}
		
		return ncands; // �ĺ��� ���� ��ȯ.
	}
	
	private static void processSolution(int[][] rot, int[] a, int k) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < k-1; i++) {
			sum += rot[a[i]][a[i+1]];
		}
		int start = rot[0][a[0]];
		int end = rot[rot.length-1][a[k-1]];
		sum = sum + start + end;
		if(MIN > sum) {
			MIN = sum;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			MIN = 300001;
			int n = sc.nextInt();
			int[][] clt = new int[n+2][2]; // ���� ����ǥ ����.
			int[][] rot = new int[n+2][n+2]; // ������ �Ÿ� ����.
			clt[0][0] = sc.nextInt(); // ȸ�� x��ǥ
			clt[0][1] = sc.nextInt(); // ȸ�� y��ǥ
			clt[n+1][0] = sc.nextInt(); // �� x��ǥ
			clt[n+1][1] = sc.nextInt(); // �� y��ǥ
			for(int i=1; i<n+1; i++) { // �� ����ǥ ����.
				clt[i][0] = sc.nextInt(); // ���� x��ǥ
				clt[i][1] = sc.nextInt(); // ���� y��ǥ
			}
			for(int i=0; i<n+2; i++) { // ������ �Ÿ� ����.
				for(int j=0; j<n+2; j++) {
					rot[i][j] = Math.abs(clt[i][0] - clt[j][0]) + Math.abs(clt[i][1] - clt[j][1]);
				}
			}
			int[] a = new int[n];
			backtrack(rot, a, 0, a.length);
			System.out.println("#" + t + " " + MIN);
		}
	}

}
