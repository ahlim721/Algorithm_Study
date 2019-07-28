package jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main_1828_냉장고_임현아 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ref = new int[n][2];
        for(int i=0; i<n; i++) {
            ref[i][0] = sc.nextInt();
            ref[i][1] = sc.nextInt();
        }
        Arrays.sort(ref, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
            	if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int cnt = 1;
        int min = 0;
        for(int i=1; i<n; i++) {
            if(ref[i][0] <= ref[min][1]) {
                if(ref[i][1] <= ref[min][1])
                    min = i;
            } else {
                min = i;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
 
}
