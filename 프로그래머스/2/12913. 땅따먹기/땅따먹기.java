import java.util.*;

/*
    - dp를 사용해서 가장 최댓값을 구함 : Math.max()
        
*/

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int SIZE = land.length;
        int dp [][] = new int [SIZE][4];
        
        //첫 행은 이전 열을 신경 쓸 필요가 없으므로 그냥 넣어줌.
        for (int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < SIZE; i++){
            // 이전 행에서 0번쨰 열을 선택했다면, 0번째 열을 빼고 이전 열들 계산
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            // 이전 행에서 1번쨰 열을 선택했다면, 0번째 열을 빼고 이전 열들 계산
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            // 이전 행에서 2번쨰 열을 선택했다면, 2번째 열을 빼고  이전 열들 계산
            dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
            // 이전 행에서 3번쨰 열을 선택했다면, 3번째 열을 빼고 이전 열들 계산
            dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            
        }
        
        answer = Math.max(dp[SIZE-1][0], Math.max(dp[SIZE-1][1],Math.max(dp[SIZE-1][2], dp[SIZE-1][3])));

        return answer;
    }
}