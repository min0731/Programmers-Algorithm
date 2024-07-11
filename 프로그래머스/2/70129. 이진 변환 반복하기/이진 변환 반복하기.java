import java.util.*;

class Solution {
    public int[] solution(String s) {
        /*
            1. S에 담긴 0 제거 및 제거한 0의 갯수 카운트
            2. 0을 제거한 길이 저장
            3. 2번에서 구한 것을 토대로 이진변환
                3-1.%를 이용한 나머지 계산을 통해 이진법으로 바꿈 
            4. 이진변환 결과를 통해서 x가 1이 될 때까지 반복
        */
        
        int removedZeroCnt = 0; // 제거한 0의 갯수
        int afterRemovalCnt = 0; // 0을 제거한 뒤 문자의 갯수
        int  binaryCnt = 0;
        
        while (!s.equals("1")){ 
            String x ="";
            
            binaryCnt+=1;
            for (char tmp : s.toCharArray()){
                if (tmp != '0') x += Character.toString(tmp);
                else removedZeroCnt += 1;
            }

            // 제거된 후 문자열의 길이 저장 
            afterRemovalCnt = x.length();
            s="";

            // 이진 변환 
             while (afterRemovalCnt > 0){
                s += Integer.toString(afterRemovalCnt % 2);
                afterRemovalCnt /= 2;
            }

            // 뒤집힌 상태로 저장되니까 다시 원래대로 뒤집어 줌 
            StringBuffer sb = new StringBuffer(s);
            s = sb.reverse().toString();
            
            afterRemovalCnt = 0;
        }
        
        int answer[] = {binaryCnt,removedZeroCnt};
        
        return answer;
    }
}