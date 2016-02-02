/**
 * Created by qixuanwang on 16/2/1.
 */
public class Leetcode13 {

    static int idx = 0;
    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(romanToInt2("MCMXCVI"));
    }

    public static int romanToInt2(String s) {
        int len = s.length();
        if(len==0)
            return 0;

        char cur = s.charAt(idx);
        if(cur=='M'){
            while(idx<len){
                cur = s.charAt(idx);
                if(cur=='M'){
                    sum += 1000;
                    idx++;
                }
                else{
                    break;
                }
            }
        }

        helper(s,len,'D','M','C',100);
        helper(s,len,'L','C','X',10);
        helper(s,len,'V','X','I',1);

        return sum;
    }

    public static void helper(String s, int len, char five, char ten, char one, int time){

        if(idx>=len)
            return;

        char cur  = s.charAt(idx);
        if(cur==one){
            if(idx+1<len && s.charAt(idx+1)==five){
                sum += 4*time;
                idx+=2;
            }
            else if(idx+1<len && s.charAt(idx+1)==ten){
                sum += 9*time;
                idx+=2;
            }
            else{
                while(idx<len){
                    cur = s.charAt(idx);
                    if(cur==one){
                        sum += time;
                        idx++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(cur==five){
            sum += 5*time;
            idx++;
            while(idx<len){
                cur = s.charAt(idx);
                if(cur==one){
                    sum += time;
                    idx++;
                }
                else{
                    break;
                }
            }
        }
    }


    public static int romanToInt(String s) {

        int len = s.length();
        if(len==0)
            return 0;

        int i = 0;
        int sum = 0;

        char cur = s.charAt(i);
        if(cur=='M'){
            while(i<len){
                cur = s.charAt(i);
                if(cur=='M'){
                    sum += 1000;
                    i++;
                }
                else{
                    break;
                }
            }
        }

        if(cur=='C'){
            if(i+1<len && s.charAt(i+1)=='D'){
                sum += 400;
                i+=2;
            }
            else if(i+1<len && s.charAt(i+1)=='M'){
                sum += 900;
                i+=2;
            }
            else{
                while(i<len){
                    cur = s.charAt(i);
                    if(cur=='C'){
                        sum += 100;
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(cur=='D'){
            sum += 500;
            i++;
            while(i<len){
                cur = s.charAt(i);
                if(cur=='C'){
                    sum += 100;
                    i++;
                }
                else{
                    break;
                }
            }
        }


        if(i<len){
            cur = s.charAt(i);
        }
        else
            return sum;

        if(cur=='X'){
            if(i+1<len && s.charAt(i+1)=='L'){
                sum += 40;
                i+=2;
            }
            else if(i+1<len && s.charAt(i+1)=='C'){
                sum += 90;
                i+=2;
            }
            else{
                while(i<len){
                    cur = s.charAt(i);
                    if(cur=='X'){
                        sum += 10;
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(cur=='L'){
            sum += 50;
            i++;
            while(i<len){
                cur = s.charAt(i);
                if(cur=='X'){
                    sum += 10;
                    i++;
                }
                else{
                    break;
                }
            }
        }

        if(i<len){
            cur = s.charAt(i);
        }
        else
            return sum;

        if(cur=='I'){
            if(i+1<len && s.charAt(i+1)=='V'){
                sum += 4;
            }
            else if(i+1<len && s.charAt(i+1)=='X'){
                sum += 9;
            }
            else{
                while(i<len){
                    cur = s.charAt(i);
                    if(cur=='I'){
                        sum += 1;
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        else if(cur=='V'){
            sum += 5;
            i++;
            while(i<len){
                cur = s.charAt(i);
                if(cur=='I'){
                    sum += 1;
                    i++;
                }
                else{
                    break;
                }
            }
        }
        return sum;
    }
}
