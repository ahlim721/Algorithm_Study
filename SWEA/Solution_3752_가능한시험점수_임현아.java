package swexpert;

import java.util.Scanner;

public class Solution_3752_가능한시험점수_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			boolean[] score = new boolean[10001];
			score[0] = true;
			int cnt = 1;
			int max = 0;
			for(int i=0; i<n; i++) {
				int input = sc.nextInt();
				for(int j=max; j>=0; j--) {
					if(score[j] && !score[j+input]) {
						score[j+input] = true;
						cnt++;
					}
				}
				max += input;
			}
			System.out.println(cnt);
		}
	}

}
