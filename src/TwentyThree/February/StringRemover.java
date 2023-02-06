package TwentyThree.February;

public class StringRemover {
    public static void main(String[] args) {
        String testStr = "AAAWSWSWSDAWAWSS"; // => D
        String testStr2 = "AAAWSWSWSAWAWSS"; // => -1
        String testStr3 = "SAWSAWADWDSS"; // => SAWADWDSS

        System.out.println(stringRemover(testStr));
    }

    public static String stringRemover(String str){
        if(str.contains("AWS")){
            return stringRemover(str.replaceAll("AWS", ""));
        }else{
            return str.equals("") ? "-1" : str;
        }
    }
}
