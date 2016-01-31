import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by qixuanwang on 16/1/29.
 */
public class Hackerrank4 {

    static long size = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();

        int[] base = new int[4];
        base[0] = A;
        base[1] = B;
        base[2] = C;
        base[3] = D;

        HashMap<String, Long> map = new HashMap<>();
        helper(base,map,'R');
        helper(base,map,'B');

        System.out.println(size % (1000000007));
    }

    public static void helper(int[] base, HashMap<String,Long> map, char last){

//        System.out.println(size);

        if(base[0]==0 && base[1]==0 && base[2]==0 && base[3]==0){
            size++;
            return;
        }

        String hash = base[0]+","+base[1]+","+base[2]+","+base[3];
        if(last=='B')
            hash = base[2]+","+base[3]+","+base[0]+","+base[1];

        if(map.containsKey(hash)) {
            size += map.get(hash);
            return;
        }

        long oldSize = size;

        if(last=='R'){
            if(base[0]>0){
                int[] newBase = Arrays.copyOf(base,4);
                newBase[0]--;
                helper(newBase,map, 'R');
            }
            if(base[1]>0){
                int[] newBase = Arrays.copyOf(base,4);
                newBase[1]--;
                helper(newBase,map, 'B');
            }
        }
        else{
            if(base[2]>0){
                int[] newBase = Arrays.copyOf(base,4);
                newBase[2]--;
                helper(newBase,map, 'B');
            }
            if(base[3]>0){
                int[] newBase = Arrays.copyOf(base,4);
                newBase[3]--;
                helper(newBase,map, 'R');
            }
        }
        map.put(hash, (size - oldSize)%(1000000007));
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int A = in.nextInt();
//        int B = in.nextInt();
//        int C = in.nextInt();
//        int D = in.nextInt();
//
//        ArrayList<Integer> base = new ArrayList<>();
//        base.add(A);
//        base.add(B);
//        base.add(C);
//        base.add(D);
//
//        HashMap<String, Long> map = new HashMap<>();
//        helper(base,map,'R');
//        helper(base,map,'B');
//
//        System.out.println(size % (1000000007));
//    }
//
//    public static void helper(ArrayList<Integer> base, HashMap<String,Long> map, char last){
//
////        System.out.println(size);
//
//        if(base.get(0)==0 && base.get(1)==0 && base.get(2)==0 && base.get(3)==0){
//            size++;
//            return;
//        }
//
//        String hash = base.get(0)+","+base.get(1)+","+base.get(2)+","+base.get(3);
//        if(last=='B')
//            hash = base.get(2)+","+base.get(3)+","+base.get(0)+","+base.get(1);
//
//        if(map.containsKey(hash)) {
//            size += map.get(hash);
//            return;
//        }
//
//        long oldSize = size;
//
//        if(last=='R'){
//            if(base.get(0)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(0, newbase.get(0) - 1);
//                helper(newbase,map, 'R');
//            }
//            if(base.get(1)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(1, newbase.get(1)-1);
//                helper(newbase,map, 'B');
//            }
//        }
//        else{
//            if(base.get(2)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(2, newbase.get(2)-1);
//                helper(newbase,map, 'B');
//            }
//            if(base.get(3)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(3, newbase.get(3) - 1);
//                helper(newbase, map, 'R');
//            }
//        }
//        map.put(hash, (size - oldSize)%(1000000007));
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int A = in.nextInt();
//        int B = in.nextInt();
//        int C = in.nextInt();
//        int D = in.nextInt();
//
//        ArrayList<Integer> base = new ArrayList<>();
//        base.add(A);
//        base.add(B);
//        base.add(C);
//        base.add(D);
//
//        helper(base,'R',"R");
//        helper(base,'B',"B");
//
//        System.out.println(size % (1000000007));
//    }
//
//    public static void helper(ArrayList<Integer> base, char last, String pre){
//
//        if(base.get(0)==0 && base.get(1)==0 && base.get(2)==0 && base.get(3)==0){
//            size++;
//            return;
//        }
//
//        if(last=='R'){
//            if(base.get(0)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(0, newbase.get(0)-1);
//                helper(newbase, 'R', new String(pre+'R'));
//            }
//            if(base.get(1)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(1, newbase.get(1)-1);
//                helper(newbase, 'B', new String(pre+'B'));
//            }
//        }
//        else{
//            if(base.get(2)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(2, newbase.get(2)-1);
//                helper(newbase, 'B', new String(pre+'B'));
//            }
//            if(base.get(3)>0){
//                ArrayList<Integer> newbase = new ArrayList<>(base);
//                newbase.set(3, newbase.get(3)-1);
//                helper(newbase, 'R', new String(pre+'R'));
//            }
//        }
//    }


}
