import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        /*
            1. 공백포함 문자열의 길이만큼의 반환 배열 생성
            2. n만큼 아스키코드에 더하기
            3. 공백 판별을 위해 문자 범위 추가
                3-1. 공백일시 반환 배열에 공백 추가
        */
        
        char arr[] = new char[s.length()];
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (Character.isUpperCase(c)) //대문자일 경우
            {
                c = (char)((c-'A'+n)%26+'A');
            }
            else if (Character.isLowerCase(c)){
                 c = (char)((c-'a'+n)%26+'a');
            }
            else c=' ';
            
            arr[i] = c;
        }
    
        String answer = String.valueOf(arr);
        return answer;
    }
}