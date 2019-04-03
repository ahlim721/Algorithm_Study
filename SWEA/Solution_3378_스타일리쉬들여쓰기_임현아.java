package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_임현아 {
    private static String[] master;
    private static String[] my;
    private static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            master = new String[p];    //마스터 코드
            my = new String[q];    //유저코드
            result = new int[q];    //출력할 결과 저장할 배열
            Arrays.fill(result, -2);//배열의 초기값을 사용하지 않는 숫자 -2로 초기화
            
            for (int i = 0; i < p; i++) {
                master[i] = br.readLine();
            }
            for (int i = 0; i < q; i++) {
                my[i] = br.readLine();
            }
            
            for (int r = 1; r <= 20; r++) {
                for (int c = 1; c <= 20; c++) {
                    for (int s = 1; s <= 20; s++) {
                        if (pOK(r, c, s)) {;//마스터의 모든 코드행에 가능한 값인지 체크
                            qCheck(r, c, s);// 유저의 모든 코드 행에서 가능한지 체크 후 배열에 저장
                        }
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append('#').append(tc);
            for (int i = 0; i < result.length; i++) {
                sb.append(' ').append(result[i]);
            }
            System.out.println(sb.toString());
        }
    }//end of main
    /** 마스터의 모든 코드행에 가능한 값인지 체크*/
    public static boolean pOK(int r, int c, int s) {
        int rr = 0;    // ()개수
        int cc = 0;    // {}개수
        int ss = 0; // []개수
        
        for (int i = 0; i < master.length; i++) {
            int dot = 0;    // .의 개수
            String str = master[i];    //마스터 코드의 한줄
            int j;
            for (j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '.') dot++;
                else break;    //다른 글자가 나오면 그만 종료
            }
            
            if(r*rr + c*cc + s*ss != dot) return false;    //첫번째 줄은 무조건 만족(.이없으므로)
            
            for (; j < str.length(); j++) {// . 읽은 글자들 다음부터 읽어가기
                if       (str.charAt(j)=='(') rr++;
                else if(str.charAt(j)==')') rr--;
                else if(str.charAt(j)=='{') cc++;
                else if(str.charAt(j)=='}') cc--;
                else if(str.charAt(j)=='[') ss++;
                else if(str.charAt(j)==']') ss--;
            }
        }
        return true;
    } //end of pOK();
    /** 유저의 모든 코드행에 가능한지 체크 후 배열에 저장*/
    public static void qCheck(int r, int c, int s) {
        int rr = 0;
        int cc = 0;
        int ss = 0;
        for (int i = 0; i < my.length; i++) {
            int dap = r*rr + c*cc + s*ss;    //출력할 값
            if(result[i] == -2) {//처음 저장하는 상황
                result[i] = dap;
            } else if(result[i] == -1) {
                
            } else if(result[i] >= 0 && result[i] != dap){//뭔가 저장했었는데, 값이 달라진 상황
                result[i] = -1;    //값이 하나가 아님
            }
            String str = my[i];
            for (int j = 0; j < str.length(); j++) {
                if       (str.charAt(j) == '(') rr++;
                else if(str.charAt(j) == ')') rr--;
                else if(str.charAt(j) == '{') cc++;
                else if(str.charAt(j) == '}') cc--;
                else if(str.charAt(j) == '[') ss++;
                else if(str.charAt(j) == ']') ss--;
            }
        }
    }//end of qCheck()
    
}//end of class