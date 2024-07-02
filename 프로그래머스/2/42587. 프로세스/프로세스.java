import java.util.*;

// class Node implements Comparable<Node> {
//     int index;
//     int number;
    
//     public Node(int index, int number){
//         this.index= index;
//         this. number= number;
//     }
    
//     @Override
//     public int compareTo(Node node) {
//         // if(node.number== this.number) {
//         //     return node.index - this.index;
//         // }
//         // else 
//         return node.number - this.number;
//     }
    
//     @Override
// 		public String toString() {
// 			return "[index=" + index + ", number=" + number + "]";
// 		}
// }

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue <Integer> que = new PriorityQueue <>(Collections.reverseOrder());
        
        for (int i=0; i<priorities.length; i++){
            que.add(priorities[i]);
        }
        
        while(!que.isEmpty()){
          for (int i=0; i<priorities.length; i++){
              if(priorities[i] ==que.peek()){
                  que.poll();
                  answer++;
                  if(i==location){
                      return answer;
                  }
              }
          }
        }
        return answer;
    }
}