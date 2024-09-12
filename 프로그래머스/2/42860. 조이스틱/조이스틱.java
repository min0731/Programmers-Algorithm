import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int rightLeft = name.length()-1;
        int upDown =0;
        int plusA =0;
        
        /* 상하만 */
        for (int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            //A에서 이동 vs Z에서 이동
            upDown += Math.min(c -'A', 'Z'-c+1);
        }
        /* 좌우만(A가 연속으로 있을 때를 고려) */
        for (int i=0; i< name.length(); i++){
            plusA = i+1;
            
            while(plusA < name.length() &&name.charAt(plusA) == 'A'){
                plusA++;
            }
            
        rightLeft = Math.min(rightLeft, i + name.length() - plusA + Math.min(i, name.length() - plusA));
       } 
        return answer = rightLeft+ upDown;
    }
}