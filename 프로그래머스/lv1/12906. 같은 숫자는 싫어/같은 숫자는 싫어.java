import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       //연속적으로 같은 숫자는 싫단말이지?
        Stack<Integer> stack = new Stack <Integer>();
        
        stack.push(arr[0]);
        for (int i=1; i<arr.length; i++){
           // System.out.println(stack.peek() + " " + arr[i]);
            if (stack.peek() != arr[i])
                stack.push (arr[i]);
        }
       //System.out.println(stack);
        int[] answer =new int [stack.size()];
        int size= stack.size();
        
        for (int i=size-1; i>=0; i--){
            
             answer[i]= stack.peek();
             stack.pop();
        }

        return answer;
    }
}