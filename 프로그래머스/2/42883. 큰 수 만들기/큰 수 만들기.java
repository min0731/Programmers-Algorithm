import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i< number.length(); i++){
            char c= number.charAt(i);
            
            while(!st.isEmpty()&& k>0 && st.peek() < c){
                     st.pop();
                     k--;
                  }
             
            st.push(c);
        }
        // k가 제거되지 않는 경우는, 내림차순으로 있을 때
        while(k >0){
            st.pop();
            k--;
         }
        
        while(!st.isEmpty()) answer+=st.pop();
        StringBuilder sb = new StringBuilder(answer);
        
        
        return  sb.reverse().toString();
    }
}