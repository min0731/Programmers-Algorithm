import java.util.*;

class Solution {
    public int solution(String name) {
        int upDown = 0;
        int length = name.length();
        
        // 상하 이동 계산
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            upDown += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 좌우 이동 계산
        int rightLeft = length - 1;  // 기본적으로 오른쪽으로 끝까지 가는 경우
         
        for (int i = 0; i < length; i++) {
            int numA = i + 1;
            // 연속된 'A' 구간을 건너뛰기 위한 로직
            while (numA < length && name.charAt(numA) == 'A') {
                numA++;
            }
            // i는 현재 위치, numA는 'A'가 끝나는 위치
            // 좌우 이동의 최소값을 계산: 앞에서 돌아가는 경우와 끝까지 가는 경우 비교
            rightLeft = Math.min(rightLeft, i + length - numA + Math.min(i, length - numA));
        }

        // 총 이동 횟수 = 상하 이동 + 좌우 이동
        return upDown + rightLeft;
    }
}
