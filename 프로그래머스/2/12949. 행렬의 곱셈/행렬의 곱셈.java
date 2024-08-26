import java.util.*;


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr2[0].length];
        int sum=0;
        
        // 행
        for (int i=0; i<arr1.length; i++ ){
            for (int j = 0; j<arr2[0].length; j++){
                for (int z=0; z< arr1[0].length; z++){
                    sum+= arr1[i][z] * arr2[z][j];
                }
                answer[i][j]=sum;
                sum=0;
            }
        }
    
            
        return answer;
    }
}