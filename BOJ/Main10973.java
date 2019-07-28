package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main10973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}

		boolean flag = true;
		for(int i=n-1; i>0; i--) {
			if(arr[i-1] > arr[i]) {
				for(int j=i; j<=n; j++) {
					if(j == n || arr[i-1] < arr[j]) {
						int temp = arr[j-1];
						arr[j-1] = arr[i-1];
						arr[i-1] = temp;
						flag = false;
						break;
					}
				}
				if (!flag) {
					Arrays.sort(arr, i, n, new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							// TODO Auto-generated method stub
							return o2 - o1;
						}
					});
					break;
				}
			}
		}
		if(flag) System.out.println(-1);
		else {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
