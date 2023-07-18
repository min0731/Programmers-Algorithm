
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Node {
		int x, y;
		char color;

		public Node(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	static int R, G, B, N, cnt, cnt2;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] visited2;
	static Queue<Node> que = new ArrayDeque<>();
	static Queue<Node> que2 = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		// 1. 이차원 배열에 값을 입력 받은 후
		// 2.포문을 통해 방문하지 않은 원소하나를 큐에 넣은 후 같은 색깔인 것을 확인
		// 3. 같은 색을 모두 확인 후 다시 포문을 돌며 같은 색깔인 것을 확인
		// 4. 적록색약인 사람과 그렇지 않은 사람의 방문 체크를 따로함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N]; // 적록색약이 아닌 사람의 방문체크
		visited2 = new boolean[N][N]; // 적록색약인 사람의 방문 체크
		R = 0;
		G = 0;
		B = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();

		} // 입력 받음
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					bfs(j, i);
				}
				if (visited2[i][j] == false) {
					bfs2(j, i);
				}
			}
		}
		System.out.print(cnt + " " + cnt2);

	}

	static void bfs(int x, int y) {

		que.add(new Node(x, y, map[y][x]));

		int nx, ny;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Node tmp = que.poll();
				for (int p = 0; p < 4; p++) {
					nx = tmp.x + dx[p];
					ny = tmp.y + dy[p];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[ny][nx] == false) {
						if (tmp.color == map[ny][nx]) {// 같은 색이면 돈다
							que.add(new Node(nx, ny, map[ny][nx]));
							visited[ny][nx] = true;
						}
					}
				} // for2
			} // for1

		} // while
		cnt += 1;
		return;
	}// bfs

	static void bfs2(int x, int y) {

		que2.add(new Node(x, y, map[y][x]));

		int nx, ny;
		while (!que2.isEmpty()) {
			int size = que2.size();
			for (int i = 0; i < size; i++) {
				Node tmp = que2.poll();
				for (int p = 0; p < 4; p++) {
					nx = tmp.x + dx[p];
					ny = tmp.y + dy[p];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited2[ny][nx] == false) {
						if (tmp.color == 'B' && 'B' == map[ny][nx]) {// 파란색인 경우
							que2.add(new Node(nx, ny, map[ny][nx]));
							visited2[ny][nx] = true;
						}
						if ((tmp.color == 'G' || tmp.color == 'R') && (map[ny][nx] == 'G' || map[ny][nx] == 'R')) {
							que2.add(new Node(nx, ny, map[ny][nx]));
							visited2[ny][nx] = true;
						}
					}
				} // for2
			} // for1

		} // while
		cnt2 += 1;
		return;
	}// bfs

}
