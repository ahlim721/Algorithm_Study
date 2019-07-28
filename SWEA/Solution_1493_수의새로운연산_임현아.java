package swexpert;

import java.util.Scanner;

public class Solution_1493_수의새로운연산_임현아 {
	
	static int[][] map = new int[301][301];
	static int[][] number = new int[1000000][2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map[1][1] = 1;
		for(int i=1; i<300; i++) {
			for(int j=1; j<300; j++) {
				number[map[i][j]][0] = i;
				number[map[i][j]][1] = j;
				if(map[i][j+1] == 0) {
					map[i][j+1] = map[i][j] + (i+j-1);
				}
				if(map[i+1][j] == 0) 
					map[i+1][j] = map[i][j] + (i+j);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int x = number[p][0] + number[q][0];
			int y = number[p][1] + number[q][1];
			System.out.println("#" + t + " " + map[x][y]);
		}
		
		sc.close();
		
	}

}
