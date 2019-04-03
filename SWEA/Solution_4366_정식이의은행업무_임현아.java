package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4366_���������������_������ {
	
	public static long[] binArr = new long[40];
	public static long[] triArr = new long[40];

	public static void main(String[] args) throws Exception {
		
		for(int i=0; i<40; i++) {
			binArr[i] = (long) Math.pow(2, i);
			triArr[i] = (long) Math.pow(3, i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String bin = br.readLine();
			String tri = br.readLine();

			// 2������ 10������ ��ȯ.
			int inBin = Integer.parseInt(bin, 2);
			// 3������ 10������ ��ȯ.
			int inTri = Integer.parseInt(tri, 3);
			
			long ans = 0;
			
			go : 
			for(int i=bin.length()-1; i>=0; i--) {
				
				// 2������ ���� ���� �� �ִ� ��츦 ���Ѵ�.
				int tmp = inBin;
				if(bin.charAt((bin.length()-i)-1) == '1') 
					tmp -= Math.pow(2, i);
				else 
					tmp += Math.pow(2, i);

				// 3�����κ����� ���� ���Ѵ�.
				if(tmp > inTri) {
					int cha = tmp - inTri;
					// �ش� ���� 3������ �� �ڸ����� ��������� üũ
					for(int j=0; j<tri.length(); j++) {
						if (cha % triArr[j] == 0 && cha / triArr[j] < 3) {
							// ����� ���, 3�������� ����� �� �� �ִ� ���� üũ, ����� ���ٸ� �ش� tmp�� ��.
							if((tri.charAt((tri.length()-j)-1) - '0') + cha / triArr[j] < 3) {
								ans = tmp;
								break go;
							}
						}
					}
				} else if(tmp < inTri){
					int cha = inTri - tmp;
					for(int j=0; j<tri.length(); j++) {
						if (cha % triArr[j] == 0 && cha / triArr[j] < 3) {
							if((tri.charAt((tri.length()-j)-1) - '0') - cha / triArr[j] >= 0) {
								ans = tmp;
								break go;
							}
						}
					}
				} else { // ���� ���� ������ ���� �� �����Ƿ�
					continue;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
