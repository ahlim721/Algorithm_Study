package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt(); // ȸ�� ���� �ð�
			arr[i][1] = sc.nextInt(); // ȸ�� ������ �ð�
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		int last=-1;
		int max=0;
		for(int i=0; i<n; i++) {
			if(last < arr[i][0]) {
				last = arr[i][1];
				max++;
			}
		}
		
		System.out.println(max);
	}

}
