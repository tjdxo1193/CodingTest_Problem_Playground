package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.stream;

// 백준은 클래스 이름을 Main으로 해야한다.
public class _2048 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int answer;
    static int[][] map;

    // 백트래킹이 필요한 문제.
    // 합쳐지지 않으면 제외 해야하는가?
    // 4시 20분 풀기 시작 - 30분 정도 잡고 , 못풀면 답지..
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] input = stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }
//        Board board = new Board(map, 0);
        backTracking(0);
        System.out.println(answer);
    }


    static void backTracking(int cnt) {
        if (cnt == 5) {
            findMax();
        }

        int copy[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            backTracking(cnt + 1);
            for (int a = 0; a < N; a++) {
                map[a] = copy[a].clone();
            }
        }
    }

    private static void findMax() {
        answer = Math.max(answer, Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElseThrow());
    }

    public static void move(int dir) {
        switch(dir) {
            case 0:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }


    static class Board {
        int move;
        int[][] map;
        int max;

        public Board(int[][] map, int move) {
            this.move = move;
            this.map = deepCopyArr(map);
            this.max = findMaxNum(map);
        }

        private int[][] deepCopyArr(int[][] map) {
            int[][] copyMap = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            return copyMap;
        }

        private int findMaxNum(int[][] map) {
            return Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElseThrow();
        }
    }
}
