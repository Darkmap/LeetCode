import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/1.
 */
public class KAryTree<T>{

    private KATNode<T> root;

    static class KATNode<T>{
        T value;
        ArrayList<KATNode> children;
        public KATNode(T value){
            this.value = value;
            children = new ArrayList<>();
        }

        public void addChild(KATNode child){
            this.children.add(child);
        }

        public KATNode getChild(int idx){
            if(children.size()>idx)
                return children.get(idx);
            else
                return null;
        }


        public List<String> toArray(){

            List<String> res = new ArrayList<>();

            res.add(this.value.toString());

            if(this.children.size()>0){
                res.add("{");
            }

            for(KATNode<T> node: children){
                res.addAll(node.toArray());
            }

            if(this.children.size()>0){
                res.add("}");
            }

            return res;
        }

        public static KATNode<Integer> recoverFromArray(List<String> array){

            if(array.size()==0)
                return null;

            KATNode<Integer> root = new KATNode<>(Integer.valueOf(array.get(0)));

            int len = array.size();
            if(len>1){
                int start = 2;
                int end = 2;
                while(start<len-1){
                    if(start==len-2 || !array.get(start+1).equals("{")){
                        root.addChild(new KATNode(Integer.valueOf(array.get(start))));
                        start++;
                    } else{
                        int count = 0;
                        for(int i=start+1;i<len-1;i++){
                            String cur = array.get(i);
                            if(cur.equals("{"))
                                count++;
                            else if(cur.equals("}"))
                                count--;
                            if(count==0){
                                end = i+1;
                                break;
                            }
                        }
                        root.addChild(recoverFromArray(array.subList(start,end)));
                        start = end;
                    }
                }
            }
            return root;
        }

    }




    public static void main(String[] args) {

        KATNode<Integer> n1 = new KATNode<>(1);
        KATNode<Integer> n2 = new KATNode<>(2);
        KATNode<Integer> n3 = new KATNode<>(3);
        KATNode<Integer> n4 = new KATNode<>(4);
        KATNode<Integer> n5 = new KATNode<>(5);
        KATNode<Integer> n6 = new KATNode<>(6);
        KATNode<Integer> n7 = new KATNode<>(7);
        KATNode<Integer> n8 = new KATNode<>(8);

        n1.addChild(n2);
        n1.addChild(n3);
        n1.addChild(n4);
        n3.addChild(n5);
        n3.addChild(n6);
        n6.addChild(n7);
        n6.addChild(n8);


        List<String> list = n1.toArray();
        for(String str: list){
            System.out.print(str + " ");
        }

        KATNode<Integer> root = KATNode.recoverFromArray(list);
        System.out.print(root.value);
    }

}