/**
 * Created by qixuanwang on 15/10/29.
 */
public class Leetcode165 {

    public static void main(String[] args) {

        System.out.print(compareVersion("1.1","0"));
    }

    public static int compareVersion(String version1, String version2) {

        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");

        int i = 0;
        while(i<tokens1.length || i<tokens2.length){

            String s1 = "0";
            if(i<tokens1.length)
                s1 = tokens1[i];

            String s2 = "0";
            if(i<tokens2.length)
                s2 = tokens2[i];

            int v1 = Integer.valueOf(s1);
            int v2 = Integer.valueOf(s2);

            if(v1==v2){
                i++;
            } else if(v1<v2){
                return -1;
            } else{
                return 1;
            }
        }

        return 0;
    }

//    public static int compareVersion(String version1, String version2) {
//
//        String[] tokens1 = version1.split("\\.");
//        String[] tokens2 = version2.split("\\.");
//
//        int p1 = Integer.valueOf(tokens1[0]);
//        int p2 = Integer.valueOf(tokens2[0]);
//
//        if(p1!=p2){
//            return p1>p2? 1:-1;
//        }
//        else{
//            int q1,q2;
//
//            if(tokens1.length==2)
//                q1 = Integer.valueOf(tokens1[1]);
//            else
//                q1 = 0;
//
//            if(tokens2.length==2)
//                q2 = Integer.valueOf(tokens2[1]);
//            else
//                q2 = 0;
//
//            if(q1==q2)
//                return 0;
//            else{
//                return q1>q2? 1:-1;
//            }
//        }
//    }
}
