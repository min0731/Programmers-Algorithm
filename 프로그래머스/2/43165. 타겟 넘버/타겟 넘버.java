import java.util.*;

// 숫자의 탐색은 순서대로 해야함 -> 그러기 위해서는 index관리를 해줘야함 

class Solution {
    static int answer =0;
    
    public int solution(int[] numbers, int target) {
       
        check(numbers, target, 0, 0 );
        return answer;
    }
    
    public void check (int[] numbers, int target, int idx, int sum){
        
        if(idx == numbers.length) {
            //idx가 숫자 배열의 마지막 인덱스일때만 확인함. 
            if(sum == target) //  모든 숫자를 합한 뒤에, 검사해야함. 
            {
                answer+=1;
            }
            return;
        }
        
        //  플러스 +
        check(numbers, target,idx+1, sum+numbers[idx]);
        
        // 마이너스 -
        check(numbers, target,idx+1, sum-numbers[idx]);
    }
}