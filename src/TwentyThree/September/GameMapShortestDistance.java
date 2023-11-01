package TwentyThree.September;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GameMapShortestDistance {


    /*
    ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.

지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.

     위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.

첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.

게임 맵의 상태 maps가 매개변수로 주어질 때,
캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
     */
    public static void main(String[] args) {
        GameMapShortestDistance gameMapShortestDistance = new GameMapShortestDistance();

        System.out.println(gameMapShortestDistance.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

    private static int minCount = 999999999;

    public int solution(int[][] maps) {
        int n = maps.length-1;
        int m = maps[0].length - 1;
        int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx <= n && 0 <= ny && ny <= m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int destination = maps[n][m];

        if (destination == 1) {
            answer = -1;
        }else {
            answer = destination;
        }

        return answer;

    }

    public int solution2(int[][] maps) {
        // maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
        int x = 0;
        int y = 0;
        int cnt = 1;

        bfs2(maps, x, y, cnt);
        return minCount == 999999999 ? -1 : minCount;
    }

    private void bfs2(int[][] maps, int x, int y, int count) {
        if (maps[y][x] == 0) {
            return;
        }
        if (y == maps.length - 1 && x == maps[0].length - 1) {
            minCount = Math.min(minCount, count);
            return;
        }
        maps[y][x] = 0;
        if (y + 1 < maps.length) {
            bfs2(maps, x, y + 1, count + 1);
        }
        if (x + 1 < maps[0].length){
            bfs2(maps, x + 1, y, count + 1);
        }
        if (x - 1 >= 0) {
            bfs2(maps, x - 1, y, count + 1);
        }
        if (y - 1 >= 0) {
            bfs2(maps, x, y - 1, count + 1);
        }
    }

}
