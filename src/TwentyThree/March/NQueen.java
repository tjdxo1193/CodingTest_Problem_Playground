package TwentyThree.March;

public class NQueen {
    /*
        N-Queen
        문제 설명
        가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.

        예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.

        Imgur
        Imgur

        체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.

        제한사항
        퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
        n은 12이하의 자연수 입니다.
        입출력 예
        n	result
        4	2
        입출력 예 설명
        입출력 예 #1
        문제의 예시와 같습니다.
     */

    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    static int 퀀_놓을수_있는_총_가짓수 = 0;
    static int[] arr;
    static int N;
    public static int solution(int n) {
        N = n;
        백트랙킹(0);

        return 퀀_놓을수_있는_총_가짓수;
    }

    private static boolean 유망한지(int 깊이){
        for(int i = 0; i < 깊이; i++){
            if(arr[i] == arr[깊이]){
                return false;
            }

            if(Math.abs(i - 깊이) == Math.abs(arr[i] - arr[깊이])){
                return false;
            }
        }
        return true;
    }

    private static void 백트랙킹(int 깊이) {
        if(깊이 == N){
            퀀_놓을수_있는_총_가짓수++;
            return;
        }

        for(int i = 0; i < N; i ++){
            arr[깊이] = i;
            if(유망한지(깊이)){
             백트랙킹(깊이 + 1);
            }
        }

    }


}
