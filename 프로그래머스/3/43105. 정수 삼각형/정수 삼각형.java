import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = -1;
        int dp [][]= new int[triangle.length][triangle.length];
        
        // 첫 번째 숫자는 바로 넣어줌
        dp[0][0] = triangle[0][0];
        
        // 삼각형의 각 줄에 대해 DP 테이블을 채워 나감
        for (int j = 1; j < triangle.length; j++) {
            // 왼쪽 가장자리의 값 (한 방향에서만 올 수 있음)
            dp[j][0] = dp[j - 1][0] + triangle[j][0];
            // 오른쪽 가장자리의 값 (한 방향에서만 올 수 있음)
            dp[j][j] = dp[j - 1][j - 1] + triangle[j][j];
            
            // 중간 값들 처리 (두 방향에서 올 수 있음)
            for (int i = 1; i < j; i++) {
                dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j - 1][i]) + triangle[j][i];
            }
        }
        
        // 마지막 행에서 가장 큰 값을 찾아서 반환
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            answer = Math.max(dp[dp.length - 1][i], answer);
        }
        
        return answer;
    }
}
