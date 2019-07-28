package acmicpc;

import java.util.Scanner;

public class Main10026 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		char[][] rgb = new char[n][n];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<n; j++) {
				rgb[i][j] = s.charAt(j);
			}
		}
		
		int cwNum = 0;
		int nmNum = 0;
		boolean[][] cwVisit = new boolean[n][n]; // color weakness visit
		boolean[][] nmVisit = new boolean[n][n]; // normal visit
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(rgb[i][j] == 'B') {
					if(!nmVisit[i][j]) {
						getRORG(rgb, nmVisit, i, j);
						nmNum++;
						cwNum++;
					}
				}
				if(rgb[i][j] == 'R' || rgb[i][j] == 'G') {
					if(!cwVisit[i][j]) {
						getRNG(rgb, cwVisit, i, j);
						cwNum++;
					}
					if(!nmVisit[i][j]) {
						getRORG(rgb, nmVisit, i, j);
						nmNum++;
					}
				}
			}
		}
		
		System.out.println(nmNum + " " + cwNum);
	}

	private static void getRORG(char[][] rgb, boolean[][] nmVisit, int x, int y) {
		// TODO Auto-generated method stub
		int[][] qnm = new int[n*n+1][2];
		int front = -1;
		int rear = -1;
		qnm[++front][0] = x;
		qnm[front][1] = y;
		
		while(front != rear) {
			int getX = qnm[++rear][0];
			int getY = qnm[rear][1];
			for(int i=0; i<4; i++) {
				int rx = getX + dx[i];
				int ry = getY + dy[i];
				if(rx >= 0 && ry >= 0 && rx < n && ry < n && !nmVisit[rx][ry] && rgb[rx][ry] == rgb[x][y]) {
					qnm[++front][0] = rx;
					qnm[front][1] = ry;
					nmVisit[rx][ry] = true;
				}
			}
		}
	}

	private static void getRNG(char[][] rgb, boolean[][] cwVisit, int x, int y) {
		// TODO Auto-generated method stub
		int[][] qcw = new int[n*n+1][2];
		int front = -1;
		int rear = -1;
		qcw[++front][0] = x;
		qcw[front][1] = y;
		
		while(front != rear) {
			int getX = qcw[++rear][0];
			int getY = qcw[rear][1];
			for(int i=0; i<4; i++) {
				int rx = getX + dx[i];
				int ry = getY + dy[i];
				if(rx >= 0 && ry >= 0 && rx < n && ry < n && !cwVisit[rx][ry] && (rgb[rx][ry] == 'R' || rgb[rx][ry] == 'G')) {
					qcw[++front][0] = rx;
					qcw[front][1] = ry;
					cwVisit[rx][ry] = true;
				}
			}
		}
	}

}
