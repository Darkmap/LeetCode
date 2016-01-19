/**
 * Created by qixuanwang on 16/1/18.
 */
public class Leetcode97 {

    public static void main(String[] args) {


        System.out.println(isInterleave("ab","bc","babc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len3!=len1+len2)
            return false;

        if(len1==0 && len2==0)
            return true;
        if(len1==0)
            return s2.equals(s3);
        if(len2==0)
            return s1.equals(s3);

        int[][] res = new int[len1+1][len2+1];

        res[0][0] = 1;

        helper(s1,s2,s3,len1,len2,res);

        return res[len1][len2]==1;
    }

    public static boolean helper(String s1, String s2, String s3, int idx1, int idx2, int[][] res){

        if(idx1==0 && idx2==0)
            return true;


        int flag = res[idx1][idx2];

        if(flag!=0)
            return flag==1;

        flag = -1;

        int idx3 = idx1+idx2;

        if(idx1>0 && s1.charAt(idx1-1)==s3.charAt(idx3-1)){
            flag = helper(s1,s2,s3,idx1-1,idx2,res)? 1:-1;
        }

        if(flag!=1 && idx2>0 && s2.charAt(idx2-1)==s3.charAt(idx3-1)){
            flag = helper(s1,s2,s3,idx1,idx2-1,res)? 1:-1;
        }

        res[idx1][idx2] = flag;
        return flag==1;

    }
}
