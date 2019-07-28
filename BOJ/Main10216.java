package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10216 {
	
	//len = Math.sqrt(Math.pow(info[i][0]-info[j][0], 2) + Math.pow(info[i][1]-info[j][1],2));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� �Է�
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine()); // ���ž�� ����
			int[][] info = new int[n][3];
			for(int i=0; i<n; i++) {
				String[] s = br.readLine().split(" ");
				info[i][0] = Integer.parseInt(s[0]); // ���ž x��ǥ
				info[i][1] = Integer.parseInt(s[1]); // ���ž y��ǥ
				info[i][2] = Integer.parseInt(s[2]); // ���ž r��
			}
			boolean[] visit = new boolean[n]; // �湮�ߴ����� üũ.
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
