package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15486_퇴사2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 0 : days, 1 : pay, 2 : n 이전의 최대값
		int[][] schedule = new int[n + 1][3];
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			schedule[i][0] = Integer.parseInt(input[0]);
			schedule[i][1] = Integer.parseInt(input[1]);
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			if(schedule[i][2] > max)
				max = schedule[i][2];
			else 
				schedule[i][2] = max;
			
			int afterDay = i + schedule[i][0];
			if(afterDay <= n) {
				int pay = schedule[i][1] + schedule[i][2];
				if(schedule[afterDay][2] < pay)
					schedule[afterDay][2] = pay;
			}
		}
		
		int res = -1;
		for(int i=0; i<=n; i++) {
			if(schedule[i][2] > res)
				res = schedule[i][2];
		}
		
		System.out.println(res);
	}

}
