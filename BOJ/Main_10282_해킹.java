package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_10282_해킹 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]); // 컴퓨터 개수
			int d = Integer.parseInt(s[1]); // 의존성 개수
			int c = Integer.parseInt(s[2]); // 감염된 컴퓨터 번호

			ArrayList<ArrayList<int[]>> comp = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				comp.add(new ArrayList<>());
			}

			for (int i = 0; i < d; i++) {
				s = br.readLine().split(" ");
				int[] tmp = { Integer.parseInt(s[0]), Integer.parseInt(s[2]) };
				comp.get(Integer.parseInt(s[1])).add(tmp);
			}

			int[] infect = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				infect[i] = -1;
			}
			infect[c] = 0;

			boolean[] visit = new boolean[n + 1];

			int flag = c;
			while (flag != -1) {
				visit[flag] = true;

				for (int i = 0; i < comp.get(flag).size(); i++) {
					if (!visit[comp.get(flag).get(i)[0]]) { // 감염되는 시간이 있는 경우.
						if (infect[comp.get(flag).get(i)[0]] == -1) {
							infect[comp.get(flag).get(i)[0]] = infect[flag] + comp.get(flag).get(i)[1];
						} else {
							infect[comp.get(flag).get(i)[0]] = infect[flag]
									+ comp.get(flag).get(i)[1] > infect[comp.get(flag).get(i)[0]]
											? infect[comp.get(flag).get(i)[0]]
											: infect[flag] + comp.get(flag).get(i)[1];
						}
					}
				}

				int min = Integer.MAX_VALUE;
				int minIdx = -1;
				for (int i = 1; i <= n; i++) {
					if (!visit[i] && infect[i] != -1 && min >= infect[i]) {
						min = infect[i];
						minIdx = i;
					}
				}

				flag = minIdx;
			}

			int max = -1;
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (infect[i] == -1)
					continue;
				else {
					max = max < infect[i] ? infect[i] : max;
					cnt++;
				}
			}

			System.out.println(cnt + " " + max);
		}
	}

}
