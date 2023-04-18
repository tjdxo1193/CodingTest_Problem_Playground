package TwentyThree.April;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthDigit {

    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        int n = 10;
        int m = 3;
        answer.add(m);
        int temp = m;


        while (true) {
            temp += m;
            if (temp%n == 0) {
                break;
            }
            answer.add(temp%n);
            System.out.println(temp%n);
        }
    }

    public static void solution(int n, int m) {


    }


}
