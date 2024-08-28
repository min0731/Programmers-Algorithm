import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        // 이동한 경로를 저장할 HashSet
        HashSet<String> visitedPaths = new HashSet<>();
        
        // 현재 위치
        int x = 0, y = 0;
        
        // 방향에 따른 위치 변화량
        int[][] directions = {
            {0, 1},  // U: 위쪽으로 이동
            {0, -1}, // D: 아래쪽으로 이동
            {1, 0},  // R: 오른쪽으로 이동
            {-1, 0}  // L: 왼쪽으로 이동
        };
        
        // 방향 문자와 인덱스 매핑
        char[] directionChars = {'U', 'D', 'R', 'L'};
        
        // 명령어 처리
        for (char dir : dirs.toCharArray()) {
            int dirIndex = -1;
            
            // 현재 방향 문자에 맞는 인덱스를 찾음
            for (int i = 0; i < directionChars.length; i++) {
                if (dir == directionChars[i]) {
                    dirIndex = i;
                    break;
                }
            }
            
            if (dirIndex == -1) continue; // 유효하지 않은 방향이면 무시
            
            // 새로운 위치 계산
            int newX = x + directions[dirIndex][0];
            int newY = y + directions[dirIndex][1];
            
            // 경계 검사
            if (newX < -5 || newX > 5 || newY < -5 || newY > 5) {
                continue; // 격자판을 벗어나면 무시
            }
            
            // 이동한 구간을 문자열로 기록
            String pathFrom = x + "," + y;
            String pathTo = newX + "," + newY;
            
            // 구간을 양방향으로 기록 (중복 방지)
            if (!pathFrom.equals(pathTo)) {
                String forwardPath = pathFrom + "->" + pathTo;
                String backwardPath = pathTo + "->" + pathFrom;
                
                if (!visitedPaths.contains(forwardPath) && !visitedPaths.contains(backwardPath)) {
                    visitedPaths.add(forwardPath);
                }
            }
            
            // 위치 업데이트
            x = newX;
            y = newY;
        }
        
        // 처음 걸어본 길의 총 길이 반환
        return visitedPaths.size();
    }
}
