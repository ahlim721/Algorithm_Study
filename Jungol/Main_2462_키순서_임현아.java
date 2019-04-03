package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2462_Ű����_������ {

	private static int[][] a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(st.nextToken()); // �л��� ��, 2 <= n <= 500
		int m = Integer.parseInt(st.nextToken()); // �� Ƚ��, 2 <= m <= n*(n-1)/2

		a = new int[n + 1][n + 1]; // 1~n ������ Ȱ��. �������

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			a[small][tall] = 1; // ������ < ū��
		}

		// ������Ŀ��� ������� ���� 0��ĭ�� flag�� ����Ѵ�.
		// �ش� ĭ������ �θ��� ������ �־���´�.
		for (int i = 1; i < a.length; i++) {
			a[i][0] = -1;
			a[0][i] = -1;
		}

		int totalN = 0; // ������ ��Ȯ�� �˰ԵǴ� �л��� ��
		for (int i = 1; i < a.length; i++) {
			up(i); // dfs�� ����� ���ʿ� �ִ� �ֵ鸸 ��ȸ
			down(i);
			
			if(a[i][0] + a[0][i] == n-1) {
				totalN++;
			}
		}
		
		System.out.println(totalN);
	}

	private static void down(int v) {
		// TODO Auto-generated method stub
		if(a[0][v] != -1) { // ���� ������ �Ǿ��ִ� �����̸�
			return;
		}
		
		// ���� v������ �ڽ��� ���������� ������Ŀ� ����.
		for(int i=1; i<a.length; i++) {
			if(a[i][v] == 1) {
				up(i); // ������ ���� �ֵ��� Ž��
				for(int j=1; j<a.length; j++) { // i�� �ڽĵ��� v�� �ڽ��̶�� üũ
					a[j][v] |= a[j][i];
				}
			}
		}
		
		// ��������� 0��° ĭ�� v������ �θ��� ���� �� ������ �����ص���.
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += a[i][v];
		}
		a[0][v] = sum;
	}

	private static void up(int v) {
		// TODO Auto-generated method stub
		if(a[v][0] != -1) { // ���� ������ �Ǿ��ִ� �����̸�
			return;
		}
		
		// ���� v������ �θ� ���������� ������Ŀ� ����.
		for(int i=1; i<a.length; i++) {
			if(a[v][i] == 1) {
				up(i); // ������ ū �ֵ��� Ž��
				for(int j=1; j<a.length; j++) { // i�� �θ���� v�� �θ��� üũ
					a[v][j] |= a[i][j];
				}
			}
		}
		
		// ��������� 0��° ĭ�� v������ �θ��� ���� �� ������ �����ص���.
		int sum = 0;
		for(int i=1; i<a.length; i++) {
			sum += a[v][i];
		}
		a[v][0] = sum;
	}

}
