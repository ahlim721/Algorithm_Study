package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임_임현아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			String mode = st.nextToken();
			
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			map = move(map, mode);
			add(map, mode);
			map = move(map, mode);
			
			sb.append("#").append(t).append("\n");
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void add(int[][] map, String mode) {
		if(mode.equals("left")) {
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length-1; j++) {
					if(map[i][j] == map[i][j+1]) {
						map[i][j] += map[i][j+1];
						map[i][j+1] = 0;
					}
				}
			}
		} else if(mode.equals("right")) {
			for(int i=0; i<map.length; i++) {
				for(int j=map[i].length-1; j>0; j--) {
					if(map[i][j] == map[i][j-1]) {
						map[i][j] += map[i][j-1];
						map[i][j-1] = 0;
					}
				}
			}
		} else if(mode.equals("up")) {
			for(int i=0; i<map[0].length; i++) {
				for(int j=0; j<map.length-1; j++) {
					if(map[j][i] == map[j+1][i]) {
						map[j][i] += map[j+1][i];
						map[j+1][i] = 0;
					}
				}
			}
		} else if(mode.equals("down")) {
			for(int i=0; i<map[0].length; i++) {
				for(int j=map.length-1; j>0; j--) {
					if(map[j][i] == map[j-1][i]) {
						map[j][i] += map[j-1][i];
						map[j-1][i] = 0;
					}
				}
			}
		}
		
	}

	private static int[][] move(int[][] map, String mode) {
		int[][] ans = new int[map.length][map[0].length];
		if(mode.equals("left")) {
			for(int i=0; i<map.length; i++) {
				int loc = 0;
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j] != 0)
						ans[i][loc++] = map[i][j];
				}
			}
		} else if(mode.equals("right")) {
			for(int i=0; i<map.length; i++) {
				int loc = map[i].length-1;
				for(int j=map[i].length-1; j>=0; j--) {
					if(map[i][j] != 0) 
						ans[i][loc--] = map[i][j];
				}
			}
		} else if(mode.equals("up")) {
			for(int i=0; i<map[0].length; i++) {
				int loc = 0;
				for(int j=0; j<map.length; j++) {
					if(map[j][i] != 0) 
						ans[loc++][i] = map[j][i];
				}
			}
		} else if(mode.equals("down")) {
			for(int i=0; i<map[0].length; i++) {
				int loc = map.length-1;
				for(int j=map.length-1; j>=0; j--) {
					if(map[j][i] != 0) 
						ans[loc--][i] = map[j][i];
				}
			}
		}
		return ans;
	}

}
