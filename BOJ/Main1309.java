package acmicpc;

import java.util.Scanner;

public class Main1309 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int zoo[][] = new int[n+1][3];
		zoo[1][0] = 1; // n=1���� ���� �츮�� ���ڰ� ���� ����� ��
		zoo[1][1] = 1; // n=2���� ��� �츮�� ���ڰ� ���� ����� ��
		zoo[1][2] = 1; // n=3���� ������ �츮�� ���ڰ� ���� ����� ��
		
		
		for(int i=2; i<=n; i++) {
			zoo[i][0] = (zoo[i-1][1] + zoo[i-1][2])%9901;
			zoo[i][1] = (zoo[i-1][0] + zoo[i-1][1] + zoo[i-1][2])%9901;
			zoo[i][2] = (zoo[i-1][0] + zoo[i-1][1])%9901;
		}
		
		System.out.println((zoo[n][0]+zoo[n][1]+zoo[n][2])%9901);
		
		sc.close();
	}

}
