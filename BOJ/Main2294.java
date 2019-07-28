package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main2294 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		Arrays.sort(coin);
		
		int[] cnt = new int[k+1];
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(cnt[j%coin[i]] == 0 && j%coin[i] != 0) continue;
				int tmp = j/coin[i] + cnt[j%coin[i]];
				if(cnt[j] == 0) cnt[j] = tmp;
				else {
					cnt[j] = cnt[j] < tmp ? cnt[j] : tmp;
				}
			}
		}
		if(cnt[k] == 0) System.out.println(-1);
		else System.out.println(cnt[k]);
	}

}
