import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int dp[] = new int [y+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        
        for (int i=x; i<y+1; i++){
              // 만약 dp[i]가 여전히 최댓값이라면, 해당 숫자로는 도달할 수 없으므로 스킵
            if (dp[i] == Integer.MAX_VALUE) continue;
            
            if(i+n <= y) dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            if (i*2 <= y) dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            if (i*3 <= y) dp[i*3]= Math.min(dp[i*3], dp[i]+1);
        }
        
        if(dp[y] == Integer.MAX_VALUE ) return -1;
        else return dp[y];
    }
}