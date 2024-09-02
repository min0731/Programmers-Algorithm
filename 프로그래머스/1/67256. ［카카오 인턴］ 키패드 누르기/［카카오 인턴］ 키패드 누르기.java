import java.util.*;

class Solution {
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {3, 0};  // 왼손 초기 위치는 * 위치
        int[] right = {3, 2}; // 오른손 초기 위치는 # 위치
        
        List<int []> list = new ArrayList<>();
        
        list.add(new int[]{3,1});
        list.add(new int[]{0, 0});
        list.add(new int[]{0, 1});
        list.add(new int[]{0, 2});
        list.add(new int[]{1, 0});
        list.add(new int[]{1, 1});
        list.add(new int[]{1, 2});
        list.add(new int[]{2, 0});
        list.add(new int[]{2, 1});
        list.add(new int[]{2, 2});
        
        for (int i=0; i< numbers.length; i++){
            if (numbers[i]== 1 || numbers[i]== 4 || numbers[i]== 7){
                answer+="L";
                left =list.get(numbers[i]);
                
            }
            else if (numbers[i]== 3 || numbers[i]== 6 || numbers[i]== 9){
                answer+="R";
                right = list.get(numbers[i]);
            }
            else { // 2, 5, 8, 0의 경우
                
                int[] target = list.get(numbers[i]);
                
                int leftDistance = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rightDistance = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                
                if (leftDistance < rightDistance) {
                    answer += "L";
                    left = target;
                } else if (rightDistance < leftDistance) {
                    answer += "R";
                    right = target;
                } else { // 거리가 같을 때
                    if (hand.equals("right")) {
                        answer += "R";
                        right = target;
                    } else {
                        answer += "L";
                        left = target;
                    }
                }
            }
        }
        
        
        
        
        return answer;
    }
}