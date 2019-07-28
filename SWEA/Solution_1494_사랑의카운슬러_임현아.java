package com.ws;

import java.util.Scanner;

/**
* 지렁이 개수 짝수개, 둘씩 짝을 지어줌
* 짝을 지어주는 모든 경우의 수를 생각해보고, 각각의 짝이 연결되는 벡터를 구해서,
* 벡터들의 전체 합을 구한뒤, 벡터 전체의 크기를 구한다
* 이렇게 만든 벡터전체의 합의 크기의 최소값을 찾는 문제
*
* 팁: 벡터상의 출발 위치에 있는 지렁이 좌표의 합- 벡터상의 도착위치에 있는 지렁의 좌표의 합
*       그러므로 출발 위치 지렁이 끼리는 변경되더라도 벡터 전체의 합은 동일하다
*    도착위치 지렁이 까지는 변경 되더라도 벡터 전체의 합은 동일하다
*    결국, 출발위치의 그룹, 도착위치의 그룹으로 분할하는 문제= 출발 위치에 올 수 있는 N/2 마리
*    지렁이를 선택하는 조합문제
*
* 1번방법: 순수 조합문제로 조합이 완성되었을때, 벡터크기의 최소값을 업데이트하는다
* 2번방법: 조합을 재귀호출시 지렁이의 선택 여부에 따라 좌표의 합을 매개변수로 전달한다(효율적)
*/

public class Solution_1494_사랑의카운슬러_임현아 {
        public static int sumX,sumY;
        public static int[][] m;
        public static int[][] tr; //선택한 지렁이들의 좌표
        public static long min; //전체 벡터합의 크기중 최소값, 크기는 좌표의 제곱이라 int형을 넘어감
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int N= sc.nextInt();
            m = new int[N][2]; //0:x 1:y;
            sumX=0;
            sumY=0; //테스트 케이스 마다 새로 초기화
            
            for(int i=0; i<N; i++) {
                int x = sc.nextInt();
                int y =sc.nextInt();
                
                m[i][0]=x;
                m[i][1]=y;
                
                sumX+=x;
                sumY+=y;
                
            }
            tr =  new int[N/2][2]; //선택한 지렁이들의 좌표
            min=Long.MAX_VALUE;//전체 벡터합의 크기
            
            comb(N,N/2);
            
            System.out.println("#"+t+" "+min);
                        
            
            
        } //test
    }//main

    public static void comb(int n, int r) {//선택한 지렁이의 조합
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
                
                long v = vX * vX + vY*vY; //전체 벡터의 합
                
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