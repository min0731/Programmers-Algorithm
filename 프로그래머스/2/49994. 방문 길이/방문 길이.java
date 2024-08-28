import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> visited = new HashSet<>();
        int y = 5, x = 5; // 0 ~ 10 이라고 가정
        int ny =5, nx =5;

        for (char dir : dirs.toCharArray()) {

            // 이동할 방향에 따라 새로운 좌표를 계산
            if (dir == 'U') {
                if (ny -1  > -1) ny = y - 1;
                else continue;
            } else if (dir == 'D') {
                if (ny+1 < 11) ny = y + 1;
                else continue;
            } else if (dir == 'R') {
                if (nx+1 < 11) nx = x + 1;
                else continue;
            } else if (dir == 'L') {
                if (nx-1 > -1) nx = x - 1;
                else continue;
            }

            // 이동 경로를 문자열로 표현(양방향)
            String path1 = y + "," + x + "->" + ny + "," + nx;
            String path2 = ny + "," + nx + "->" + y + "," + x;

            // 경로가 처음 방문한 경우에만 카운트
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            // 현재 위치를 업데이트
            y = ny;
            x = nx;
        }

        return answer;
    }
}