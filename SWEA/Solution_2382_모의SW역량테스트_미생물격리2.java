import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2382_모의SW역량테스트_미생물격리2 {
	
	static class MicroCell {
		int x, y, cnt, dir;
		
		MicroCell(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			
			// 약품 처리를 초기화
			for(int i=0; i<n; i++) {
				map[0][i] = -1;
				map[i][0] = -1;
				map[n-1][i] = -1;
				map[i][n-1] = -1;
			}
			
			ArrayList<MicroCell> list = new ArrayList<>();
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				list.add(new MicroCell(x, y, cnt, dir));
				
				map[x][y] = cnt;
			}
						
			while(m != 0) {
				for(MicroCell mc : list) {
					moveCell(map, mc);
				}
				
				list.sort(new Comparator<MicroCell>() {
					@Override
					public int compare(MicroCell o1, MicroCell o2) {
						if(o1.x == o2.x && o1.y == o2.y) {
							return o2.cnt - o1.cnt;
						}
						else if(o1.x == o2.x) return o1.y - o2.y;
						else return o1.x - o2.x;
					}
				});
				
				ArrayList<MicroCell> tmp = new ArrayList<MicroCell>();
				for(MicroCell mc : list) {
					if(!tmp.isEmpty()) {
						if(tmp.get(tmp.size()-1).x == mc.x && tmp.get(tmp.size()-1).y == mc.y) {
							tmp.get(tmp.size()-1).cnt += mc.cnt;
						} else 
							tmp.add(mc);
					}
					else {
						tmp.add(mc);
					}
				}
				list = tmp;
		
				m--;
			}

			int ans = 0;
			for(MicroCell mm : list)
				ans += mm.cnt;
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	private static void moveCell(int[][] map, MicroCell mc) {
		mc.x += dx[mc.dir];
		mc.y += dy[mc.dir];
		if(mc.x == 0 || mc.y == 0 || mc.x == n-1 || mc.y == n-1) {
			mc.cnt /= 2;
			mc.dir = mc.dir == 1 ? 2 : mc.dir == 2 ? 1 : mc.dir == 3 ? 4 : 3;
		}
	}

}
