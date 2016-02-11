/**
 * Created by qixuanwang on 15/8/28.
 *
 * KMP Algorithm
 */
public class Leetcode28 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
    }

    public static int strStr(String haystack, String needle) {
        int len = haystack.length();
        int n = needle.length();
        int[] next = new int[n];

        next(needle,next);

        if(len<n)
            return -1;

        for(int i=0;i<=len-n;i++){

            int match = 0;
            while(match<n && haystack.charAt(i+match)==needle.charAt(match)){
                match++;
            }

            if(match==n)
                return i;
            if(match>0){
                int nxt = next[match-1];
                i += match-nxt-1;
            }
        }

        return -1;
    }

    public static void next(String str, int[] next){
        int len = str.length();
        next[0] = 0;
        for(int i=1;i<len;i++){
            int pre = next[i-1];
            while(str.charAt(pre)!=str.charAt(i) && pre!=0){
                pre = next[pre-1];
            }
            if(str.charAt(pre)==str.charAt(i))
                next[i] = pre+1;
            else
                next[i] = 0;
        }
    }

//    public static int strStr(String haystack, String needle) {
//
//        if(haystack.length()==0 && needle.length()==0)
//            return 0;
//        if(haystack.length()==0 && needle.length()!=0){
//            return -1;
//        }
//        if(haystack.length()!=0 && needle.length()==0){
//            return 0;
//        }
//
//
//        int haystackLen = haystack.length();
//        int needleLen = needle.length();
//        int[] matchTab = new int[needleLen+1];
//
//        matchTab[0] = 0;
////        matchTab[1] = 0;
//
//        int idx=1,len=0;
//        while(idx<needleLen){
//            if(needle.charAt(idx)==needle.charAt(len))
//                matchTab[++idx] = ++len;
//            else if(len==0)
//                matchTab[++idx]= 0 ;
//            else
//                len = matchTab[len];
//        }
//
//        /*for(int i=2;i<=needleLen;i++){
//
//            String tmp = needle.substring(0,i);
//            int matchVal = 0;
//            for(int j=i-1;j>0;j--){
//                if((tmp.substring(0,j)).equals((tmp.substring(i-j)))) {
//                    matchVal = j;
//                    break;
//                }
//            }
//            matchTab[i] = matchVal;
//
//        }*/
//
//
//
//        int i=0, j=0;
//        while(i<haystackLen){
//            if(haystack.charAt(i) == needle.charAt(j)){
//                i++;
//                j++;
//                if(j==needleLen)
//                    return i-needleLen;
//            }
//            else if(j>0)
//                j=matchTab[j];
//            else
//                i++;
//        }
//
//        /*int i=0;
//
//        for(;i<haystackLen-needleLen;){
//            int matchCount = 0;
//            for(int x=0;x<needleLen;x++){
//                if(haystack.charAt(i+x)==needle.charAt(x)) {
//                    matchCount++;
//                    if(matchCount==needleLen)
//                        return i;
//                }
//                else {
//                    if(matchCount==0)
//                        i++;
//                    else
//                        i += matchCount - matchTab[x];
//                    break;
//                }
//            }
//        }*/
//
//        return -1;
//    }
}










