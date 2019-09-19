package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Kakao2018_실패율 {

	static class Solution {
		
		public int[] solution(int N, int[] stages) {
	        
	        int[] numberOfUser = getNumberOfUser(stages, stages.length, N + 1);
	        
	        double[][] failure = getFailure(numberOfUser, N);
	       
	        Arrays.sort(failure, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if(o1[0] == o2[0])
						return o1[1] < o2[1] ? -1 : 1;
					return o2[0] < o1[0] ? -1 : 1;
				}
			});
	        
	        int[] answer = getOrder(failure);
	        
	        return answer;
	    }

		private int[] getOrder(double[][] failure) {
			int[] answer = new int[failure.length];
			
			for(int i=0; i<failure.length; i++) {
				answer[i] = (int)(failure[i][1] + 1);
			}
			
			return answer;
		}

		private double[][] getFailure(int[] numberOfUser, int n) {
			int getStageUsers = numberOfUser[n];
			
			double[][] failure = new double[n][2];

			for(int i=n-1; i>=0; i--) {
				int notClear = numberOfUser[i];
				getStageUsers += notClear;
				
				if(getStageUsers != 0)
					failure[i][0] = (double)notClear / (double)getStageUsers;
				failure[i][1] = i;							
			}
			
			return failure;
		}

		private int[] getNumberOfUser(int[] stages, int length, int stageLength) {
			int[] numberOfUser = new int[stageLength];
			
			for(int i=0; i<length; i++) {
				numberOfUser[stages[i] - 1]++;
			}
			
			return numberOfUser;
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(4, new int[] {4, 4, 4, 4, 4})));
	}

}
