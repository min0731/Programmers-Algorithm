import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap <String, Integer> map = new HashMap <>();
        
        for (int i=0; i<clothes.length; i++){
            // 카테고리에 따라 카운트
            // 없으면 0에서 +1 , 있으면 기존 카테고리 갯수에 +1 
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
            
        // 의상별 조합 
        // 상의: 0/1/2개   하의: 0/1/2/3개 
        // 그러나 뭐든 하나는 걸쳐야하니 0,0일때만 빼줌 (-1)
        
        // 모든 키들을 반환
        for (String key: map.keySet()){
            answer *= map.get(key)+1;
        }
        System.out.println(map.entrySet());
    return answer -1;
    }
}