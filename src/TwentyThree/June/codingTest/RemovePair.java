package TwentyThree.June.codingTest;

import java.util.Stack;

public class RemovePair {
    public static void main(String[] args) {
        RemovePair removePair = new RemovePair();
        System.out.println(removePair.solution1_효율성실패("qqqqwqqwsvvsbaabaa"));
        System.out.println(removePair.solution("qqqqwqqwsvvsbaabaa"));
    }

    public int solution(String s)
    {
        // 스택 문제 일거같은데... -> 중괄호 닫기 열기 하는 문제랑 같은듯
        // 스택에 b 들어갔는데 다음 a들어감 근데 다시 같은게 들어가면 pop,
        Stack<String> stack = new Stack<>();
        String[] strArr = s.split("");

        for (int i = 0; i < strArr.length; i++) {
            // 맨위에 있는게 현재 들어갈것과 같다면 pop
            if (!stack.empty() && stack.peek().equals(strArr[i])) {
                stack.pop();
                continue;
            }

            stack.push(strArr[i]);
        }

        // stack이 비었다면 1 있으면 0
        return stack.empty() ? 1 : 0;
    }

    public int solution1_효율성실패(String s)
    {
        int answer = 0;
        String temp = "";

        // 효율성 테스트 실패...
        while (!s.equals(temp)){
            temp = s;
            s = s.replaceAll( "(.)\\1" , "");
        }

        // 스택 문제 일거같은데...
        // 스택에 b 들어갔는데 다음 a들어감 근데 다시 같은게 들어가면 pop,

        if(s.equals("")){
            answer = 1;
        }

        return answer;
    }
}
