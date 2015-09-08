/**
 * Created by qixuanwang on 15/8/24.
 */
public class Leetcode6 {

    public static void main(String[] args){

        System.out.println(convert("A",1));
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
