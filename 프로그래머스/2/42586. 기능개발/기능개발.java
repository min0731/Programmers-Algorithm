import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        List<Integer> resultList = new ArrayList<>();
        int arrCnt = 1;

        // 각 작업이 완료되는데 필요한 일수를 계산합니다.
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 0;
            while (progresses[i] + speeds[i] < 100 + speeds[i]) {
                progresses[i] += speeds[i];
                tmp++;
            }
            arr[i] = tmp;
        }

        // 배포 그룹을 계산합니다.
        for (int idx = 0; idx < arr.length; idx++) {
            int tmp = arr[idx];  // 현재 기준 작업의 일수
            arrCnt = 1;  // 현재 배포 그룹의 크기

            // 다음 작업들과 비교하여 함께 배포할 수 있는지 확인합니다.
            while (idx + 1 < arr.length && arr[idx + 1] <= tmp) {
                arrCnt++;
                idx++;
            }

            // 배포 그룹의 크기를 결과 리스트에 추가합니다.
            resultList.add(arrCnt);
        }

        // List를 배열로 변환합니다.
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}
