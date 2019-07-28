package acmicpc;

import java.util.Scanner;

public class Main2443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int starC = 2 * n - 1;

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < (starC - (2 * i - 1))/2; j++)
				System.out.print(" ");
			for (int j = 0; j < 2 * i - 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
