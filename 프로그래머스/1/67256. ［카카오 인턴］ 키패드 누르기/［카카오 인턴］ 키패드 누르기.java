import java.util.*;

class Solution {
    /*
    
        시작 - 오: # / 왼:*
        오른손 3,6,9
        왼손: 1,4,7
        가까운 거리: 2,5,8,0
    
    */
    public String solution(int[] numbers, String hand) {
        String answer = "";
        List<Node> list = new ArrayList<>();
        
        //시작점 및 키패드 좌표 초기화 
        int right[] = {3,0};
        int left[] = {3,2};
        
        
        //인덱스 순서대로 찾기 때문에 0은 먼저 add해줌 
        list.add(new Node(3,1));
        list.add(new Node(0,0));
        list.add(new Node(0,1));
        list.add(new Node(0,2));
        list.add(new Node(1,0));
        list.add(new Node(1,1));
        list.add(new Node(1,2));
        list.add(new Node(2,0));
        list.add(new Node(2,1));
        list.add(new Node(2,2));
    
        for (int i =0; i<numbers.length; i++){
            Node node = list.get(numbers[i]);
            
            // 왼손으로 클릭 
            if (numbers[i] == 1 || numbers[i]== 4|| numbers[i]== 7){
                answer+= 'L';
                
                left[0] = node.y;
                left[1] = node.x;

            }
            // 오른손으로 클릭
            else if (numbers[i]== 3 || numbers[i]== 6 || numbers[i]== 9){
                answer+= 'R';
                
                right[0] = node.y;
                right[1] = node.x;
            }
            
            // 2,5,8,0 의 경우, 가까운 거리의 손으로 클릭
            else{
                int rightDistance = Math.abs(node.y - right[0])+ Math.abs(node.x - right[1]);
                
                int leftDistance = Math.abs(node.y - left[0])+ Math.abs(node.x - left[1]);
                // 왼손이 더 짧은 경우
                if (rightDistance > leftDistance) {
                    left[0] = node.y;
                    left[1] = node.x;
                    answer+='L';
                }
                else if (rightDistance < leftDistance){
                    right[0] = node.y;
                    right[1] = node.x;
                    answer+='R';
                }
                // 두 길이가 같은 경우 
                else {//오른손 잡이
                    if(hand.equals("right")) {
                        right[0] = node.y;
                        right[1] = node.x;
                        answer+='R';
                    }
                    else {// 왼손잡이
                        left[0] = node.y;
                        left[1] = node.x;
                        answer+='L';
                    }
                }
            } 
        }
        
        
        return answer;
    }
    
    public class Node {
        int x;
        int y; 
        
        public Node(int y, int x)
        {
            this.x=x;
            this.y=y;
        }    
    }
}


