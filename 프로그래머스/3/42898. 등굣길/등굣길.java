import java.util.*;


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int arr [][] = new int [n][m];

        
        
        // ?: 언제 멈춰야하고 언제 시작해야하는지?
        
        // 물 웅덩이 구역 표시
        for (int i = 0 ; i<puddles.length; i++){
                arr[puddles[i][1]-1 ][puddles[i][0]-1] = -1;
        }
        
       // 최적화 거리 갯수 구하기 
        arr[0][0] =1;
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                
                // 물 웅덩이 피함
                if (arr[i][j] == -1) {
                    arr[i][j]=0;
                     continue;
                }   
                     if (i > 0) arr[i][j] = (arr[i][j] + arr[i - 1][j]) % 1000000007;
                if (j > 0) arr[i][j] = (arr[i][j] + arr[i][j - 1]) % 1000000007;
                }
            }
    
        
        answer = arr[n-1][m-1];
        return answer;
    }
}