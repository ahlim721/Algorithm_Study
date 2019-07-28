package acmicpc;

import java.util.Scanner;

public class Main1717 {
	
	static int[] set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 집합의 개수
		
		// 집합을 생성
		set = new int[n+1];
		for(int i=0; i<=n; i++) {
			makeSet(i);
		}
		
		int m = sc.nextInt(); // 연산의 개수
		// 합집합은 0, 같은 집합인지는 1
		for(int i=0; i<m; i++) {
			int oper = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(oper == 0) { // 합집합
				union(a, b);
			} else { // 같은 집합인가?
				if(findSet(a) == findSet(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		
		
	}
	
	public static void makeSet(int i) {
		set[i] = i;
	}
	
	public static int findSet(int i) {
		if(i != set[i]) {
			set[i] = findSet(set[i]);
		}
		return set[i];
	}
	
	public static void union(int i, int j) {
		int x = findSet(i);
		int y = findSet(j);
		
		if(x != y) {
			if(x > y) {
				set[x] = y;
			} else {
				set[y] = x;
			}
		}
	}

}
