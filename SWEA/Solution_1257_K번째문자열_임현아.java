package com.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_1257_K번째문자열_임현아 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Integer[] sLoc = new Integer[str.length()];
			for(int i=0; i<sLoc.length; i++) {
				sLoc[i] = i;
			}
			Arrays.sort(sLoc, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return str.substring(o1, str.length()).compareTo(str.substring(o2, str.length()));
				}
			});
			
			HashSet<String> hs = new HashSet<>();
			loop:
			for(int i=0; i<sLoc.length; i++) {
				for(int j=sLoc[i]+1; j<=sLoc.length; j++) {
					String tmp = str.substring(sLoc[i], j);
					if(!hs.contains(tmp)) {
						hs.add(str.substring(sLoc[i], j));
						n--;
					}
					if(n == 0) {
						System.out.println("#" + t + " " + tmp);
						break loop;
					}
				}
			}
			if(n > 0) System.out.println("#" + t + " " + "none");
			
		}
	}

}
