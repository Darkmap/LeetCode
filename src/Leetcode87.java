/**
 * Created by qixuanwang on 16/1/18.
 */
public class Leetcode87 {

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "eatrg";
        System.out.println(isScramble(s1,s2));
    }

    public static boolean isScramble(String s1, String s2) {

        if(s1.length()!=s2.length())
            return false;

        if(s1.equals(s2))
            return true;

//        return helper1(s1,s2);
        int len = s1.length();
        int[][][] res = new int[len][len][len+1];

        return helper2(s1,s2,0,0, len,res);
    }


    /**
     * Brute force recursion solution, will get TLE, so it's ignored
     * @param s1
     * @param s2
     * @return
     */
    public static boolean helper1(String s1, String s2){

        int len = s1.length();

        if(len==1)
            return s1.equals(s2);

        for(int i=1;i<len;i++){

            if(helper1(s1.substring(0,i),s2.substring(0,i)) && helper1(s1.substring(i,len),s2.substring(i,len)))
                return true;

            if(helper1(s1.substring(0,i),s2.substring(len-i,len)) && helper1(s1.substring(i,len),s2.substring(0,len-i)))
                return true;
        }

        return false;
    }

    public static boolean helper2(String s1, String s2, int idx1, int idx2, int len, int[][][] res){

        if(len==1)
            return s1.charAt(idx1)==s2.charAt(idx2);

        int flag = res[idx1][idx2][len];

        if(flag!=0)
            return flag==1;

        flag = -1;

        for(int i=1;i<len;i++){
            if(helper2(s1,s2,idx1,idx2,i,res) && helper2(s1,s2,idx1+i,idx2+i,len-i,res)) {
                flag = 1;
                break;
            }

            if(helper2(s1,s2,idx1,idx2+len-i,i,res) && helper2(s1,s2,idx1+i,idx2,len-i,res)){
                flag = 1;
                break;
            }
        }

        res[idx1][idx2][len] = flag;
        return flag==1;
    }
}
