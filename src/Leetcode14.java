/**
 * Created by qixuanwang on 15/8/25.
 */
public class Leetcode14 {

    public static void main(String[] args){

        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        if(len==0)
            return "";


        int minI = 0;
        int minLen = strs[0].length();

        for(int i=1;i<len;i++){
            int curLen = strs[i].length();
            if(minLen>curLen){
                minI = i;
                minLen = curLen;
            }
        }

        if(minLen==0)
            return "";

        int b = 0;
        int e = minLen-1;
        String minStr = strs[minI];

        int max = -1;

        while(b<=e){

            int mid = b + (e-b)/2;
            String cut = minStr.substring(0,mid+1);

            boolean ok = true;
            for(String str: strs){
                if(!str.startsWith(cut)){
                    ok = false;
                    break;
                }
            }

            if(ok){
                max = Math.max(max,mid);
                b = mid+1;
            } else{
                e = mid-1;
            }
        }

        if(max==-1)
            return "";

        return strs[minI].substring(0,max+1);
    }


//    public static String longestCommonPrefix2(String[] strs) {
//        int n = strs.length;
//        if(n==0)
//            return "";
//
//        int minL = strs[0].length();
//        int minI = 0;
//        for(int i=1;i<n;i++){
//            if(minL>strs[i].length()){
//                minL = strs[i].length();
//                minI = i;
//            }
//        }
//
//        if(minL==0)
//            return "";
//
//        int b = 0;
//        int e = minL-1;
//        int max = -1;
//
//
//        while(b<=e){
//            int m = (b+e)/2;
//            String p = strs[minI].substring(0,m+1);
//            boolean flag = true;
//            for(String str: strs){
//                if(!str.startsWith(p)){
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                max = Math.max(max,m);
//                b = m+1;
//            } else{
//                e = m-1;
//            }
//        }
//
//        return strs[minI].substring(0,max+1);
//    }
//
//    public static String longestCommonPrefix(String[] strs) {
//
//        if(strs.length==0)
//            return "";
//
//        int len = 0;
//
//        do{
//            if(strs[0].length()<len+1)
//                break;
//            char tmp = strs[0].charAt(len);
//            boolean flag = true;
//            for(int i=1;i<strs.length;i++){
//                if(strs[i].length()<len+1){
//                    flag = false;
//                    break;
//                }
//                if(tmp!=strs[i].charAt(len)){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                len++;
//            }
//            else
//                break;
//        }while(true);
//
//        return strs[0].substring(0,len);
//    }
}
