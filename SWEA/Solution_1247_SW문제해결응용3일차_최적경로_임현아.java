package com.ws;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1247_SW문제해결응용3일차_최적경로_임현아 {
	
	static int MIN = 300001;
	
	public static void backtrack(int[][] rot, int[] a, int k, int input) {

		int[] c = new int[a.length]; // a에 포함되지 않는 후보 인덱스를 저장하는 배열

		if (k == input) { // 종료 파트
			processSolution(rot, a, k); // 순열을 출력하기
		} else { // 재귀 파트
			int ncnads = makeCandidates(a, k, input, c); // 후보군 만들기 ncnads - 후보군 개수
			for (int i = 0; i < ncnads; i++) {
				a[k] = c[i]; // 현재 단계에 후보군 하나를 넣음
				backtrack(rot, a, k + 1, input); // 다음단계를 진행하도록 k+1단계를 재귀호출
			}
		}
	}
	
	private static int makeCandidates(int[] a, int k, int n, int[] c) {
		// TODO Auto-generated method stub
		
		// 현재 순열 a에 포함된 인덱스를 파악하기 위한 배열 - 먼저 모두 false로 초기화됨. 
		boolean[] in_perm = new boolean[n + 1];

		// 순열 a에 포함된 인덱스 위치를 true로 변환.
		for (int i = 0; i < k; i++) {
			in_perm[a[i]] = true;
		}

		int ncands = 0; // 후보군의 개수
		
		// in_perm의 경우, 다른 배열의 값을 인덱스로 보기 때문에, 1부터 진행.
		for (int i = 1; i <= n; i++) {
			if (in_perm[i] == false) {	// 만약, a에 포함되지 않았다면 후보군이다.
				c[ncands] = i;	// c 배열에 인덱스 저장. 
				ncands++;
			}
		}
		
		return ncands; // 후보군 개수 반환.
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
			int[][] clt = new int[n+2][2]; // 고객의 집좌표 저장.
			int[][] rot = new int[n+2][n+2]; // 고객간의 거리 저장.
			clt[0][0] = sc.nextInt(); // 회사 x좌표
			clt[0][1] = sc.nextInt(); // 회사 y좌표
			clt[n+1][0] = sc.nextInt(); // 집 x좌표
			clt[n+1][1] = sc.nextInt(); // 집 y좌표
			for(int i=1; i<n+1; i++) { // 고객 집좌표 저장.
				clt[i][0] = sc.nextInt(); // 고객의 x좌표
				clt[i][1] = sc.nextInt(); // 고객의 y좌표
			}
			for(int i=0; i<n+2; i++) { // 고객간의 거리 저장.
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
