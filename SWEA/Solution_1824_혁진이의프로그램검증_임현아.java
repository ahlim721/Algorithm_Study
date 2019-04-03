package ws;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1824_혁진이의프로그램검증_임현아 {

	static class Info {
		int x;
		int y;
		int mem;
		int dir;

		Info(int x, int y, int mem, int dir) {
			this.x = x;
			this.y = y;
			this.mem = mem;
			this.dir = dir;
		}
	}

	// 우, 하, 좌, 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][][][] isMark; // x, y, mem, dir

	static int r;
	static int c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			// map정보 입력
			r = sc.nextInt();
			c = sc.nextInt();
			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String s = sc.next().trim();
				for (int j = 0; j < c; j++)
					map[i][j] = s.charAt(j);
			}

			// map[x][y] 에서의 숫자가 반복되는 지를 체크.
			// 반복된다면 이미 그곳을 지나는 사이클이 생성된다.
			isMark = new boolean[r][c][16][4];

			String ans = bfs(map, 0, 0, 0, 0);

			//System.out.println(r + " " + c);
			System.out.println("#" + t + " " + ans);

		}
		sc.close();
	}

	private static String bfs(char[][] map, int x, int y, int mem, int dir) {
		// TODO Auto-generated method stub
		String ans = "NO";

		Queue<Info> oper = new LinkedList<>();
		oper.add(new Info(x, y, mem, dir));

		go: while (!oper.isEmpty()) {
			Info tmp = oper.poll();
			int memory = tmp.mem;
			int direct = tmp.dir;
			if (map[tmp.x][tmp.y] >= 48 && map[tmp.x][tmp.y] <= 57) { // 숫자일 경우
				memory = map[tmp.x][tmp.y] - '0';
			} else {
				switch (map[tmp.x][tmp.y]) {
				case '^':
					direct = 3;
					break;
				case 'v':
					direct = 1;
					break;
				case '<':
					direct = 2;
					break;
				case '>':
					direct = 0;
					break;
				case '|':
					direct = memory == 0 ? 1 : 3;
					break;
				case '_':
					direct = memory == 0 ? 0 : 2;
					break;
				case '+':
					if (memory == 15)
						memory = 0;
					else
						memory++;
					break;
				case '-':
					if (memory == 0)
						memory = 15;
					else
						memory--;
					break;
				case '@':
					ans = "YES";
					break go;
				}
			}
						
			if (isMark[tmp.x][tmp.y][memory][direct] == true) {
				continue;
			} else {
				isMark[tmp.x][tmp.y][memory][direct] = true;
			}

			if (map[tmp.x][tmp.y] == '?') {
				for (int i = 0; i < 4; i++) {
					oper.add(new Info((tmp.x + dx[i] + r) % r, (tmp.y + dy[i] + c) % c, memory, i));
				}
			} else {
				oper.add(new Info((tmp.x + dx[direct] + r) % r, (tmp.y + dy[direct] + c) % c, memory, direct));
			}
		}
		return ans;
	}

}
