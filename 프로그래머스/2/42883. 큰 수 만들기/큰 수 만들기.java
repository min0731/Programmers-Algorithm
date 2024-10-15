import java.util.*;
/*
    숫자의 위치가 변경되면 안되므로 -> Stack을 사용
*/

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack <Character>  st = new Stack<>();
        int delete=0;
        
        char ch[] = number.toCharArray();
        
        st.push(ch[0]);
        for (int i=1; i<ch.length; i++){
            
            // 스택에 내용물이 있다면? , 마지막 종료조건
            if (delete ==k ) {
                st.push(ch[i]);
                continue;
            }
            
            else
            {  
                while (st.size()>0 && st.peek()-'0'< ch[i]-'0') {
                    st.pop();
                    delete+=1;
                    
                    if (delete == k ) break;
                }
                st.push(ch[i]);
            }
        }

        // 남은 숫자를 제거하지 못한 경우 (76544321 인경우 push만 했기에 pop 해줘야함 ) 
        while (delete <k){
            delete++;
            st.pop();
        }
        
        
        while (!st.isEmpty()){
            answer+=st.pop();
        }
        
        StringBuilder sb= new StringBuilder(answer);
        answer = sb.reverse().toString();
        
        return answer;
    }
}