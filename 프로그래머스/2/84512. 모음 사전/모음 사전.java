import java.util.*;

class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'}; 
    static List<String> list;

    public int solution(String word) {
        list = new ArrayList<>();
        String str = "";

        dfs("", 0);
        return list.indexOf(word);
    }

    public void dfs(String str, int cnt) {
        
        list.add(str);  // 현재의 str을 리스트에 추가
        
        if (cnt == 5) { // 종료 조건: 길이가 5 이상인 경우
            return; 
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(str + alpha[i], cnt + 1);  // str에 알파벳을 하나 추가한 상태로 재귀 호출
        }
    }
}