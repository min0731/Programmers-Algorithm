import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String str [] = new String [numbers.length];
        
        for (int i=0; i<numbers.length; i++){
            str[i] = numbers[i]+"";
        }
        
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
        
        for (String s: str){
            answer+=s;
        }
        
        //모든 값이 0일때/
        if (str[0].equals("0")) {
            return "0";
        }

        return answer;
    }
}