import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        // hash값에 넣어줌 -> get을 통해 가져올 수 없으므로 넣음과 동시에 중복 확인 
        // key-value의 관계: value의 값은 중복이 됨 -> 
        for (String [] s : clothes){
            map.put(s[1], map.getOrDefault(s[1],0)+1);
        }
        
        for (String key: map.keySet()){
             answer *= map.get(key)+1;
        }
        
        return answer-=1;
    }
}