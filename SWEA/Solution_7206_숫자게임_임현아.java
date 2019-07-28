package com.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * ���� ����� ����
 * 1. ���� ���� �ڿ��� 1�̻� 99999������ ���̴�.       
 * 2. ���� ���� ���̸� ��ġ�ϸ� ���� �ΰ� �Ǵ� �� �̻����� �ɰ�����.                                               
 * 3. �ɰ��� ���� ��� ���Ѵ�.                                                                     
 * 4. ���� ���� 10�̻��̸� 2~3���� �ݺ��Ѵ�.                                                           
 * 5. �ѹ� �ɰ����� turn ���� ���� �Ѵ�.                                                             
 * 6. �ִ� �ϼ��� �������� �Ѵ�.      
 * 123 �� -> 1 2 3, 12 3, 1 23 ���� �ɰ��� �� �ִ�.
 * - 1 2 3 �� ��, 1*2*3 = 6 ���� 1��
 * - 12 3 �� ��, 12*3 = 36, 3*6 = 18, 1*8 = 8 ���� 3��
 * - 1 23 �� ��, 1*23 = 23, 2*3 = 6 ���� 2��
 * ==> ����� 3���� ������ �ȴ�.
 * 
 * 1��2��3��4��5 �� �ִٰ� �� ��, ���� 1�� �� �ڸ��� �ɰ��ٰ� ��������.
 * �������� �� 0000���� 1111���� ����� �� �� �ְ�, �� ���� ���� ����ϸ� �ȴ�.
 * 
 */

public class Solution_7206_���ڰ���_������ {

	static int[] memo = new int[100000];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		long time = System.currentTimeMillis();
		for(int t=1; t<=tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = f(N);
			System.out.println("#" + t + " " + count);
		}
		System.out.println((System.currentTimeMillis() - time) + "ms");
	}

	private static int f(int n) {
		// TODO Auto-generated method stub
		if(n < 10) {
			return 0; // �ɰ� �� ���� ���
		}
		String s = "" + n;
		int len = s.length() - 1; // �ִ� �ɰ� �� �ִ� ������ ����
		
		int max = 0;
		
		// Math.pow(2, len) == 1<<len �� ����Ѵ�. Math�� ���� �θ� �ʿ䰡 ����.
		for(int i = 1; i < 1<<len; i++) { // �ɰ� �� �ִ� ��� ��츦 ������, ���̳ʸ� ī������ �̿�.
			//System.out.printf("%4s : ", Integer.toBinaryString(i));
			int mul = 1;
			int num = s.charAt(0) - '0';
			for(int j=0; j<len; j++) { // ��Ʈ����ŷ, �ش� ��Ʈ�� 1�̸� �ɰ��� 0 �̸� �̾����
				if((i & 1<<j) == 0) { // i�� j��°�ڸ��� 0����? ( ���ɰ� )
					num = num * 10 + s.charAt(j+1) - '0';
				} else {
					mul *= num;
					//System.out.print(num + ",");
					num = s.charAt(j+1) - '0';
				}
			}
			mul *= num;
			//System.out.println(num + " " + mul);
			
			int cnt;
			if(memo[mul] != 0) cnt = memo[mul]; 
			else cnt = f(mul);
			if(max < cnt) max = cnt;
		}
		
		memo[n] = max + 1;
		
		return memo[n];
	}

}
