import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        Integer [] tmp = new Integer [2];
        int [] answer= new int[2];
        int total=brown+yellow;
        
        int row=0;
        for (int col=3; col<=total; col++){
            if (total %col==0)
                row=total/col;
            if ((row-2) * (col-2)==yellow) {
                tmp[0]=col;
                tmp[1]=row;
                break;
            }    
        }
        
       Arrays.sort(tmp,  Collections.reverseOrder());
       answer[0]=tmp[0];
        answer[1]=tmp[1];
        return answer;
    }
}