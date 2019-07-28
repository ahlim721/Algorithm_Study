package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main10972 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		boolean flag = true;
		for(int i=n-1; i>0; i--) {
			if(arr[i] > arr[i-1]) {
				int min = i-1;
				for(int j=n-1; j>=i; j--) {
					if(arr[j] < arr[i-1]) continue;
					else {
						min = j; break;
					}
				}
				int tmp = arr[min];
				arr[min] = arr[i-1];
				arr[i-1] = tmp;
				Arrays.sort(arr, i, n);
				flag = false;
				break;
			}
		}
		if(flag) System.out.println("-1");
		else {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}

}
