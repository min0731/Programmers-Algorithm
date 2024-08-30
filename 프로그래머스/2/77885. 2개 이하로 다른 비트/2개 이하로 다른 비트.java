import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            if (number % 2 == 0) { 
                // 짝수는 +1만 하면 됨
                answer[i] = number + 1;
            } else {
                // 홀수 처리
                String binaryString = Long.toBinaryString(number);
                
                // 가장 오른쪽의 '0'을 찾고, 그 '0'을 '1'로, 다음 '1'을 '0'으로 바꿈
                int lastZeroIndex = binaryString.lastIndexOf('0');
                int firstOneAfterZeroIndex = binaryString.indexOf('1', lastZeroIndex);
                
                if (lastZeroIndex != -1) {
                    // 마지막 '0'을 '1'로 바꾸고, 다음 '1'을 '0'으로 바꿈
                    binaryString = binaryString.substring(0, lastZeroIndex) + '1'
                                   + binaryString.substring(lastZeroIndex + 1, firstOneAfterZeroIndex) + '0'
                                   + binaryString.substring(firstOneAfterZeroIndex + 1);
                } else {
                    // 모든 비트가 '1'인 경우
                    binaryString = "10" + binaryString.substring(1);
                }
                
                // 다시 10진수로 변환하여 저장
                answer[i] = Long.parseLong(binaryString, 2);
            }
        }
        
        return answer;
    }
}
