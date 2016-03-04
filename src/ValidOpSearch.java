import java.util.HashMap;

/**
 * Created by qixuanwang on 16/3/2.
 */
public class ValidOpSearch {

    boolean find = false;;

    public static void main(String[] args) {

        int[] nums = {60, 1, 3, 5, 20};

        ValidOpSearch vos = new ValidOpSearch();
        System.out.println(vos.valid(nums));
    }


    public boolean valid(int[] nums){

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else{
                map.put(num,1);
            }
        }

        helper(nums,map,'+',0);

        return find;
    }

    public void helper(int[] nums, HashMap<Integer,Integer> map, char lop, int lval){

        if(find)
            return;

        if(map.size()==0){
            if(lval==42)
                find = true;
            return;
        }

        for(int num: nums){
            if(map.containsKey(num)){

                HashMap<Integer,Integer> nmap = new HashMap<>(map);
                int count = nmap.get(num);
                count--;
                if(count==0){
                    nmap.remove(num);
                } else{
                    nmap.put(num,count);
                }

                int nval = lval;

                switch(lop){
                    case '+':
                        nval += num;
                        break;
                    case '-':
                        nval -= num;
                        break;
                    case '*':
                        nval *= num;
                        break;
                }

                helper(nums,nmap,'+',nval);
                helper(nums,nmap,'-',nval);
                helper(nums,nmap,'*',nval);
            }
        }
    }
}
