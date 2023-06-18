package TwentyThree.June.codingTest;

public class SecretMap {
    public static void main(String[] args) {

    }
    /*

    비밀지도
    네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
    그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
    다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

    지도는 한 변의 길이가 n인 정사각형 배열 형태로,
    각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
    전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
    각각 "지도 1"과 "지도 2"라고 하자.
    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
    "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
    암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1,
    공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

     */

    // 왜 실패했을까..
    public String[] solution_4번5번실패(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int result;
        String resultBinStr;
        for (int i = 0; i < n; i++) {
            // or 비트연산
            result = arr1[i]|arr2[i];
            resultBinStr = Integer.toBinaryString(result);

            resultBinStr = resultBinStr.replace("1", "#");
            resultBinStr = resultBinStr.replace("0", " ");
            // replace로 1 => # , 0 => 공백으로 바꿔서 전체지도 만들기
            answer[i] = resultBinStr;
            if(answer[i].length() != n){
                for(int j = 0; j < n - answer[i].length(); j++){
                    answer[i] = " " + answer[i];
                }
            }
        }

        return answer;
    }

    // 올바른 풀이
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String bi;
        for (int i = 0; i < n; i++) {
            // or 비트연산
            bi = Integer.toBinaryString(arr1[i] | arr2[i]);
            bi = "0".repeat(n - bi.length()) + bi;
            answer[i] = bi.replaceAll("1", "#").replaceAll("0", " ");
        }

        return answer;
    }
}
