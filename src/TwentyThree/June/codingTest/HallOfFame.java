package TwentyThree.June.codingTest;

import java.util.PriorityQueue;

public class HallOfFame {

    public static void main(String[] args) {

    }
    public int[] solution(int[] score, int k) {
        int[] result = new int[score.length];
        PriorityQueue<Integer> rank = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            rank.add(score[i]);
            if (i >= k) rank.poll();
            result[i] = rank.peek();
        }
        return result;
    }

}
