package acmicpc;

import java.util.Scanner;

// 나무가 심어져있고, 모든 간격을 같게 최소의 나무를 심는다.
// 각 나무의 간격의 최대공약수를 구하는 문제.
// 최대공약수는 간격의 최솟값의 약수이다.

public class Main_2485_가로수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int e = sc.nextInt();

		int min = e - s;
		int[] jump = new int[n - 1];
		for (int i = 0; i < n - 2; i++) {
			jump[i] = e - s;
			s = e;
			e = sc.nextInt();
			min = min < e - s ? lcd(e - s, min) : lcd(min, e - s);
		}
		jump[n - 2] = e - s;

		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			ans += (jump[i] / min - 1);
		}
		
		System.out.println(ans);
		
		sc.close();
	}

	// x > y
	public static int lcd(int x, int y) {
		if (x % y == 0)
			return y;
		else
			return lcd(y, x % y);
	}

}
