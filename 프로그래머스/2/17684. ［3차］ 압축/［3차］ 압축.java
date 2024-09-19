import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        // 사전 초기화 (A~Z 추가)
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            list.add(ch + "");
        }

        int start = 0;
        int end = 1;
        String now = "";
        String next = "";

        while (start < msg.length()) {
            // 현재 단어 추출
            now = msg.substring(start, end);

            // 사전에 없는 단어가 나올 때까지 끝을 늘려가며 검색
            while (end < msg.length() && list.contains(msg.substring(start, end + 1))) {
                end++;
                now = msg.substring(start, end);  // 현재 단어 갱신
            }

            // 사전에 있는 단어의 인덱스 추가
            answerList.add(list.indexOf(now) + 1);

            // 다음 단어가 사전에 없으면 사전에 추가
            if (end < msg.length()) {
                next = msg.substring(start, end + 1); // 다음 단어 추출
                list.add(next); // 사전에 추가
            }

            // 시작점 이동
            start = end;
            end = start + 1;
        }

        // 정답 배열에 리스트 값을 옮김
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
