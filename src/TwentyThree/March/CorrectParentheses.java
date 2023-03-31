package TwentyThree.March;

import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        System.out.println(solution("(()))")); // false
        System.out.println(solution("(()(()))")); // true
        System.out.println(solution(")(()())")); // false
        System.out.println(solution("(())")); // true
        System.out.println(solution("())")); // false
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.empty()){
            return true;

        }else{
            return false;
        }
    }
}
