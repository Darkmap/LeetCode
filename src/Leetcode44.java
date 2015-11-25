/**
 * Created by qixuanwang on 15/11/24.
 */
public class Leetcode44 {

    public static void main(String[] args) {
        String s = "aabb";
        String p = "*?aa*";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {

        int l1 = s.length();
        int l2 = p.length();

        int i1 = 0;
        int i2 = 0;

        boolean flag = false;
        int preS = 0;
        int preP = 0;

        while(i1<l1){
            if(i2<l2 && (s.charAt(i1)==p.charAt(i2) || p.charAt(i2)=='?')){
                i1++;
                i2++;
            }
            else if(i2<l2 && p.charAt(i2)=='*'){
                while(i2<l2 && p.charAt(i2)=='*'){
                    i2++;
                }
                if(i2==l2)
                    return true;
                flag = true;
                preP = i1;
                preS = i2;
            }
            else if(flag){
                i1 = ++preP;
                i2 = preS;
            }
            else
                return false;
        }

        while(i2<l2 && p.charAt(i2)=='*'){
            i2++;
        }

        if(i1==l1 && i2==l2)
            return true;

        return false;
    }

    /**
     * TLE method
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {

        if(s==null && p==null)
            return true;
        else if(s==null || p==null){
            return false;
        }
        return matchHelper(s,p,0,0,s.length(),p.length());

    }

    public static boolean matchHelper(String s, String p, int id1, int id2, int l1, int l2){


        int len1 = l1-id1;
        int len2 = l2-id2;

        if(len1==0 && len2==0){
            return true;
        }
        else if(len2==0){
            return false;
        }
        else if(len1==0){
            int i = id2;
            while(i<len2){
                if(p.charAt(i)!='*')
                    return false;
                else
                    i++;
            }
            return true;
        }
        else{
            char bit1 = s.charAt(id1);
            char bit2 = p.charAt(id2);
            if(bit2=='*'){
                while(id2<l2 && p.charAt(id2)=='*')
                    id2++;
                //What if id2 >= l2
                if(id2>=l2){
                    return true;
                }
                char flag = p.charAt(id2);
                if(flag=='?'){
                    int tmpIdx=id1;
                    while(tmpIdx<len1){
                        if(matchHelper(s,p,tmpIdx+1,id2+1,l1,l2))
                            return true;
                        else
                            tmpIdx++;
                    }
                    return false;
                }
                else{
                    int tmpIdx=s.indexOf(flag+"",id1);
                    while(tmpIdx!=-1){
                        if(matchHelper(s,p,tmpIdx+1,id2+1,l1,l2))
                            return true;
                        else
                            tmpIdx=s.indexOf(flag+"",tmpIdx+1);
                    }
                    return false;
                }
            }
            else if(bit2=='?'){
                return matchHelper(s,p,id1+1,id2+1,l1,l2);
            }
            else{
                if(bit1!=bit2)
                    return false;
                else{
                    return matchHelper(s,p,id1+1,id2+1,l1,l2);
                }
            }
        }

    }
}
