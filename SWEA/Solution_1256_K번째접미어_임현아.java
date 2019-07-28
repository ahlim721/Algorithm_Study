package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1256_K번째접미어_임현아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] ss = new String[str.length()];
			for(int i=0; i<str.length(); i++) {
				ss[i] = str.substring(i, str.length());
			}
			Arrays.sort(ss);
			System.out.println("#" + t + " " + ss[n-1]);
		}
	}

}
