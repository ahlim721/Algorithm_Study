package acmicpc;

import java.util.Scanner;

public class Main11060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] memo = new int[n+1];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if(arr[i] == 0 && memo[i+1] == 0) break;
			for (int j = 1; j <= arr[i]; j++) {
				if (i + j >= n) break;
				if (memo[i + j] > memo[i] + 1 || memo[i + j] == 0)
					memo[i + j] = memo[i] + 1;
			}
		}
		if(n == 1) System.out.println("0");
		else {
			if(memo[n-1] == 0) System.out.println(-1);
			else System.out.println(memo[n-1]);
		}
	}

}
