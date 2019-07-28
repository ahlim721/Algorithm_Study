package acmicpc;

import java.util.Scanner;

public class Main1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int n = sc.nextInt();
		if(n==0) arr[0] = 1;
		while (n != 0) {
			arr[n % 10]++;
			n = n / 10;
		}
		arr[6] = (arr[6] + arr[9]) % 2 == 1 ? (arr[6] + arr[9]) / 2 + 1 : (arr[6] + arr[9]) / 2;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			max = max < arr[i] ? arr[i] : max;
		}
		System.out.println(max);
		sc.close();
	}
}
