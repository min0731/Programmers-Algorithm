import java.util.*;

class Solution {
    public String solution(String s) {
        /*
             짝수: 대문자 / 홀수: 소문자 
             1. 공백 -> 그냥 붙임
             2. 공백 다음에 온 문자는 무조건 대문자임
        */
        
        char arr [] = new char [s.length()];
        boolean check = true; // 짝수: true, 홀수: false
        
        for (int i=0; i<s.length(); i++){
            
            // 공백임?
            if(s.charAt(i)==' ') {
                arr[i] = ' ';
                check=true;
            }
            
            else if(check) // 짝수면    
                
            {
                
                arr[i] = Character.toUpperCase(s.charAt(i));
                check = false;
            }
            
            else //홀수면
            {
                arr[i] = Character.toLowerCase(s.charAt(i));
                check = true;
            }            
        }
                        
        String answer = String.valueOf(arr);        
        return answer;
    }
}