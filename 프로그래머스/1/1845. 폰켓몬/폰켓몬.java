import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //몇마리를 가질 수 있는지 
        int answer = 0;
    
        
        //해시맵 선언
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i< nums.length; i++){
            map.put(nums[i],nums[i]);
        }
        
        if (map.size() > nums.length/2){
            answer=nums.length/2;
        }
        else {
            answer= map.size();
        }
        
        
        
        
        return answer;
    }
}