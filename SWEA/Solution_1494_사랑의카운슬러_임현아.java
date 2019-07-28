package com.ws;

import java.util.Scanner;

/**
* ������ ���� ¦����, �Ѿ� ¦�� ������
* ¦�� �����ִ� ��� ����� ���� �����غ���, ������ ¦�� ����Ǵ� ���͸� ���ؼ�,
* ���͵��� ��ü ���� ���ѵ�, ���� ��ü�� ũ�⸦ ���Ѵ�
* �̷��� ���� ������ü�� ���� ũ���� �ּҰ��� ã�� ����
*
* ��: ���ͻ��� ��� ��ġ�� �ִ� ������ ��ǥ�� ��- ���ͻ��� ������ġ�� �ִ� ������ ��ǥ�� ��
*       �׷��Ƿ� ��� ��ġ ������ ������ ����Ǵ��� ���� ��ü�� ���� �����ϴ�
*    ������ġ ������ ������ ���� �Ǵ��� ���� ��ü�� ���� �����ϴ�
*    �ᱹ, �����ġ�� �׷�, ������ġ�� �׷����� �����ϴ� ����= ��� ��ġ�� �� �� �ִ� N/2 ����
*    �����̸� �����ϴ� ���չ���
*
* 1�����: ���� ���չ����� ������ �ϼ��Ǿ�����, ����ũ���� �ּҰ��� ������Ʈ�ϴ´�
* 2�����: ������ ���ȣ��� �������� ���� ���ο� ���� ��ǥ�� ���� �Ű������� �����Ѵ�(ȿ����)
*/

public class Solution_1494_�����ī���_������ {
        public static int sumX,sumY;
        public static int[][] m;
        public static int[][] tr; //������ �����̵��� ��ǥ
        public static long min; //��ü �������� ũ���� �ּҰ�, ũ��� ��ǥ�� �����̶� int���� �Ѿ
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int N= sc.nextInt();
            m = new int[N][2]; //0:x 1:y;
            sumX=0;
            sumY=0; //�׽�Ʈ ���̽� ���� ���� �ʱ�ȭ
            
            for(int i=0; i<N; i++) {
                int x = sc.nextInt();
                int y =sc.nextInt();
                
                m[i][0]=x;
                m[i][1]=y;
                
                sumX+=x;
                sumY+=y;
                
            }
            tr =  new int[N/2][2]; //������ �����̵��� ��ǥ
            min=Long.MAX_VALUE;//��ü �������� ũ��
            
            comb(N,N/2);
            
            System.out.println("#"+t+" "+min);
                        
            
            
        } //test
    }//main

    public static void comb(int n, int r) {//������ �������� ����
        if(n <r) {
            return;
            
        }else if(r==0){
                int sumSelectX=0;
                int sumSelectY=0;
                for (int i = 0; i < tr.length; i++) {
                    sumSelectX+=tr[i][0];
                    sumSelectY+=tr[i][1];
                }
                
                int sumUnselectX = sumX - sumSelectX;
                int sumUnselectY = sumY - sumSelectY;
                long vX = sumSelectX - sumUnselectX;
                long vY = sumSelectY - sumUnselectY;
                
                long v = vX * vX + vY*vY; //��ü ������ ��
                
                if(min>v) {
                    min=v;
                }
                
                
        }else {
            tr[r-1][0] = m[n-1][0];
            tr[r-1][1]= m[n-1][1];
            comb(n-1, r-1);
            comb(n-1, r);
        }
        
    }
}//class