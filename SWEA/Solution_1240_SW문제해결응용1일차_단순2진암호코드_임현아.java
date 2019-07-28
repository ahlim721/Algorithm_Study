package com.ws;

import java.util.Scanner;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_임현아 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] code = {
				"0001101", "0011001", "0010011",
				"0111101", "0100011", "0110001",
				"0101111", "0111011", "0110111", "0001011"
		};
		
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			String input = "";
			for (int i = 0; i < n; i++) {
				String tmp = sc.next();
				if (tmp.contains("1"))
					input = tmp;
			}
			
			int o=0, p=0, cnt=0;
			for (int i = m-1; i >= 0; i--) {
				if(input.charAt(i) == '0') continue;
				String tmp = "";
				try {
					tmp = input.substring(i-6, i + 1);
				} catch(StringIndexOutOfBoundsException e) {
					break;
				}
				for (int j = 0; j < code.length; j++) {
					if (tmp.equals(code[j])) {
						if(cnt%2 == 0)
							p += j;
						else
							o += j;
						cnt++;
						i -= 6;
					}
				}
				if(cnt == 8) break;
			}
			System.out.print("#" + t + " ");
			if((o*3+p)%10 == 0) System.out.println(o+p);
			else System.out.println(0);
		}
		sc.close();
	}
}
