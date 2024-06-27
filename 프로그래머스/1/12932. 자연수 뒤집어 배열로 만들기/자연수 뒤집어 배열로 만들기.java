import java.util.*;

class Solution {
    public int[] solution(long n) {

        /*
            1. 입력받은 숫자를 문자열로 변환
            2. 문자열 뒤집음 reversed 사용
            3. 문자열을 문자의 배열로 변환(char)
            4. 배열의 각 문자를 정수로 변환
        */

        String inputNum = Long.toString(n);
        String reversed = new StringBuilder(inputNum).reverse().toString();
        char arr [] = reversed.toCharArray();
        
        int[] answer = new int[arr.length];
        
        for (int i=0; i<arr.length; i++){
            answer[i] = arr[i] - '0';
            
        }
        
        
        
        return answer;
    }
}