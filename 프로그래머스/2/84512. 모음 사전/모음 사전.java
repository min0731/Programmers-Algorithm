import java.util.*;

class Solution {
    static char[] alphaList={'A','E','I','O','U'};
    static ArrayList<String> dictionary;
    
    public int solution(String word) {
        int answer = 0;
        dictionary = new ArrayList<>();
        
        //모든 사전을 돌려서 저장 
        dfs("");
        for (int i=0; i<dictionary.size(); i++){
            if(dictionary.get(i).equals(word)) return answer;
            answer++;
        }
        
        
        return answer;
    }
    
    
    //사전 저장을 위한 dfs
    public void dfs (String alpha){
        
        dictionary.add(alpha);
        
        if (alpha.length() == 5) return;
        
        for (int i=0; i<5; i++){
            dfs(alpha+alphaList[i]);
        }
        
    }
}