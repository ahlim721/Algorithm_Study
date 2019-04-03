package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무_임현아 {
	
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

			// 2진수를 10진수로 변환.
			int inBin = Integer.parseInt(bin, 2);
			// 3진수를 10진수로 변환.
			int inTri = Integer.parseInt(tri, 3);
			
			long ans = 0;
			
			go : 
			for(int i=bin.length()-1; i>=0; i--) {
				
				// 2진수로 부터 나올 수 있는 경우를 구한다.
				int tmp = inBin;
				if(bin.charAt((bin.length()-i)-1) == '1') 
					tmp -= Math.pow(2, i);
				else 
					tmp += Math.pow(2, i);

				// 3진수로부터의 차를 구한다.
				if(tmp > inTri) {
					int cha = tmp - inTri;
					// 해당 차가 3진수의 각 자리수의 배수인지를 체크
					for(int j=0; j<tri.length(); j++) {
						if (cha % triArr[j] == 0 && cha / triArr[j] < 3) {
							// 배수인 경우, 3진수에서 만들어 질 수 있는 지를 체크, 만들어 진다면 해당 tmp가 답.
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
				} else { // 같은 경우는 어차피 구할 수 없으므로
					continue;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
