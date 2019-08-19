package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2631_줄세우기 {

	/* 정보 입력 */
	private static int n;
	private static int[] koi;
	
	/* i를 표함한 LIS(최장 증가 수열)의 크기 */
	private static int[] lis;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		koi = new int [n];
		for(int i=0; i<n; i++) {
			koi[i] = Integer.parseInt(br.readLine());
		}
				
		int max = 0;
		
		lis = new int [n];
		for(int i=n-1; i>=0; i--) {
			if(lis[i] == 0) { // 등록된 증가 수열이 없다면
				getLIS(i);
			}
			
			max = max < lis[i] ? lis[i] : max;
		}
		
		System.out.println(n - max);
		
	}

	private static void getLIS(int i) {
		int max = 0;
		for(int a=i-1; a>=0; a--) {

			// a가 증가 수열에 포함될 수 있다면.
			if(koi[a] < koi[i]) { 
			
				if(lis[a] == 0) {
					getLIS(a);
				}
				
				max = max < lis[a] ? lis[a] : max;
				
			}
			
		}
		
		lis[i] = 1 + max;
	}

	
}
