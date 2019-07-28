package swexpert;

import java.util.Scanner;

public class Solution2806 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			if(n == 1) {
				System.out.println("#" + t + " 1");
				continue;
			} else if (n == 2 || n == 3){
				System.out.println("#" + t + " 0");
				continue;
			} else {
				int[][] chase = new int[n][n];
				for(int i=0; i<n; i++) {
					
				}
				
				
			}
		}
		sc.close();
	}

}
