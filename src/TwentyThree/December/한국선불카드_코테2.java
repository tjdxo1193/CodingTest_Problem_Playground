package TwentyThree.December;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 한국선불카드_코테2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 아이디, 비밀번호, 확인용 비밀번호 입력
        String userId = scanner.nextLine();
        String password = scanner.nextLine();
        String confirmPassword = scanner.nextLine();

        // 아이디 유효성 검사
        if (isValidUserId(userId)) {
            // 비밀번호와 확인용 비밀번호가 일치하고, 비밀번호가 유효한 경우 pass 출력
            if (password.equals(confirmPassword) && isValidPassword(password)) {
                System.out.println("pass");
            } else {
                System.out.println("fail");
            }
        } else {
            System.out.println("fail");
        }
    }

    // 아이디 유효성 검사 메서드
    private static boolean isValidUserId(String userId) {
        String regex = "^[a-z0-9]{3,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userId);
        return matcher.matches();
    }

    // 비밀번호 유효성 검사 메서드
    private static boolean isValidPassword(String password) {
        // 비밀번호는 8글자 이상, 20글자 이하
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        // 알파벳 대/소문자, 숫자, 특수기호(@#S) 각각 하나 이상 포함
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#S]).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
