import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = "";
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j < s.length(); j += i) {
                String sub;
                if (j + i > s.length()) {
                    sub = s.substring(j);
                } else {
                    sub = s.substring(j, j + i);
                }

                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed += count + prev;
                    } else {
                        compressed += prev;
                    }
                    prev = sub;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed += count + prev;
            } else {
                compressed += prev;
            }

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }}
