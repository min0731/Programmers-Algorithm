import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        int [] tmp; 
        for (int i=0; i<commands.length; i++){
            //정렬을 위한 새로운 배열 선언
            tmp = new int [commands[i][1]-commands[i][0]+1];
            
            int plus=0;
            for (int s=0; s<commands[i][1]-commands[i][0]+1; s++){
                tmp[s] = array[commands[i][0]-1+plus];
                plus++;
            }
             
            //정렬 
            Arrays.sort(tmp);
            answer[i]=tmp[commands[i][2]-1];
                
                
            }
        return answer;
        
    }
}