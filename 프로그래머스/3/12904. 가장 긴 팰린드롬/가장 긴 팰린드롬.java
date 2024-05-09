
class Solution {
    public int solution(String s) {
        
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                if(isPalindrome(s, j, j+i-1)) return i;
            }
        }

        return 0;
    }
    
    boolean isPalindrome(String value, int start, int end) {
        while(start <= end) {
            if(value.charAt(start++) != value.charAt(end--)) return false;
        }
        return true;
    }
}



// import java.util.*;

// class Solution
// {
//     public int solution(String s)
//     {
//         int answer = 0;
//         StringBuffer sb= null;
        
//         int start;
        
//         for (start=0; start < s.length()-1; start++){
//             for (int end=start; end<s.length(); end++){
//                 String tmp= s.substring(start, end+1);
                
//                 //reverse() 메소드를 제공하는 StringBuffer 클래스를 사용     
//                 sb = new StringBuffer(tmp);
//                 String Ctmp = sb.reverse().toString();
              
//                 // equals() 함수를 이용하여 두 문자열 비교
//                 if (Ctmp.equals(tmp)) {
//                     //더 긴 문자열을 찾을 때까지 함
//                     answer = Math.max(answer, Ctmp.length());
//                 }
            
            
//             }
//         }
//         //System.out.println(answer);
//             return answer;
//     }
// }