package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5672_���������û�_������ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			char[] line = new char[n];
			for(int i=0; i<n; i++) {
				line[i] = br.readLine().trim().charAt(0);
			}
			
			int front = 0;
			int rear = n-1;
			
			String ans = makeNewLine3(front, rear, line);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	private static String makeNewLine3(int front, int rear, char[] line) {
		String ans = "";
		while(front != rear) {
			if(line[front] < line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[front++];
			} else if(line[front] > line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[rear--];
			} else {
				boolean flag = true;
				for(int i=0; i<=(rear-front)/2; i++) {
					if (line[front + i] != line[rear - i]) {
						if (line[front + i] < line[rear - i])
							ans += line[front++];
						else if (line[front + i] > line[rear - i])
							ans += line[rear--];
						flag = false;
						break;
					}
				}
				if(flag) 
					ans += line[front++];
			}
		}
		ans += line[front];
		return ans;
	}
	
	
	private static String makeNewLine(int front, int rear, char[] line) {
		String ans = "";
		if(front == rear) ans += line[front];
		else {
			if(line[front] < line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[front] + makeNewLine(front+1, rear, line);
			} else if(line[front] > line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[rear] + makeNewLine(front, rear-1, line);
			} else if(line[front] == line[rear]) {
				String a = line[front] + makeNewLine(front+1, rear, line);
				String b = line[rear] + makeNewLine(front, rear-1, line);
				if(a.compareTo(b) <= 0) // a�� �� ũ�� 1, ������ -1, ������ 0
					ans += a;
				else 
					ans += b;
			}
		}
		return ans;
	}
	
	private static String makeNewLine2(int front, int rear, char[] line) {
		String ans = "";
		if(front == rear) ans += line[front];
		else {
			if(line[front] < line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[front] + makeNewLine2(front+1, rear, line);
			} else if(line[front] > line[rear]) { // ���� ���ĺ��� ũ�ٸ�, ���� ���ĺ��� ���Ѵ�.
				ans += line[rear] + makeNewLine2(front, rear-1, line);
			} else if(line[front] == line[rear]) {
				if(line[front+1] < line[rear-1])
					ans += line[front] + makeNewLine2(front+1, rear, line);
				else 
					ans += line[rear] + makeNewLine2(front, rear-1, line);
			}
		}
		return ans;
	}
	
}
