package acmicpc;

import java.util.Scanner;

public class Main2003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum+=arr[j];
				if(sum == m) cnt++;
				if(sum > m) break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
