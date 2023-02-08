package TwentyThree.February;

public class ErrorNumber {
    public static void main(String[] args) {
        int num = 30103;
        int num2 = 99999;
        int num3 = 99992;
        System.out.println(errorNumber(num));
    }
    public static int errorNumber(int num){
        String strNumDefault = String.valueOf(num);
        String maxNum = strNumDefault;
        String minNum = strNumDefault;

        // max 값
        for(int i = 0; i < strNumDefault.length(); i++){
            char currentCharNum = strNumDefault.charAt(i);
            if(currentCharNum == '9'){
                continue;
            }else{
                maxNum = maxNum.replaceAll(String.valueOf(currentCharNum), "9");
                break;
            }
        }

        // min 값
        for(int k = 0; k < strNumDefault.length(); k++){
            char currentCharNum = strNumDefault.charAt(k);
            if(currentCharNum == '0'){
                continue;
            }else{
                if(k > 0){
                    minNum = minNum.replaceAll(String.valueOf(currentCharNum), "0");
                    break;
                }else{
                    if(currentCharNum != '1'){
                        minNum = minNum.replaceAll(String.valueOf(currentCharNum), "1");
                        break;
                    }
                }
            }
        }
        System.out.println("maxNum : " + maxNum);
        System.out.println("minNum : " + minNum);
        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }
}
