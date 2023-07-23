import java.util.*;

class Solution {
    static int gameCnt;
    static int tmpArr [];
    static int answer;
    static boolean visited[];
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        gameCnt = dungeons.length;
        tmpArr = new int [gameCnt];
        visited= new boolean[gameCnt];
        permutation(0,k, dungeons);
        
        // 중복순열을 이용한 순서 뽑기 
        
        return answer;
    }
    
    public void permutation (int cnt,int k, int[][] dungeons){
        //다 뽑았을 경우 
        if (cnt == gameCnt){
            //System.out.println(tmpArr)
            int tmpCnt=0;
            for (int i=0; i< tmpArr.length; i++){
                for (int j=0; j<2; j++){
                    // k의 값이 더 크면 -> 탐험 시작
                    if (k >= dungeons[tmpArr[i]][0]){
                        k -= dungeons[tmpArr[i]][1];
                        tmpCnt+=1;
                    }
                    break;
                }
            }
            
            answer = Math.max(answer, tmpCnt);
            return;
        }
        
        for (int i =0; i< gameCnt; i++){
            if(visited[i]) continue;
            
            visited[i]= true;
            tmpArr[cnt] = i;
            permutation(cnt+1, k, dungeons);
            visited[i]=false;
        }
    }
}