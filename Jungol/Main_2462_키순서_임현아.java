package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2462_키순서_임현아 {

	private static int[][] a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(st.nextToken()); // 학생들 수, 2 <= n <= 500
		int m = Integer.parseInt(st.nextToken()); // 비교 횟수, 2 <= m <= n*(n-1)/2

		a = new int[n + 1][n + 1]; // 1~n 정점만 활용. 인접행렬

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			a[small][tall] = 1; // 작은애 < 큰애
		}

		// 인접행렬에서 사용하지 않은 0번칸을 flag로 사용한다.
		// 해당 칸에서의 부모의 개수를 넣어놓는다.
		for (int i = 1; i < a.length; i++) {
			a[i][0] = -1;
			a[0][i] = -1;
		}

		int totalN = 0; // 순서를 정확히 알게되는 학생의 수
		for (int i = 1; i < a.length; i++) {
			up(i); // dfs를 사용해 위쪽에 있는 애들만 순회
			down(i);
			
			if(a[i][0] + a[0][i] == n-1) {
				totalN++;
			}
		}
		
		System.out.println(totalN);
	}

	private static void down(int v) {
		// TODO Auto-generated method stub
		if(a[0][v] != -1) { // 현재 저장이 되어있는 상태이면
			return;
		}
		
		// 현재 v정점의 자식이 누구인지를 인접행렬에 저장.
		for(int i=1; i<a.length; i++) {
			if(a[i][v] == 1) {
				up(i); // 나보다 작은 애들을 탐색
				for(int j=1; j<a.length; j++) { // i의 자식들을 v의 자식이라고 체크
					a[j][v] |= a[j][i];
				}
			}
		}
		
		// 인접행렬의 0번째 칸은 v정점의 부모의 개수 몇 개인지 저장해두자.
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += a[i][v];
		}
		a[0][v] = sum;
	}

	private static void up(int v) {
		// TODO Auto-generated method stub
		if(a[v][0] != -1) { // 현재 저장이 되어있는 상태이면
			return;
		}
		
		// 현재 v정점의 부모가 누구인지를 인접행렬에 저장.
		for(int i=1; i<a.length; i++) {
			if(a[v][i] == 1) {
				up(i); // 나보다 큰 애들을 탐색
				for(int j=1; j<a.length; j++) { // i의 부모들을 v의 부모라고 체크
					a[v][j] |= a[i][j];
				}
			}
		}
		
		// 인접행렬의 0번째 칸은 v정점의 부모의 개수 몇 개인지 저장해두자.
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += a[v][i];
		}
		a[v][0] = sum;
	}

}
