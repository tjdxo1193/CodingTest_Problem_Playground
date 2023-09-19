package TwentyThree.September;

import java.util.ArrayList;
public class HowToLineUp {

    /*
    문제 설명
        n명의 사람이 일렬로 줄을 서고 있습니다.
        n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
        n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다.
        예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

        [1, 2, 3]
        [1, 3, 2]
        [2, 1, 3]
        [2, 3, 1]
        [3, 1, 2]
        [3, 2, 1]
        사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
        k번째 방법을 return하는 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {

    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            arr.add(i);
        }
        
        int 카운트 = 1;
        long k대신 = k;

        while (카운트 <= n) {

            long 몫 = k대신 / factorial(n - 카운트);
            long 나머지 = k대신 % factorial(n - 카운트);

            if (나머지 != 0) {
                answer[카운트 - 1] = arr.get(Long.valueOf(몫).intValue() + 1);
                arr.remove(Long.valueOf(몫).intValue() + 1);
                k대신 = 나머지;
            } else {
                answer[카운트 - 1] = arr.get(Long.valueOf(몫).intValue());
                arr.remove(Long.valueOf(몫).intValue());
                for (int i = 1; i < arr.size(); i++) {
                    answer[카운트 - 1 + i] = arr.get(arr.size() - i);
                }
                break;
            }

            카운트++;
        }

        return answer;
    }
    static long factorial(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
