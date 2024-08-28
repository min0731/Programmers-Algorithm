import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxLength = 0;

        for (int i = 0; i < sizes.length; i++) {
            // 각 명함의 가로와 세로 중 큰 것을 가로로, 작은 것을 세로로 설정
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int length = Math.min(sizes[i][0], sizes[i][1]);

            // 현재까지의 최대 가로와 세로 길이 갱신
            maxWidth = Math.max(maxWidth, width);
            maxLength = Math.max(maxLength, length);
        }

        // 최종 지갑 크기 계산
        int answer = maxWidth * maxLength;
        return answer;
    }
}