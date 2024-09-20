import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 첫 진출된 곳에는 CCTV를 설치 
        int answer = 1;
        
        // 두번째 기준 내림차순으로 정렬
        Arrays.sort(routes,(a,b) -> Integer.compare(a[1],b[1]));
        int camera =routes[0][1];  
        
        
        for (int i=1; i<routes.length; i++){
            //해당 범위 안에 안들어오면
            if(camera < routes[i][0]) {
                answer+=1;
                camera = routes[i][1]; 
            }
                
        }
        return answer;
    }
}