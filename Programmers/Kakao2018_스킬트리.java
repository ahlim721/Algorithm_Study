package programmers;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
        	
        	if(isPossible(skill, 0, skill_trees[i]))
        		answer++;
        	
        }
        
        return answer;
    }

	private boolean isPossible(String skill, int skill_idx, String skill_tree) {
		for(int i=0; i<skill_tree.length(); i++) {
			if(skill_idx == skill.length())
				return true;
			
			if(skill.charAt(skill_idx) == skill_tree.charAt(i)) 
				skill_idx++;
			
			else if(skill.contains(skill_tree.charAt(i) + ""))
				return false;
		}
		return true;
	}
}

public class Kakao2018_스킬트리 {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int answer = s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
		
		System.out.println(answer);
	}

}
