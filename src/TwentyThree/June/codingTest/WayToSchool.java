package TwentyThree.June.codingTest;

public class WayToSchool {
    /*
    가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

제한사항
격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
물에 잠긴 지역은 0개 이상 10개 이하입니다.
집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
     */

    public static void main(String[] args) {
        WayToSchool wayToSchool = new WayToSchool();
        int[][] pu = {{2,2}};
        System.out.println(wayToSchool.solution(4, 3, pu));
    }
    private static int TOTAL_WAY = 0;
    private static int[][] PUDDLES;
    private static int M = 0;
    private static int N = 0;

    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        int homeX = 1;
        int homeY = 1;
        PUDDLES = puddles;
        recursiveFunction(homeX, homeY);
        return TOTAL_WAY;
    }

    public void recursiveFunction(int x, int y) {
        // 벽을 넘은 경우 1
        if(x > M){
            return;
        }

        // 벽을 넘은 경우 2
        if (y > N) {
            return;
        }

        // 물웅덩이 밟으면
        for (int i = 0; i < PUDDLES.length; i++) {
            if(x == PUDDLES[i][0] && y == PUDDLES[i][1]){
                return;
            }
        }

        // 골인 ++
        if (x == M && y == N) {
            TOTAL_WAY++;
            return;
        }

        // 아래 , 오른쪽 하나씩
        recursiveFunction(x, y+1);
        recursiveFunction(x+1, y);
    }
}
