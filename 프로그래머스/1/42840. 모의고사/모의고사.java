import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        /*
            1. 찍는 방식의 배열 정의
            2. answers의 for문을 돌면서 각 학생들의 맞은 개수를 카운트
            3. 최댓값으로 많이 맞은 애를 기준으로 비교 후 출력
                3-1. 높은 점수를 받은 사람이 여러명일 수 있음(가변)
                    -> 리스트를 통해서 늘려야함.
        */
        
        int oneList[]={1,2,3,4,5};
        int twoList[] ={2,1,2,3,2,4,2,5};
        int threeList[]= {3,3,1,1,2,2,4,4,5,5};
        
        int one = 0, two = 0, three = 0;
        
        for (int i=0; i<answers.length; i++){
            if (oneList[i% oneList.length] == answers[i]) one += 1;
            if (twoList[i% twoList.length] == answers[i]) two +=1;
            if (threeList[i% threeList.length] == answers[i]) three += 1;
        }
        
        int maxCore = Math.max(one,Math.max(two, three));
        
        ArrayList <Integer> list = new ArrayList<Integer>();
        
        if(maxCore <= one) list.add(1);
        if(maxCore <= two) list.add(2);
        if(maxCore <= three) list.add(3);
        
        int solution [] = new int [list.size()];
        
        for (int i=0; i<list.size(); i++){
            solution[i] = list.get(i).intValue();
        }
        
        return solution;
    }
}