package TwentyThree.october;
import java.util.ArrayList;
import java.util.Scanner;

public class BackJun_CCTV {
    public static int N, M, CCTV_NUM;
    public static int[][] map;
    public static ArrayList<CCTV> list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static int cctvDirection[][][] = {
            {{0}},
            {{1}, {2}, {3}, {0}},
            {{1, 3}, {0, 2}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}}
    };
    public static int MIN_CNT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        int remain = N * M;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0 &&  map[i][j] != 6) {
                    list.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        CCTV_NUM = list.size();
        ArrayList<int []> pList = new ArrayList<>();
        bfs(pList);

        System.out.println(MIN_CNT);
    }

    private static void bfs(ArrayList<int []> pList) {
        if(pList.size() == CCTV_NUM) {
            // 순열이 완성됨. 사각지대 수를 계산
            int [][] newMap = new int[N][M];
            copy(newMap, map);
            int zeroCnt = 0;
            // newMap 에 그리기
            for (int i = 0; i < pList.size(); i++) {
                for (int j = 0; j < pList.get(i).length; j++) {
                    // cctv에 방향을 이용해서 map에 감시영역을 표시하는 함수
                    checkObservationArea(i, pList.get(i)[j], newMap);
                }
            }

            zeroCnt = findZeroInMap(newMap);
            MIN_CNT = Math.min(zeroCnt, MIN_CNT);

            return;
        }

        CCTV cctv = list.get(pList.size());


        // 해당 CCTV가 90도씩 회전하며 감시
        for (int j = 0; j < cctvDirection[cctv.num].length; j++) {

            ArrayList<int []> newPList = new ArrayList<>();
            for (int i = 0; i < pList.size(); i++) {
                newPList.add(pList.get(i));
            }

            int[] dir = cctvDirection[cctv.num][j];
            newPList.add(dir);
            bfs(newPList);
        }
    }

    private static void checkObservationArea(int cctvIdx, int cctvDir, int[][] newMap) {
        // 감시할 수 있는 영역의 수
        int cnt = 0;
        int cctvX = list.get(cctvIdx).x;
        int cctvY = list.get(cctvIdx).y;
        while(true) {
            cctvX += dx[cctvDir];
            cctvY += dy[cctvDir];
            // 범위를 벗어나거나 벽이 있다면
            if(cctvX < 0 || cctvX >= N || cctvY < 0 || cctvY >= M || newMap[cctvX][cctvY] == 6) return;

            // 다른 CCTV가 있거나 이미 감시된 영역일 경우 pass
            if((newMap[cctvX][cctvY] >= 1 && newMap[cctvX][cctvY] <= 5) || newMap[cctvX][cctvY] == -1) continue;

            // 빈 칸일 경우
            newMap[cctvX][cctvY] = -1;
        }
    }

    private static int findZeroInMap(int[][] newMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void copy(int[][] newMap, int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    public static class CCTV {
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }


}
