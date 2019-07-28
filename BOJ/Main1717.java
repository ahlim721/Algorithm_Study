package acmicpc;

import java.util.Scanner;

public class Main1717 {
	
	static int[] set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ����
		
		// ������ ����
		set = new int[n+1];
		for(int i=0; i<=n; i++) {
			makeSet(i);
		}
		
		int m = sc.nextInt(); // ������ ����
		// �������� 0, ���� ���������� 1
		for(int i=0; i<m; i++) {
			int oper = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(oper == 0) { // ������
				union(a, b);
			} else { // ���� �����ΰ�?
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
