package swexpert;

import java.util.Scanner;

public class Solution_4408_�ڱ�����ε��ư���_������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[] crd = new int[200]; // ���� �迭
			for(int i=0; i<n; i++) {
				int now = (sc.nextInt()-1)/2;
				int will = (sc.nextInt()-1)/2;
				if(will < now) {
					int tmp = now;
					now = will;
					will = tmp;
				}
				for(int j=now; j<=will; j++) {
					crd[j]++;
				}
			}
			
			int max = -1;
			for(int i=0; i<200; i++) {
				if(crd[i] > max) max = crd[i];
			}
			System.out.println("#" + t + " " + max);
			
 		}
	}

}
