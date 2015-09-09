import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qixuanwang on 15/9/8.
 */
public class Leetcode43 {

    public static void main(String[] args) {

        System.out.print("Res: "+multiply2("0", "12"));
    }


    public static String multiply2(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if(len1<len2){


            String num3;
            num3 = num1;
            num1 = num2;
            num2 = num3;

            int tmp;
            tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        StringBuffer res = new StringBuffer();
        int overDigit = 0;

        for(int i=0;i<len1+len2;i++){


            int currDigit = overDigit;

            for(int j=0;j<=i;j++){

                int idx1 = len1 - 1 - (i - j);
                int idx2 = len2 - 1 - (j);

                if(idx1 >= 0 && idx1 <len1 && idx2 >= 0 && idx2 <len2) {
                    int digit1 = num1.charAt(len1 - 1 - (i - j)) - '0';
                    int digit2 = num2.charAt(len2 - 1 - j) - '0';

                    currDigit += digit1*digit2;

                }
            }


            overDigit = currDigit / 10;
            currDigit = currDigit % 10;
            res.append(""+currDigit);


        }

        System.out.println("Ans: " + Integer.valueOf(num1) * Integer.valueOf(num2));

        while(res.lastIndexOf("0") == res.length()-1 && res.length()>1)
            res.deleteCharAt(res.length()-1);

        return res.reverse().toString();

//        String resStr = res.reverse().toString();
//        Pattern pattern = Pattern.compile("0|[1-9][0-9]*");
//        Matcher matcher = pattern.matcher(resStr);
//        if(matcher.find()) {
//            resStr = matcher.group();
//            return resStr;
//        }
//        else
//            return "";
    }


    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if(len1<len2){


            String num3;
            num3 = num1;
            num1 = num2;
            num2 = num3;

            int tmp;
            tmp = len1;
            len1 = len2;
            len2 = tmp;
        }

        StringBuffer res = new StringBuffer();
        int overDigit = 0;

        for(int i=0;i<len1+len2;i++){


            int currDigit = overDigit;

            for(int j=0;j<=i;j++){

                int idx1 = len1 - 1 - (i - j);
                int idx2 = len2 - 1 - (j);

                if(idx1 >= 0 && idx1 <len1 && idx2 >= 0 && idx2 <len2) {
                    int digit1 = num1.charAt(len1 - 1 - (i - j)) - '0';
                    int digit2 = num2.charAt(len2 - 1 - j) - '0';

                    currDigit += digit1*digit2;

                }
            }


            overDigit = currDigit / 10;
            currDigit = currDigit % 10;

            res.append(""+currDigit);


        }

        System.out.println("Ans: "+ Integer.valueOf(num1)*Integer.valueOf(num2));

        String resStr = res.reverse().toString();
        Pattern pattern = Pattern.compile("0|[1-9][0-9]*");
        Matcher matcher = pattern.matcher(resStr);
        if(matcher.find()) {
            resStr = matcher.group();
            return resStr;
        }
        else
            return "";
    }

}
