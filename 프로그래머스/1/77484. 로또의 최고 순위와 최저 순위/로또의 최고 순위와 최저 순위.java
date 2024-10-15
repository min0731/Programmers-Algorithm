import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        int cnt = 0;
        int zero=0;
        
        List<String> list = new ArrayList<>();
        
        
        // 특정 문자가 들어있는지 찾기 위해서 String 형으로 리스트에 넣음
        for (int i=0; i<lottos.length; i++){
             list.add(lottos[i]+"");
             if (lottos[i] ==0 ) zero+=1;
        }

         for (int i=0; i<win_nums.length; i++){
             if(list.contains(win_nums[i]+"")) cnt+=1;
         }
        

        if (7-(cnt+zero) >6  || 7-cnt > 6) 
         {
            answer[0] = Math.min((7-(cnt+zero)), (7-cnt));
            answer[1] = 6;   
         }
         else {
             answer[0]= Math.min((7-(cnt+zero)), (7-cnt));
             answer[1]= Math.max((7-(cnt+zero)), (7-cnt));
         }
        
        if (cnt+zero== 0) answer[0]= 6;
        
        
        return answer;
    }
}
