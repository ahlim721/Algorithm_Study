package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10216 {
	
	//len = Math.sqrt(Math.pow(info[i][0]-info[j][0], 2) + Math.pow(info[i][1]-info[j][1],2));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine()); // 통신탑의 개수
			int[][] info = new int[n][3];
			for(int i=0; i<n; i++) {
				String[] s = br.readLine().split(" ");
				info[i][0] = Integer.parseInt(s[0]); // 통신탑 x좌표
				info[i][1] = Integer.parseInt(s[1]); // 통신탑 y좌표
				info[i][2] = Integer.parseInt(s[2]); // 통신탑 r값
			}
			boolean[] visit = new boolean[n]; // 방문했는지를 체크.
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(!visit[i]) {
					dps(info, visit, i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dps(int[][] info, boolean[] visit, int loc) {
		// TODO Auto-generated method stub
		visit[loc] = true;
		for(int i=0; i<info.length; i++) {
			if(!visit[i]) {
				double len = Math.sqrt(Math.pow(info[loc][0]-info[i][0], 2) + Math.pow(info[loc][1]-info[i][1],2));
				if(len <= info[loc][2] + info[i][2])
					dps(info, visit, i);
			}
		}
	}

}
