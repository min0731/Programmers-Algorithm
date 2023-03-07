import java.util.*;
class Solution {

    static int dy[] ={0,1,-1,0};
    static int dx[]={1,0,0,-1};
    
    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    
    public int[] solution(String[] maps) {
      List <Integer> tmp = new ArrayList<>();

        // 각 문자열을 parsing 해서 이차원 배열로 만듦 (char arr)
        int mapsLength = maps[0].length();
        char arr[][]= new char [maps.length][mapsLength];
       
        //////// char로 바꿔서 이를 이차원 배열로 만드는 것을 잘 못하는즁!
        for (int i=0; i<maps.length; i++){
           for (int j=0; j<mapsLength; j++){
              arr[i][j]= maps[i].charAt(j);
           }
        }
        
        // 방문했는지 여부를 파악하기 위한 배열(boolean isVisited)
        boolean isVisited[][] = new boolean [maps.length][mapsLength];
        
        // BFS 탐색 -> arr 배열을 돌면서 숫자를 발견하면 que에 add시켜줌 
        //BFS탐색을 위한 QUE선언
        Queue<Node> que = new LinkedList<Node>(); 
        
        int sum=0;
       for (int y=0; y<maps.length; y++){
           for (int x=0; x<mapsLength; x++){
            if (arr[y][x] != 'X' && isVisited[y][x]!=true){
                sum+=arr[y][x]-'0';
                que.add (new Node(y,x));
                isVisited[y][x]=true;
                
                while (!que.isEmpty()){
                    Node poll = que.poll();
                    
                    for (int i=0; i<4; i++){
                        int ny= dy[i]+poll.y;
                        int nx= dx[i]+poll.x;
                        
                        if ( ny >=0 && nx >=0 && ny <maps.length && nx <mapsLength && arr[ny][nx]!='X' && isVisited[ny][nx]!=true ){
                            //poll을 한 뒤 값이 유효하다면 add해줌 +=sum
                            sum+=arr[ny][nx] -'0';
                            que.add(new Node(ny, nx));
                            isVisited[ny][nx]=true;
                        }
                    }
                }
                // que가 비게 되면 지금까지의 합을 answer에 넣어줌
                 tmp.add(sum);
                 System.out.println(tmp.get(0));
                sum=0;
                
            }
           }
       }
         int answer[];
        // for 문을 통해서 방문하지 않은 노트를 탐색 
        if (tmp.size()!=0){
    answer = new int [tmp.size()];
         Collections.sort(tmp);
        
        for (int i=0; i<tmp.size(); i++){
            answer[i]=tmp.get(i);
        }
    }
    else { 
        answer= new int[1];
        answer[0]=-1;
         }
    return answer;
    }
}