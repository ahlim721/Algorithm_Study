package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main1976 {
	
	static int[] city;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		city = new int [n+1];
		for(int i=1; i<=n; i++) {
			makeSet(i);
		}
		int m = sc.nextInt();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int k = sc.nextInt();
				if(k == 1) { // 연결되어잇다.
					union(i, j);
				}
			}
		}
		
		int canGo = findSet(sc.nextInt());
		boolean go = true;
		for(int i=1; i<m; i++) {
			if(canGo != findSet(sc.nextInt())) {
				go = false;
			}
		}
		
		if(go) System.out.println("YES");
		else System.out.println("NO");

	}
	
	public static void makeSet(int i) {
		city[i] = i;
	}
	
	public static int findSet(int i) {
		if(i != city[i]) {
			city[i] = findSet(city[i]);
		}
		return city[i];
	}
	
	public static void union(int i, int j) {
		int x = findSet(i);
		int y = findSet(j);
		
		if(x != y) {
			if(x > y) {
				city[x] = y;
			} else {
				city[y] = x;
			}
		}
	}

}
