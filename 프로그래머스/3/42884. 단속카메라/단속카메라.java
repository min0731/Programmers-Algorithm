import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int camera = routes[0][1];
        
        for (int i=1; i<routes.length; i++){
            if(routes[i][0] > camera) {
                camera = routes[i][1];
                answer+=1;   
            }
        }
        return answer;
    }
}