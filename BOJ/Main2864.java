package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2864 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int minA = Integer.parseInt(s[0].replaceAll("6", "5"));
		int minB = Integer.parseInt(s[1].replaceAll("6", "5"));
		
		int maxA = Integer.parseInt(s[0].replaceAll("5", "6"));
		int maxB = Integer.parseInt(s[1].replaceAll("5", "6"));
		
		System.out.println((minA+minB) + " " + (maxA+maxB));
	}

}
