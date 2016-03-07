/**
 * Created by qixuanwang on 16/3/6.
 */
public class Leetcode273 {

    public static void main(String[] args) {

        Leetcode273 lt = new Leetcode273();
        System.out.println(lt.numberToWords(543));
    }

    public String numberToWords(int num) {

        if(num==0)
            return "Zero";

        StringBuilder sb = new StringBuilder("");
        if(num/1000000000!=0){
            sb.append(helper(num/1000000000) + " Billion");
            num%=1000000000;
        }
        if(num/1000000!=0){
            sb.append(" " + helper(num/1000000) + " Million");
            num%=1000000;
        }
        if(num/1000!=0){
            sb.append(" " + helper(num/1000) + " Thousand");
            num %= 1000;
        }
        if(num!=0){
            sb.append(" " + helper(num));
        }

        return sb.toString().trim();
    }

    public String helper(int num){
        StringBuilder sb = new StringBuilder("");
        if(num/100!=0){
            sb.append(decode(num/100) + " Hundred");
            num %= 100;
        }

        if(num>=20){
            if(num/10!=0){
                sb.append(" "+ decode(num/10*10));
                num %= 10;
            }
            if(num>0){
                sb.append(" "+decode(num));
            }
        } else{
            sb.append(" "+decode(num));
        }

        return sb.toString().trim();
    }

    public String decode(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Fourty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
            default: return "";
        }
    }
}
