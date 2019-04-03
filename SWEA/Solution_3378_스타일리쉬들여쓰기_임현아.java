package ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_��Ÿ�ϸ����鿩����_������ {
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
            master = new String[p];    //������ �ڵ�
            my = new String[q];    //�����ڵ�
            result = new int[q];    //����� ��� ������ �迭
            Arrays.fill(result, -2);//�迭�� �ʱⰪ�� ������� �ʴ� ���� -2�� �ʱ�ȭ
            
            for (int i = 0; i < p; i++) {
                master[i] = br.readLine();
            }
            for (int i = 0; i < q; i++) {
                my[i] = br.readLine();
            }
            
            for (int r = 1; r <= 20; r++) {
                for (int c = 1; c <= 20; c++) {
                    for (int s = 1; s <= 20; s++) {
                        if (pOK(r, c, s)) {;//�������� ��� �ڵ��࿡ ������ ������ üũ
                            qCheck(r, c, s);// ������ ��� �ڵ� �࿡�� �������� üũ �� �迭�� ����
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
    /** �������� ��� �ڵ��࿡ ������ ������ üũ*/
    public static boolean pOK(int r, int c, int s) {
        int rr = 0;    // ()����
        int cc = 0;    // {}����
        int ss = 0; // []����
        
        for (int i = 0; i < master.length; i++) {
            int dot = 0;    // .�� ����
            String str = master[i];    //������ �ڵ��� ����
            int j;
            for (j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '.') dot++;
                else break;    //�ٸ� ���ڰ� ������ �׸� ����
            }
            
            if(r*rr + c*cc + s*ss != dot) return false;    //ù��° ���� ������ ����(.�̾����Ƿ�)
            
            for (; j < str.length(); j++) {// . ���� ���ڵ� �������� �о��
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
    /** ������ ��� �ڵ��࿡ �������� üũ �� �迭�� ����*/
    public static void qCheck(int r, int c, int s) {
        int rr = 0;
        int cc = 0;
        int ss = 0;
        for (int i = 0; i < my.length; i++) {
            int dap = r*rr + c*cc + s*ss;    //����� ��
            if(result[i] == -2) {//ó�� �����ϴ� ��Ȳ
                result[i] = dap;
            } else if(result[i] == -1) {
                
            } else if(result[i] >= 0 && result[i] != dap){//���� �����߾��µ�, ���� �޶��� ��Ȳ
                result[i] = -1;    //���� �ϳ��� �ƴ�
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