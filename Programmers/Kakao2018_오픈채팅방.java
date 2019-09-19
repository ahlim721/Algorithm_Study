package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kakao2018_오픈채팅방 {

	static class Solution {
		
		HashMap<String, String> idList = new HashMap<String, String>();

		public String[] solution(String[] record) {

			ArrayList<String[]> state = getList(record, record.length);
			String[] answer = printList(state, state.size());
			
			return answer;
		}

		private String[] printList(ArrayList<String[]> state, int length) {
			String[] answer = new String[length];
			
			for(int i=0; i<length; i++) {
				answer[i] = getWord(state.get(i));
			}
			
			return answer;
		}

		private String getWord(String[] state) {
			return idList.get(state[0]) + state[1];
		}

		private ArrayList<String[]> getList(String[] record, int length) {
			ArrayList<String[]> state = new ArrayList<>();
			
			for(int i=0; i<length; i++) {
				String[] input = record[i].split(" ");
			
				if(input[0].equals("Enter")) {
					idList.put(input[1], input[2]);
					state.add(new String[] {input[1], "님이 들어왔습니다."});
				} 
				else if(input[0].equals("Leave")) {
					state.add(new String[] {input[1], "님이 나갔습니다."});
				}
				else if(input[0].equals("Change")) {
					idList.put(input[1], input[2]);
				}
			}
			
			return state;
		}
		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
	}

}
