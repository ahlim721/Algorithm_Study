package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17281_야구 {
	
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] base = new int[n][9];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				base[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] alloc = new boolean[9];
		int[] order = new int[9];
		
		// 순열 생성
		order[3] = 0;
		alloc[0] = true;
		for(int a=1; a<9; a++) {
			alloc[a] = true;
			order[0] = a;
			for(int b=1; b<9; b++) {
				if(alloc[b]) continue;
				alloc[b] = true;
				order[1] = b;
				for(int c=1; c<9; c++) {
					if(alloc[c]) continue;
					alloc[c] = true;
					order[2] = c;
					for(int d=1; d<9; d++) {
						if(alloc[d]) continue;
						alloc[d] = true;
						order[4] = d;
						for(int e=1; e<9; e++) {
							if(alloc[e]) continue;
							alloc[e] = true;
							order[5] = e;
							for(int f=1; f<9; f++) {
								if(alloc[f]) continue;
								alloc[f] = true;
								order[6] = f;
								for(int g=1; g<9; g++) {
									if(alloc[g]) continue;
									alloc[g] = true;
									order[7] = g;
									for(int h=1; h<9; h++) {
										if(alloc[h]) continue;
										alloc[h] = true;
										order[8] = h;
										// do something
										simulate(order, n, base);
										alloc[h] = false;
									}
									alloc[g] = false;
								}
								alloc[f] = false;
							}
							alloc[e] = false;
						}
						alloc[d] = false;
					}
					alloc[c] = false;
				}	
				alloc[b] = false;
			}
			alloc[a] = false;
		}
		
		System.out.println(max);
		
	}

	private static void simulate(int[] order, int n, int[][] base) {
		
		int score = 0;
		int idx = 0;
		
		// 이닝을 반복
		for(int i=0; i<n; i++) {
			int cntOfOut = 0;
			
			int[] ground = new int[4];
			int home = 0;
			while(cntOfOut != 3) {
				idx = (idx % 9);
				home = (home % 4);
				
				int player = base[i][order[idx]];
				
				if(player == 0) // 아웃
					cntOfOut++;
				else {
					for(int j=0; j<4; j++) {
						if(ground[j] != 0)
							ground[j] += player;
					}
					
					if(ground[home] >= 4) score++;
					ground[home] = player;
					
					for(int j=0; j<4; j++) {
						if(ground[j] >= 4) {
							score++;
							ground[j] = 0;
						}
					}
					home++;
				}
				
				idx++;
			}
		}
		
		if(max < score) {
			max = score;
		}
		
	}

}
