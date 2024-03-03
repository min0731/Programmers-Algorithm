import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        /* 필요한 변수 선언 */
        int [][] arr = new int [n][n];
        int num = 1; // 넣을 숫자
        int x =0, y =0; // 각 좌표
        
        
        /* 3번의 루트 반복 */
        while (true){
            
            /* 1. 아래로 이동 */
            while (true){
                
                arr[y][x] = num++;
                
                // 아래로 더이상 내려갈 수 없음
                if ( y+1 >= n|| arr[y+1][x] != 0) break;
                
                y+=1; // y좌표 이동 
            }
            
            // 오른쪽으로 이동 할 수 없을 때 
            // 끝에 도착했거나, 이미 채워져있는 경우 
            if (x+1 >= n || arr[y][x+1] != 0) break;
            x+=1;
            
        
            /*2. 오른쪽으로 이동 */
            while (true){
                arr[y][x] = num++;
                
                // 오른쪽으로 더이상 갈 수 없음
                if ( x+1 >= n|| arr[y][x+1] !=0 ) break;
                
                x+=1;
            }
            
            // 대각선으로 이동 할 수 없을 때
            // 끝에 도착, 이미 채워진 상태
    
            if (arr[y-1][x-1] !=0) break;
            y-=1;
            x-=1;
                
            
            /*3. 대각선으로 이동 */
            while (true){
                arr[y][x] = num++;
                
                // 대각선으로 더이상 갈 수 없음
                if (arr[y-1][x-1] !=0) break;
                x-=1;
                y-=1;
            }   
            
            // 아래로 이동 할 수 없을 때
            // 끝에 도착, 이미 채워진 상태
            if ( y+1 >= n || arr[y+1][x] !=0) break;
            y+=1;
        }
        
        /* 정답 출력 */
        int []answer = new int [num-1];
        int num2=0;
        
        for (int i=0; i< n; i++){
            for (int j=0; j< n; j++){
                if (arr[i][j] != 0) {
                    answer[num2++] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
}