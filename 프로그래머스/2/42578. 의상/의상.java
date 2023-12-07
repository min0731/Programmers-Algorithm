import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer =1;
        HashMap <String, Integer> map = new HashMap<>();
        
        //getOrDefalut를 사용 -> 있으면 +1, 없으면 1해줌 
        for (String [] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
        }
        
        // 조합일때는 어떻게 구현해야하지?
         int result = 1;
        for(String key : map.keySet()){
            result *= (map.get(key) + 1);
        }
        return result-1;
    }
}