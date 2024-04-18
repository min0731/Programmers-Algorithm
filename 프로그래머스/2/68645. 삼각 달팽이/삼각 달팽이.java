import java.util.*;

class Solution {
    public int[] solution(int n) {
        int [] dy={1,0,-1};
        int [] dx={0,1,-1};
        
        int num = 1;
        int[][] arr = new int [n][n];
        int x=0, y=0;
        
        while(true){
         // 1. 아래로 이동 
            while(true){
                arr[y][x]= num++;
                    
                int ny = y+dy[0];
                int nx = x+dx[0];
                
                if (ny==n || arr[ny][x] !=0) break;
                x=nx;
                y=ny;
            }
            
            if (x+1==n || arr[y][x+1] !=0) break;
            //오른쪽으로 한칸 이동
            x+=1;
            
        // 2. 오른쪽으로 이동 
            while(true){
                arr[y][x]= num++;
                    
                int ny = y+dy[1];
                int nx = x+dx[1];
                
                if (nx==n || arr[y][nx] !=0) break;
                x=nx;
                y=ny;   
            }
            if (y-1==-1 || x-1== -1 || arr[y-1][x-1] !=0) break;
            y-=1;
            x-=1;
            
        // 3. 대각선 위로 이동
            while(true){
                arr[y][x]= num++;
                
                int ny = y+dy[2];
                int nx = x+dx[2];
                
                if (arr[ny][nx] != 0 || ny==-1 || nx == -1) break;
                x=nx;
                y=ny;   
                
            }
            if (arr[y+1][x] != 0 || y+1==n ) break;
            y+=1;
            
        }
        
        int[] answer = new int [num-1];
        int count=0;
        
        for (int i=0; i< n; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j]!=0){
                answer [count++] = arr[i][j];
               
                //System.out.print(arr[i][j]);
                }
            }
        }
        
        
        
        return answer;
    }
}