import java.util.*;

class Solution {
    /*
        1. n을 3으로 나눈 나머지를 문자열에 차례대로 저장
        2. 문자열 reversed를 통해서 뒤집
        3. 뒤집은 문자열의 뒤 s.length()-1 부터 Integer.parseInt()로 변환 후 계산
    */
    public int solution(int n) {
        int answer = 0;
        String s = "";
        StringBuilder sb = new StringBuilder(s);
      
        
        // #1
        while (n > 0){
            s+=Integer.toString(n%3);
            n/=3;
        }
        
        // #3
        for (int i = 0; i < s.length(); i++){
           answer += Math.pow(3,i) * Integer.parseInt(String.valueOf(s.charAt(s.length()-1-i)));
        }
            
        
        return answer;
    }
}