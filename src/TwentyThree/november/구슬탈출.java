package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import static java.util.Arrays.stream;

public class 구슬탈출 {

    static char[][] map;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        map = new char[N][M];
        Board board = new Board();

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                switch (map[i][j]) {
                    case 'R' -> board.red = (new Point(j, i));
                    case 'B' -> board.blue = (new Point(j, i));
                    case 'O' -> Board.hole = (new Point(j, i));
                }
            }
        }//end input

        int answer = bfs(board);
        System.out.println(answer);
    }

    private static int bfs(Board board) {
        boolean[][][][] visit = new boolean[N][M][N][M];
        LinkedList<Board> q = new LinkedList<>();
        q.add(board);
        visit[board.red.y][board.red.x][board.blue.y][board.blue.x] = true;

        while (!q.isEmpty()) {
            Board curBoard = q.poll();
            if (curBoard.move > 9) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nextRX = curBoard.red.x;
                int nextRY = curBoard.red.y;
                int nextBX = curBoard.blue.x;
                int nextBY = curBoard.blue.y;

                while (isRange(nextRX + dx[i], nextRY + dy[i])) {
                    nextRX += dx[i];
                    nextRY += dy[i];

                    if (nextRX == Board.hole.x && nextRY == Board.hole.y)
                        break;
                }

                while (isRange(nextBX + dx[i], nextBY + dy[i])) {
                    nextBX += dx[i];
                    nextBY += dy[i];

                    if (nextBX == Board.hole.x && nextBY == Board.hole.y)
                        break;
                }

                if (Board.hole.x == nextBX && Board.hole.y == nextBY)
                    return -1;
                if (Board.hole.x == nextRX && Board.hole.y == nextRY) // 빨간색만 빠진경우 종료
                    return curBoard.move + 1;

                //dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
                if (nextRX == nextBX && nextRY == nextBY) { // 위치가 겹칠 경우 조정

                    switch (i) {
                        case 0 -> {
                            if (curBoard.red.y > curBoard.blue.y) nextBY -= 1;
                            else nextRY -= 1;
                        }
                        case 1 -> {
                            if (curBoard.red.y < curBoard.blue.y) nextBY += 1;
                            else nextRY += 1;
                        }
                        case 2 -> {
                            if (curBoard.red.x > curBoard.blue.x) nextBX -= 1;
                            else nextRX -= 1;
                        }
                        case 3 -> {
                            if (curBoard.red.x < curBoard.blue.x) nextBX += 1;
                            else nextRX += 1;
                        }
                    }
                }

                if (!visit[nextRY][nextRX][nextBY][nextBX]) { // 각 구슬의 위치가 처음 기록되는 경우만 push
                    visit[nextRY][nextRX][nextBY][nextBX] = true;
                    q.add(new Board(new Point(nextBX, nextBY), new Point(nextRX, nextRY), curBoard.move + 1));
                }
            }
        }

        return -1;
    }


    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N && y <= M && map[y][x] != '#';
    }


    static class Board {
        int move;
        Point blue, red;
        static Point hole;

        public Board() {
            this.move = 0;
        }

        public Board(Point blue, Point red, int move) {
            this.blue = blue;
            this.red = red;
            this.move = move;
        }

    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
