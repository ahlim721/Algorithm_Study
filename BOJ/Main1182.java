package acmicpc;

import java.util.Scanner;

public class Main1182 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int c = (int)Math.pow(2, n);
		int cnt = 0;
		for(int i=1; i<c; i++) {
			int sum = 0;
			String bin = Integer.toBinaryString(i);
			for(int j=0; j<bin.length(); j++) {
				sum+=arr[n-bin.length()+j]*(bin.charAt(j)-'0');
			}
			if(sum == s) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

}
