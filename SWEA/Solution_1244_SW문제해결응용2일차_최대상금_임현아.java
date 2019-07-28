package com.hw;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1244_SW문제해결응용2일차_최대상금_임현아 {
	
	public static void print(int t, int[] arr) {
		System.out.print("#"+t+" ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<= tc; t++) {
			String num = sc.next();
			int cnt = sc.nextInt();
			int[] reward = new int[num.length()];
			int[][] check = new int[10][cnt+1];
			for(int i=0; i<num.length(); i++) {
				reward[i] = num.charAt(i) - '0';
			}
			
			int swap = 0;
			int ccc = cnt;
			for(int i = 0; i<reward.length; i++) {
				if(ccc==0) break;
				int max = reward.length-1;
				for(int j=reward.length-1; j>=i; j--) {
					if(reward[j] > reward[max]) max = j;
				}
				if(max == i) continue;
				
				int tmp = reward[max];
				reward[max] = reward[i];
				reward[i] = tmp;
				check[tmp][check[tmp][cnt]] = max;
				check[tmp][cnt] += 1;
				ccc--;
			}
			
			for(int i=0; i<10; i++) {
				if(check[i][cnt] == 0) continue;
				else {
					int[] tmp = new int[check[i][cnt]];
					for(int j=0; j<check[i][cnt]; j++) {
						tmp[j] = reward[check[i][j]];
					}
					Arrays.sort(tmp);
					for(int j=0; j<check[i][cnt]; j++) {
						reward[check[i][j]] = tmp[j];
					}
				}
			}
			
			if((ccc%=2) != 0) {
				boolean flag = true;
				for(int i=1; i<10; i++) {
					if(check[i][cnt] > 1) {
						flag = false;
					}
				}
				if (flag) {
					int tmp = reward[reward.length - 1];
					reward[reward.length - 1] = reward[reward.length - 2];
					reward[reward.length - 2] = tmp;
				}
			}
			
			print(t, reward);

		}
	}
	
}
