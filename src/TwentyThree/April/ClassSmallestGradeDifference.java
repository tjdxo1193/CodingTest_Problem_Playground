package TwentyThree.April;

import java.util.ArrayList;
import java.util.List;

public class ClassSmallestGradeDifference {

//     오름차순으로 정렬된 성적들 int 배열과, int n 줄때
//     int 배열과 int n을 줄때 int 배열은 오름차순으로 정렬된 학생들의 성적을 나타내는 배열이고,
//     n은 성적차이가 가장 작은 학생들로 반을 나눌 반 개수이다.
//     이때 각 반에 성적이 가장 낮은 사람과 높은 사람의 차이의 합을 구해보시오
// 인접한 사람들끼리인가??
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 2;
        int nClass[] = new int[n];
//        1 / 2, 3, 4
//        1, 2/ 3,4
//        1, 2, 3/ 4
//
//        1 / 2/ 3, 4
//        1, 2/ 3/ 4
//        1/ 2, 3/ 4
//
//        1 / 2, 3
//        1, 2 / 3

        solution(n, nClass);
    }

    class Group{
        List<Integer> scores;
        public Group(List<Integer> scores) {
            this.scores = scores;
        }
    }

    static List<Group> groups = new ArrayList<>();
    static int minResult = 0;

    public static int solution(int nthClass, int[] scores) {
        dfs(1, nthClass, scores);
        return minResult;
    }

    /*
    시간복잡도 n^2!
4
1,2,3,4,5,6,7,8
                        root
                   1                        1,2          1,2,3     1,2,3,4         1,2,3,4,5        .... (m.length - 4 + 1)
        2    2,3   2,3,4  2,3,4,5  2,3,4,5,6  - 4      3             1                              ..... 5*4*3*2*1 4!
      3456  4,5,6  5,6    6                                                                                     4!

    */
        // 다음 class 반
    public static void dfs(int depth, int nthClass, int[] scores){
        // 종료 및 계산 조건 - 반이 다 만들어 졌을떄 즉, depth 가 n일때.
        if (depth == nthClass) {
            int scoreSum = 0;


            if(scoreSum > minResult) {
                minResult = scoreSum;
            }
            return;
        }

        for (int i = 0; i < nthClass; i++ ){
//            groups.add(new groups());
//            하나 선택하고 보내고 하나에 하나를 더해서 선택하고 보내고
            dfs(depth+1, nthClass, scores);

        }
    }
}
