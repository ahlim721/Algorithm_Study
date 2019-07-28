package swexpert;

import java.util.Scanner;

public class Solution_1873_상호의배틀필드_임현아 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static char[] ds = {'<', '>', '^', 'v'};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			// 0 : 전차의 x좌표, 1 : 전차의 y좌표, 2 : 전차의 방향
			int[] tank = new int[3]; 

			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] map = new char[h][w];
			
			// map정보 저장 및 현재 탱크 위치와 상태 저장.
			for(int i=0; i<h; i++) {
				String s = sc.next();
				for(int j=0; j<s.length(); j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						tank[0] = i;
						tank[1] = j;
						for(int k=0; k<4; k++) {
							if(map[i][j] == ds[k]) tank[2] = k;
						}
						map[i][j] = '.';
					}
				}
			}
			
			// 명령어의 개수 입력
			int order = sc.nextInt();
			String oList = sc.next();

			// 포탄이 날라갈 위치 저장.
			int locX = tank[0];
			int locY = tank[1];
			// 명령 순회
			
			for(int i=0; i<order; i++) {
				char c = oList.charAt(i);
				if(c == 'S') {
					do {
						locX += dx[tank[2]];
						locY += dy[tank[2]];
					} while(locX >=0 && locY >=0 && locX < h && locY < w && map[locX][locY] != '*' && map[locX][locY] != '#');
					
					
					if(locX >=0 && locY >=0 && locX < h && locY < w) {
						if(map[locX][locY] == '*') map[locX][locY] = '.';
						if(map[locX][locY] == '#') {
							locX -= dx[tank[2]];
							locY -= dy[tank[2]];
						}
					}
				} else {
					if(c == 'L') tank[2] = 0;
					if(c == 'R') tank[2] = 1;
					if(c == 'U') tank[2] = 2;
					if(c == 'D') tank[2] = 3;
					locX = tank[0]+dx[tank[2]];
					locY = tank[1]+dy[tank[2]];
					if(locX >=0 && locY >=0 && locX < h && locY < w) {
						if(map[locX][locY] == '.') {
							tank[0] = locX;
							tank[1] = locY;
						}
					}
					locX = tank[0];
					locY = tank[1];
				}
			}
			
			map[tank[0]][tank[1]] = ds[tank[2]];
			
			System.out.print("#" + t + " ");
			for(int i=0; i<h; i++) {
				System.out.println(map[i]);
			}
		}
	}

}
