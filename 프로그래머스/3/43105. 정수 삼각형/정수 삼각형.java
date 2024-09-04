import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length][triangle.length];

        // 첫 번째 숫자는 바로 초기화
        dp[0][0] = triangle[0][0];

        // DP 테이블 채우기
        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽 가장자리 값 (위에서 한 경로로만 내려옴)
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            // 오른쪽 가장자리 값 (위에서 한 경로로만 내려옴)
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];

            // 중간의 값들 (위에서 두 경로 중 더 큰 값 선택)
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        // 마지막 행에서 가장 큰 값을 찾아서 반환
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }

        return answer;
    }
}
