package com.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 숫자 만들기 게임
 * 1. 시작 수는 자연수 1이상 99999이하의 수이다.       
 * 2. 시작 수의 사이를 터치하면 수는 두개 또는 그 이상으로 쪼개진다.                                               
 * 3. 쪼개진 수를 모두 곱한다.                                                                     
 * 4. 곱한 수가 10이상이면 2~3번을 반복한다.                                                           
 * 5. 한번 쪼개지면 turn 수가 증가 한다.                                                             
 * 6. 최대 턴수가 나오도록 한다.      
 * 123 은 -> 1 2 3, 12 3, 1 23 으로 쪼개질 수 있다.
 * - 1 2 3 일 때, 1*2*3 = 6 으로 1번
 * - 12 3 일 때, 12*3 = 36, 3*6 = 18, 1*8 = 8 으로 3번
 * - 1 23 일 때, 1*23 = 23, 2*3 = 6 으로 2번
 * ==> 결과는 3번이 나오면 된다.
 * 
 * 1ㅁ2ㅁ3ㅁ4ㅁ5 가 있다고 할 때, ㅁ에 1이 들어간 자리를 쪼갠다고 생각하자.
 * ㅁㅁㅁㅁ 이 0000부터 1111까지 만들어 질 수 있고, 그 때의 값을 사용하면 된다.
 * 
 */

public class Solution_7206_숫자게임_임현아 {

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
			return 0; // 쪼갤 수 없는 경우
		}
		String s = "" + n;
		int len = s.length() - 1; // 최대 쪼갤 수 있는 지점의 개수
		
		int max = 0;
		
		// Math.pow(2, len) == 1<<len 을 사용한다. Math를 굳이 부를 필요가 없음.
		for(int i = 1; i < 1<<len; i++) { // 쪼갤 수 있는 모든 경우를 나누자, 바이너리 카운팅을 이용.
			//System.out.printf("%4s : ", Integer.toBinaryString(i));
			int mul = 1;
			int num = s.charAt(0) - '0';
			for(int j=0; j<len; j++) { // 비트마스킹, 해당 비트가 1이면 쪼개고 0 이면 이어붙임
				if((i & 1<<j) == 0) { // i의 j번째자리가 0인지? ( 안쪼갬 )
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
