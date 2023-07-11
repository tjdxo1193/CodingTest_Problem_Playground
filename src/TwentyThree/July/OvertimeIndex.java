package TwentyThree.July;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeIndex {
    /*
    야근 지수
        문제 설명
        회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
        야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
        Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
        퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.

        제한 사항
        works는 길이 1 이상, 20,000 이하인 배열입니다.
        works의 원소는 50000 이하인 자연수입니다.
        n은 1,000,000 이하인 자연수입니다.
     */
    public static void main(String[] args) {
        OvertimeIndex overtimeIndex = new OvertimeIndex();
        int[] works = {4, 3, 3};
        System.out.println(overtimeIndex.solution( 4, works ));
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            priorityQueue.add(works[i]);
            sum += works[i];
        }

        // 어쩌피 계산하면 0 됨
        if (sum <= n) {
            return 0;
        }

        int temp = 0;
        while (n > 0) {
            temp = priorityQueue.poll();
            temp--;
            priorityQueue.add(temp);
            n--;
        }

        while (!priorityQueue.isEmpty()) {
            temp = priorityQueue.poll();
            answer += Math.pow(temp, 2);
        }

        return answer;
    }
}
