package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1239_비밀편지_임현아 {

	static String[] A = {"000000", "000001", "000010", "000100", "001000", "010000", "100000"};
	static String[] B = {"001111", "001110", "001101", "001011", "000111", "011111", "101111"};
	static String[] C = {"010011", "010010", "010001", "010111", "011011", "000011", "110011"};
	static String[] D = {"011100", "011101", "011110", "011000", "010100", "001100", "111100"};
	static String[] E = {"100110", "100111", "100100", "100010", "101110", "110110", "000110"};
	static String[] F = {"101001", "101000", "101011", "101101", "100001", "111001", "001001"};
	static String[] G = {"110101", "110100", "110111", "110001", "111101", "100101", "010101"};
	static String[] H = {"111010", "111011", "111000", "111110", "110010", "101010", "011010"};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		String[] word = new String[n];
		for(int i=0; i<n; i++) {
			word[i] = s.substring(i*6, i*6+6);
			
			char ans = isThere(word[i]);
			if(ans == '*') {
				System.out.println(i+1);
				return;
			} else {
				sb.append(ans);
			}
		}
		System.out.println(sb);
	}

	private static char isThere(String string) {
		// TODO Auto-generated method stub
		for(int i=0; i<7; i++) {
			if(A[i].equals(string)) return 'A';
		}
		for(int i=0; i<7; i++) {
			if(B[i].equals(string)) return 'B';
		}
		for(int i=0; i<7; i++) {
			if(C[i].equals(string)) return 'C';
		}
		for(int i=0; i<7; i++) {
			if(D[i].equals(string)) return 'D';
		}
		for(int i=0; i<7; i++) {
			if(E[i].equals(string)) return 'E';
		}
		for(int i=0; i<7; i++) {
			if(F[i].equals(string)) return 'F';
		}
		for(int i=0; i<7; i++) {
			if(G[i].equals(string)) return 'G';
		}
		for(int i=0; i<7; i++) {
			if(H[i].equals(string)) return 'H';
		}
		return '*';
	}
	
	

}
