import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qixuanwang on 16/2/21.
 */
public class Hackerrank2_21_16 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nv = in.nextInt();
        int ne = in.nextInt();

        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<ne;i++){

            int u = in.nextInt();
            int v = in.nextInt();
            int cost = in.nextInt();

            if(u>v){
                int tmp = u;
                u = v;
                v = tmp;
            }

            String key = u+","+v;
            if(map.containsKey(key)){
                map.get(key).add(cost);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(cost);
                map.put(key,list);
            }
        }



    }


//    Problem No. 1
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] aList = new int[len];
//        int[] bList = new int[len];
//
//        for(int i=0;i<len;i++){
//            aList[i] = in.nextInt();
//        }
//        for(int i=0;i<len;i++){
//            bList[i] = in.nextInt();
//        }
//
//        int res = 0;
//
//        Set<Integer> set = new HashSet<>();
//        for(int p1=0;p1<len;p1++){
//            for(int p2=0;p2<len;p2++){
//                if(aList[p1]==bList[p2] && !set.contains(p2)){
//                    res++;
//                    set.add(p2);
//                    break;
//                }
//            }
//        }
//
//        System.out.println(res);
//    }
}
