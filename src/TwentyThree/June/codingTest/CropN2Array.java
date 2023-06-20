package TwentyThree.June.codingTest;

public class CropN2Array {
    public static void main(String[] args) {

    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) right - (int) left + 1];

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[(int)(i-left)] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }
}
