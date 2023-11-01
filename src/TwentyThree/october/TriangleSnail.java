package TwentyThree.october;

import java.util.Arrays;

public class TriangleSnail {

    /*
정수 n이 매개변수로 주어집니다.
다음 그림과 같이 밑변의 길이와 높이가
n인 삼각형에서 맨 위 꼭짓점부터 반시계
방향으로 달팽이 채우기를 진행한 후,
첫 행부터 마지막 행까지 모두 순서대로
합친 새로운 배열을 return 하도록
solution 함수를 완성해주세요.

examples.png

제한사항
n은 1 이상 1,000 이하입니다.
입출력 예
n	result
4	[1,2,9,3,10,8,4,5,6,7]
5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.
입출력 예 #2

문제 예시와 같습니다.
입출력 예 #3

문제 예시와 같습니다.


DP 문제 같은딩..

     */

    public static void main(String[] args) {
        TriangleSnail triangleSnail = new TriangleSnail();
        System.out.println(Arrays.toString(triangleSnail.solution(6)));
        //1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11
    }

    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];

        // nxn의 도화지
        int[][] triangleArr = new int[n][n];
        int drawNum = 0;
        int ordNum = 1;
        while (drawNum < n){
            if (drawNum % 3 == 0) {
                for (int k = 0; k < n - (drawNum/3) * 3; k++){
                    triangleArr[(drawNum/3) * 2 + k][(drawNum / 3)] = ordNum++;
                }
                drawNum++;
                continue;
            }
            if (drawNum % 3 == 1) {
                for (int l = 1; l < n - (drawNum/3) * 3; l++){
                    triangleArr[(n-1) - (drawNum/3)][l + (drawNum/3)] = ordNum++;
                }
                drawNum++;
                continue;
            }
            if (drawNum % 3 == 2) {
                for (int j = n-2; j > (drawNum/3) * 3; j--){
                    triangleArr[j - (drawNum/3)][j - (drawNum/3) * 2] = ordNum++;
                }
                drawNum++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i+1; k++) {
                answer[idx++] = triangleArr[i][k];
            }
        }

        return answer;
    }

}
