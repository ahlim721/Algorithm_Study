package jungol;

import java.util.Scanner;

/*
 * 불 먼저 채우고, 지섭이를 이동
 */

public class Main_1082_화염에서탈출_임현아 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] forest = new char[r][c];
		int[] jisub = new int[3]; // 지섭이의 위치를 저장할 배열
		for(int i=0; i<r; i++) {
			String str = sc.next();
			for(int j=0; j<c; j++) {
				forest[i][j] = str.charAt(j);
				if(forest[i][j] == 'S') { // 지섭이일 경우, 위치저장
					jisub[0] = i; jisub[1] = j; jisub[2] = 1;
				}
			}
		}
		
		System.out.println(bfs(r, c, forest, jisub));
	}

	private static String bfs(int r, int c, char[][] forest, int[] jisub) {
		// TODO Auto-generated method stub
		// 지섭이의 위치를 담은 queue
		int[][] qJisub = new int[r*c+1][3];
		int fJisub = -1;
		int rJisub = -1;
		qJisub[++fJisub] = jisub;
		
		// 불의 위치를 담은 queue
		int[][] qFire = new int[r*c+1][3];
		int fFire = -1;
		int rFire = -1;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(forest[i][j] == '*') {
					qFire[++fFire][0] = i;
					qFire[fFire][1] = j;
				}
			}
		}
		int[] fire;
		
		int cnt = 0;
		while(fJisub != rJisub) {
			cnt++;
						
			// 불 뿌리기
			int tfFire = fFire;
			while (fFire != rFire) {
				fire = qFire[++rFire];
				for (int i = 0; i < 4; i++) {
					int rx = fire[0] + dx[i];
					int ry = fire[1] + dy[i];
					if (rx >= 0 && ry >= 0 && rx < r && ry < c && forest[rx][ry] != 'X' && forest[rx][ry] != 'D'
							&& forest[rx][ry] != '*') {
						forest[rx][ry] = '*';
						qFire[++tfFire][0] = rx;
						qFire[tfFire][1] = ry;
					}
				}
			}
			fFire = tfFire;
			
			int tfJisub = fJisub;
			while (fJisub != rJisub) {
				jisub = qJisub[++rJisub];
				for (int i = 0; i < 4; i++) {
					int rx = jisub[0] + dx[i];
					int ry = jisub[1] + dy[i];
					if (rx >= 0 && ry >= 0 && rx < r && ry < c && forest[rx][ry] != 'X' && forest[rx][ry] != '*'
							&& forest[rx][ry] != 'S') {
						if (forest[rx][ry] == 'D') {
							return cnt + "";
						}
						forest[rx][ry] = 'S';
						qJisub[++tfJisub][0] = rx;
						qJisub[tfJisub][1] = ry;
					}
				}
			}
			fJisub = tfJisub;
		}
		return "impossible";
	}
	
}


