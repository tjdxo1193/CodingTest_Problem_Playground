package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1_SWEA_d4 {

    static int [][] map;
    static int N=100, arriveX, arriveY, answer;

    static int [] dx = {0,0,-1};
    static int [] dy = {-1,1,0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int tc=0;tc<10;tc++) {
            int t = Integer.parseInt(br.readLine());

            map = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==2) {
                        arriveX = i;
                        arriveY = j;
                    }
                }
            }
            move(arriveX, arriveY);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());

    }
    private static void findDepartmentPoint(int x, int y) {
        int ly = y-1;
        int ry = y+1;
        boolean flag = false;
        while (x >= 0) {
            for (; x >= 0; x--) {
                if (range(x, ly) && map[x][ly] == 1) {
                    flag = false;
                    break;
                }
                if (range(x, ry) && map[x][ry] == 1) {
                    flag = true;
                    break;
                }
            }
            // 올라가는 구간 찾기 -> 이동
            if (x >= 0 && !flag) {
                for (; y >= 0; y--){
                    if(map[x][y] == 0){
                        y++;
                        break;
                    }
                }
            }
            if (x >= 0 && flag){
                for (; y < N; y++){
                    if(map[x][y] == 0){
                        y--;
                        break;
                    }
                }
            }
            ly = y - 1;
            ry = y + 1;

        }
        answer = y;
    }
    public static void move(int x, int y) {

        while(true) {
            if(x==0) {
                answer = y;
                break;
            }
            for(int i=0;i<3;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(range(nx,ny) && map[nx][ny]==1) {
                    map[x][y] = 3;
                    x = nx; y=ny;
                }
            }
        }
    }

    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

}
