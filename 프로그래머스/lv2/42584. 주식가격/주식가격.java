import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int totalCnt= prices.length;
        int[] answer = new int[totalCnt];
        
       for (int i=0; i<totalCnt; i++){
           for (int j=i+1; j<totalCnt; j++){
               answer[i]++;
               if (prices[i] > prices[j]) break;
               
           }
       }

        return answer;
    }
}