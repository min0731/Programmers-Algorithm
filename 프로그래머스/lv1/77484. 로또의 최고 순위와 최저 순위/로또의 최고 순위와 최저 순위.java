class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        
        // 0의 갯수 카운트 
        int zero = 0;
        
        // 같은 숫자 카운트 
        int same = 0;
        for (int i = 0; i< lottos.length; i++){
            if (lottos[i] == 0 ){
                zero++;
            }
            
            for (int j=0 ; j < win_nums.length; j++){
                if (lottos [i] == win_nums[j]){
                    same++;
                }
            }
            
            if (7-(same+zero) == 7 ) answer[0]=6;
            else answer[0] = 7-(same+zero);
            
            if ( 7-same  == 7 )answer[1]=6;
            else answer[1] = 7-same ;
            
            
            
        }
        // 
        return answer;
    }
}