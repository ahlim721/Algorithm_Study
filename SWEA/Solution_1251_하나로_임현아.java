package com.hw;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1251_하나로_임현아 {

	static final double Max = Double.MAX_VALUE;

	public static int getMin(boolean[] visit, double[] arr) {
		int minIdx = -1;
		double min = Max;
		for(int i=0; i<arr.length; i++) {
			if(!visit[i] && min > arr[i]) {
				minIdx = i;
				min = arr[i];
			}
		}
		return minIdx;
	}
	
	public static int getCost(boolean[] visit, int[][] vt, double[] tunel, int start, double sum) {
		int flag = -1;
		
		for(int i=0; i<tunel.length; i++) {
			if(visit[i]) continue;
			double len = Math.pow(vt[start][0]-vt[i][0], 2) + Math.pow(vt[start][1]-vt[i][1], 2);
			tunel[i] = tunel[i]+len < sum+tunel[i] ? tunel[i]+len : tunel[i]==0 ? tunel[i]+len : tunel[i];
			flag = 0;
		}
		
		if(flag == -1) return flag;
		return getMin(visit, tunel);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int v = sc.nextInt();
			int[][] vt = new int[v][2];
			for(int i=0; i<v; i++) {
				vt[i][0] = sc.nextInt();
			}
			for(int i=0; i<v; i++) {
				vt[i][1] = sc.nextInt();
			}
			double rate = sc.nextDouble();
			
			double[] tunel = new double[v];
			boolean[] visit = new boolean[v];
			int idx = 0;
			double sum=0;
			while(idx != -1) {
				sum+=tunel[idx];
				visit[idx] = true;
				System.out.println(Arrays.toString(visit));
				idx = getCost(visit, vt, tunel, idx, sum);
				System.out.println(Arrays.toString(tunel));
			}
			
			double min = -1;
			for(int i=0; i<v; i++) {
				if(tunel[i] > min) min = tunel[i];
			}
			
			System.out.println(min*rate);
		}
	}

}
