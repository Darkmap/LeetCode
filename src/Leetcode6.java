/**
 * Created by qixuanwang on 15/8/24.
 */
public class Leetcode6 {

    public static void main(String[] args){

        String origin = "PAYPALISHIRING";
        int n = 5;

        String converted = convert(origin, n);
        String recovered = zigzagRestroe(converted, n);
        System.out.println(origin);
        System.out.println(recovered);
        System.out.println(origin.equals(recovered));

    }


    public static String zigzagRestroe(String str, int numRows){

        if(numRows<=1)
            return str;

        int once = numRows*2-2;
        int len = str.length();
        int time = len%once==0?len/once:len/once+1;

        int[] counter = new int[numRows];

        counter[0] = time;
        counter[numRows-1] = len%once>=numRows? len/once+1 : len/once;

        for(int i=1;i<numRows-1;i++){
            counter[i] = len/once*2;
            if(len%once>i){
                counter[i]++;
            }
            if(len%once-numRows>=numRows-i-1){
                counter[i]++;
            }
            counter[i] += counter[i-1];
        }
        counter[numRows-1] += counter[numRows-2];

        String ans = "";

        int[] idxs = new int[numRows];

        for(int i=0;i<time;i++){
            int k = 0;
            for(;k<numRows;k++){
                int offset = getIdx(counter,k,idxs[k]);
                if(offset>=counter[k])
                    return ans;
                ans = ans+str.charAt(offset);
                idxs[k]++;
            }
            k-=2;
            for(;k>0;k--){
                int offset = getIdx(counter,k,idxs[k]);
                if(offset>=counter[k])
                    return ans;
                ans = ans+str.charAt(offset);
                idxs[k]++;
            }
        }

        return ans;

    }

    public static int getIdx(int[] counter, int x, int y){
        if(x==0)
            return y;
        else
            return counter[x-1]+y;
    }

    public static String convert(String s, int numRows) {

        if(numRows==1)
            return s;

        int len = s.length();

        char[] charArray = new char[len];
        int charIdx = 0;



        for(int i=0;i<numRows;i++){
            if(i==0 || i==numRows-1){
                int tmpIdx = i;
                while(tmpIdx < len) {
//                    idxList.add(tmpIdx);
                    charArray[charIdx++] = s.charAt(tmpIdx);
                    tmpIdx += 2*numRows-2;
                }
            }
            else{
                int tmpIdx = i;
                while(tmpIdx < len){
//                    idxList.add(tmpIdx);
                    charArray[charIdx++] = s.charAt(tmpIdx);
                    int adjIdx = tmpIdx + 2*(numRows-i)-2;
                    if(adjIdx<len)
                        charArray[charIdx++] = s.charAt(adjIdx);
//                        idxList.add(adjIdx);
                    tmpIdx += 2*numRows-2;
                }
            }
        }

        return new String(charArray);
    }


}
