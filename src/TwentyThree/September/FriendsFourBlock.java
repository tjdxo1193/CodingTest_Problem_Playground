package TwentyThree.September;

import java.util.HashSet;

public class FriendsFourBlock {

    /*
    블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.

만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다. 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.

블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.

만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다

입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
     */



    public static void main(String[] args) {

    }

    public int solution(int m, int n, String[] board) {
        int cnt = 0;
        char[][] adj = new char[m][n];
        HashSet<int[]> rm = new HashSet<>();
        for (int i = 0; i < m; i++) {
            char[] arr = board[i].toCharArray();
            adj[i] = arr;
        }

        while (true) {
            for (int k = 0; k < m; k++) {
                for (int j = 0; j < n; j++) {
                    char target = adj[k][j];
                    if (target == '0'){
                        continue;
                    }
                    if (adj[k+1][j] == target && adj[k][j+1] == target && adj[k+1][j+1] == target){
                        rm.add(new int[]{k, j});
                        rm.add(new int[]{k + 1, j});
                        rm.add(new int[]{k, j + 1});
                        rm.add(new int[]{k + 1, j + 1});
                    }

                }
            }
            if (!rm.isEmpty()) {
                cnt += rm.size();
                for (int[] coord : rm) {
                    int w = coord[0];
                    int e = coord[1];
                    adj[w][e] = '0';
                }
                rm.clear();
            } else {
                return cnt;
            }
            // Move blocks downward
            boolean moved = false;
            for (int i = m - 1; i >= 1; i--) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][j] == 0 && adj[i - 1][j] != 0) {
                        adj[i][j] = adj[i - 1][j];
                        adj[i - 1][j] = 0;
                        moved = true;
                    }
                }
            }

            // If no blocks were moved down, exit the loop
            if (!moved) {
                break;
            }
        }

        return cnt;
    }
}
