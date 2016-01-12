import java.util.*;
import java.util.List;

/**
 * Created by Qixuan on 2015/12/10.
 */
public class APrepare {

    public static void main(String[] args) {


        /*int[] array = {5,5,5,3,4,7,6,8,9};
        quickSort(array,0,array.length-1);
        for(int num: array){
            System.out.print(num+" ");
        }*/

        /*PriorityQueue<Block> queue = new PriorityQueue<>(new BlockComparator());
        queue.add(new Block(0));
        queue.add(new Block(7));
        queue.add(new Block(2));
        queue.add(new Block(1));
        queue.add(new Block(3));


        while(!queue.isEmpty()){
            System.out.println(queue.remove().distance);
        }*/

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(5);

        String code = TreeManipulation.serialize(head);

        TreeManipulation.printByLevel(head);
        System.out.println(code);

        TreeNode root = TreeManipulation.deserialize(code);
        TreeManipulation.printByLevel(root);
    }

    public static int kmp(String str, String ptn){

        int len1 = str.length();
        int len2 = ptn.length();

        if(len2==0 || len1==0)
            return -1;

        int[] part = new int[len2];
        for(int i=1;i<=len2;i++){
            String sub = ptn.substring(0,i);
            for(int j=i-1;j>=1;j--){
                String pre = sub.substring(0,j);
                String suf = sub.substring(i-j,i);
                if(pre.equals(suf)) {
                    part[i-1]=j;
                    break;
                }
            }
        }

        for(int i=0;i<len1;){
            int match = -1;
            for(int j=0;j<len2;j++){
                int idx1 = i+j;

                if(idx1>=len1)
                    return -1;

                char bit1 = str.charAt(idx1);
                char bit2 = ptn.charAt(j);
                if(bit1==bit2){
                    match++;
                }
                else{
                    if(match==-1)
                        i += 1;
                    else
                        i += (match+1 - part[match]);
                }
            }
            if(match==len2-1){
                return i;
            }
        }

        return -1;
    }

    public static void quickSort(int[] array, int begin, int end){

        if(begin>=end){
            return;
        }
        if(begin==end-1){
            if(array[begin]>array[end]){
                int tmp = array[begin];
                array[begin] = array[end];
                array[end] = tmp;
            }
            return;
        }

        int i = begin+1;
        int j = end;
        while(i<j){
            while(i<=end && array[i]<=array[begin]){
                i++;
            }
            while(j>begin && array[j]>=array[begin]){
                j--;
            }
            if(i<j){
                int tmp = array[i];
                array[i] = array[j];
                array[end] = tmp;
            }
        }
        int tmp = array[begin];
        array[begin] = array[j];
        array[j] = tmp;

        quickSort(array,begin,j-1);
        quickSort(array,j+1,end);
    }

    public static boolean repeatContain(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        StringBuilder sb = new StringBuilder(s1);
        int times = len2/len1+1;
        for(int i=0;i<times;i++)
            sb.append(s1);
        System.out.println(sb);

        return sb.toString().contains(s2);
    }

    public static String longestCommonSubString(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1==0 || len2==0)
            return "";

        int max = 0;
        int idx = 0;

        int[][] res = new int[len1][len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(i==0 || j==0){
                    res[i][j] = s1.charAt(i)==s2.charAt(j)? 1:0;
                }
                else{
                    res[i][j] = s1.charAt(i)==s2.charAt(j)? 1 + res[i-1][j-1]:0;
                }
                if(res[i][j] > max){
                    max = res[i][j];
                    idx = i-max+1;
                }
            }
        }

        return s1.substring(idx, idx + max);

    }

    public static String longestCommonSubSequence(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1==0 || len2==0)
            return "";

        int[][] res = new int[len1][len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(i==0 || j==0){
                    if(s1.charAt(i)==s2.charAt(j)){
                        res[i][j] = 1;
                    }
                    else if(i!=0 && res[i-1][j]==1){
                        res[i][j] = 1;
                    }
                    else if(j!=0 && res[i][j-1]==1){
                        res[i][j] = 1;
                    }
                }
                else{
                    int last = Math.max(res[i-1][j-1],Math.max(res[i-1][j],res[i][j-1]));
                    if(s1.charAt(i)==s2.charAt(j))
                        res[i][j] = last+1;
                    else
                        res[i][j] = last;
                }
            }
        }

        return readLCSequence(res,s1,s2,len1-1,len2-1);

    }

    public static String readLCSequence(int[][] res, String s1, String s2, int i, int j){
        if(i==0 || j==0){
            if(s1.charAt(i)==s2.charAt(j))
                return s1.charAt(i)+"";
            else{
                if(i==0)
                    return readLCSequence(res,s1,s2,i,j-1);
                else
                    return readLCSequence(res,s1,s2,i-1,j);
            }
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return readLCSequence(res,s1,s2,i-1,j-1) + s1.charAt(i);
        }
        else{
            if(res[i-1][j]>res[i][j-1]){
                return readLCSequence(res,s1,s2,i-1,j);
            }
            else{
                return readLCSequence(res,s1,s2,i,j-1);
            }
        }
    }

    public static boolean validParentheses(String str){
        int len = str.length();

        if(len==0)
            return true;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<len;i++){
            char bit = str.charAt(i);

            if(Character.isAlphabetic(bit)){

                if(stack.isEmpty())
                    return false;

                while(Character.isAlphabetic(bit)){
                    i++;
                    bit = str.charAt(i);
                }
                i--;
            }
            else if(bit=='{'){
                stack.push('{');
            }
            else{
                if(stack.isEmpty())
                    return false;
                else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static List<String> anagram(String str){

        List<String> res = new ArrayList<>();

        char[] array = str.toCharArray();
        Arrays.sort(array);

        str = new String(array);

        while(str.length()!=0){
            res.add(str);
            str = nextAnagram(str);
        }

        return res;
    }

    public static String nextAnagram(String str){
        char[] array = str.toCharArray();
        int idx = array.length-1;
        for(;idx>0;idx--){
            if(array[idx]>array[idx-1]){
                break;
            }
        }

        if(idx==0){
            return "";
        }

        int larger = idx;
        for(int i=idx+1;i<array.length;i++){
            if(array[i]<array[larger] && array[i]<array[idx-1]){
                larger = i;
            }
        }

        char tmp = array[larger];
        array[larger] = array[idx-1];
        array[idx-1] = tmp;

        Arrays.sort(array, idx, array.length);
        return new String(array);
    }

    public static double power(int x, int n){

        if(x==0)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n<0){
            return 1/power(x,-n);
        }
        else{
            double[] dp = new double[n+1];
            return powerHelper(x, n, dp);
        }
    }

    public static double powerHelper(int x, int n, double[] dp){
        if(n==1)
            return x;
        if(dp[n]!=0){
            return dp[n];
        }
        else{
            double subRes = powerHelper(x,n/2,dp);
            double res = subRes*subRes;
            if(res<subRes || Double.MAX_VALUE/subRes <= subRes){
                System.err.println("Overflow!");
                return 0;
            }
            if(n%2!=0)
                res *= x;
            dp[n] = res;
            return res;
        }
    }

    public static boolean isPrime(int num){

        if(num<=0)
            return false;
        int range = (int)Math.sqrt(num);
        for(int i=2;i<=range;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static List<Integer> primeInN(int n){

        List<Integer> res = new ArrayList<>();
        if(n==0)
            return res;
        res.add(1);
        if(n==1)
            return res;

        int[] map = new int[n+1];
        for(int i=2;i<=n;i++){
            if(map[i]==0)
                res.add(i);
            for(int j=2;j*i<=n;j++){
                map[j*i] = 1;
            }
        }
        return res;
    }

    public static int missing(int[] array){

        int len = array.length;
        if(len<=1)
            return -1;
        if(len==2)
            return array[0]+1;

        int begin = 0;
        int end = len-1;

        while(begin<end){
            System.out.println(begin+" "+end);
            int size = end-begin+1;
            if(size==2)
                return array[begin]+1;
            else{
                int mid = array[(begin+end)/2];
                int expect = (array[begin]+array[end])/2;


                if(size%2==0){
                    if(mid<expect)
                        begin = (begin+end)/2;
                    else
                        end = (begin+end)/2;
                }
                else{
                    if(mid<=expect)
                        begin = (begin+end)/2;
                    else
                        end = (begin+end)/2;
                }
            }
        }

        return array[begin]+1;
    }
}

class TreeManipulation{

    public static String serialize(TreeNode root) {
        if(root==null)
            return "";

        String left = "null";
        String right = "null";

        if(root.left!=null)
            left = new String(serialize(root.left));
        if(root.right!=null)
            right = new String(serialize(root.right));

        return root.val+" "+left+" "+right;
    }
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        LinkedList<String> queue = new LinkedList<>();
        for(String node: nodes)
            queue.add(node);
        if(queue.get(0).equals("null"))
            return null;
        return deserializeHelper(queue);

    }

    public static TreeNode deserializeHelper(LinkedList<String> queue){
        String cur = queue.removeFirst();
        if(cur.equals("null"))
            return null;
        else{
            TreeNode root = decode(cur);
            root.left = deserializeHelper(queue);
            root.right = deserializeHelper(queue);
            return root;
        }
    }



    public static TreeNode decode(String code){
        if(code.equals("null"))
            return null;
        else
            return new TreeNode(Integer.valueOf(code));
    }

    public static List<TreeNode> reverseBT(TreeNode head){

        List<TreeNode> res = new ArrayList<>();
        if(head==null)
            return res;
        reverseHelper(head, res);
        return res;
    }
    public static void reverseHelper(TreeNode head, List<TreeNode> res){
        if(head.left==null && head.right==null)
            res.add(head);
        if(head.left!=null){
            reverseHelper(head.left,res);
            head.left.left = head;
        }
        if(head.right!=null) {
            reverseHelper(head.right,res);
            head.right.right = head;
        }
        head.left=null;
        head.right=null;
    }

    public static int longestNodes(TreeNode head){

        if(head==null)
            return 0;

        List<Integer> res = new ArrayList<>();
        res.add(0);
        return lNodesHelper(head, res);
    }
    public static int lNodesHelper(TreeNode head, List<Integer> res){
        if(head==null)
            return 0;
        int left = lNodesHelper(head.left, res);
        int right = lNodesHelper(head.right, res);
        int distance = left+right;
        if(res.get(0)<distance){
            res.set(0,distance);
        }
        return Math.max(left,right)+1;
    }

    public static void preOrder(TreeNode head){

        if(head==null)
            return;

        Stack<TreeNode> openList = new Stack<>();
        openList.push(head);
        while(!openList.isEmpty()){
            TreeNode cur = openList.pop();
            System.out.println(cur.val);
            if(cur.right!=null)
                openList.push(cur.right);
            if(cur.left!=null)
                openList.push(cur.left);
        }
    }

    public static void inOrder(TreeNode head){
        if(head==null)
            return;

        TreeNode cur = head;

        Stack<TreeNode> openList = new Stack<>();

        while(cur!=null || !openList.isEmpty()){

            while(cur!=null){
                openList.push(cur);
                cur = cur.left;
            }
            cur = openList.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }

    }

    public static void postOrder(TreeNode head){
        if(head==null)
            return;


        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> openList = new Stack<>();
        openList.push(head);

        while(openList.isEmpty()){
            TreeNode cur = openList.pop();
            res.push(cur);
            if(cur.right!=null)
                openList.push(cur.right);
            if(cur.left!=null)
                openList.push(cur.left);
        }


    }

    public static TreeNode reBuildByPreIn(String pre, String in){
        int l1 = pre.length();
        int l2 = in.length();
        if(l1==0)
            return null;
        if(l1==1)
            return new TreeNode(Integer.valueOf(pre));

        String rootStr = pre.substring(0,1);
        int rootIdx = in.indexOf(rootStr);

        String newLeftPre = pre.substring(1, 1 + rootIdx);
        String newLeftIn = in.substring(0, rootIdx);
        String newRightPre = pre.substring(2 + rootIdx);
        String newRightIn = in.substring(rootIdx+1);

        TreeNode head = new TreeNode(Integer.valueOf(rootStr));
        head.left = reBuildByPreIn(newLeftPre,newLeftIn);
        head.right = reBuildByPreIn(newRightPre,newRightIn);

        return head;
    }


    public static void printByLevel(TreeNode head){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            int count = queue.size();

            for(int i=0;i<count;i++){
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            System.out.println();
        }
    }


}

class ListManipulation{

    public static ListNode reverseIt(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseRe(ListNode head, ListNode last){
        if(head==null)
            return head;


        if(head.next == null) {
            head.next = last;
            return head;
        }
        ListNode newHead = reverseRe(head.next, head);
        head.next = last;
        return newHead;
    }

    public static void print(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("------");
    }
}

class Cards{

    private LinkedList<Card> cardSet;

    public Cards(){
        cardSet = new LinkedList<>();
        for(int i=0;i<4;i++){
            for(int j=1;j<14;j++){

                char type = (char)('A'+i);
                cardSet.add(new Card(type+"", j));
            }
        }
    }

    public void dropTop(int number){

        LinkedList<Card> tmpCardSet = new LinkedList<>(this.cardSet);
        this.cardSet.clear();
        this.cardSet.addAll(tmpCardSet.subList(number, 52));
        this.cardSet.addAll(tmpCardSet.subList(0, number));
    }

    public void shuffle(){

        LinkedList<Card> tmpCardSet = new LinkedList<>(this.cardSet);
        this.cardSet.clear();
        for(int i=51;i>=0;i--){
            int idx = (int)(Math.random()*i);
            this.cardSet.add(tmpCardSet.remove(idx));
        }
    }

    public void print(){
        for(Card thisCard: this.cardSet){
            System.out.println(thisCard.type+" "+thisCard.number);
        }
    }

}

class Card{
    String type;
    Integer number;

    public Card(){

    }

    public Card(String type, int number){
        this.type = new String(type);
        this.number = number;
    }
}

class LRUCache {

    int capacity;
    Node head;
    Node tail;
    int amount;
    HashMap<Integer,Node> map;

    public void addFirst(Node node){
        if(amount==0){
            head = node;
            tail = head;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
        amount++;
    }

    public void promote(Node node){

        if(node.prev==null)
            return;
        if(node.next==null){
            tail = node.prev;
        }
        else{
            node.next.prev = node.prev;
        }

        node.prev.next = node.next;

        node.next = head;
        head.prev = node;
        head = node;
        head.prev=null;
    }

    public void removeLast(){
        if(tail.prev==null){
            head=null;
            tail=null;
        }
        else{
            tail.prev.next = null;
            tail = tail.prev;
        }
        amount--;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        amount = 0;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);

        promote(cur);
        return cur.value;
    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            promote(cur);
            return;
        }

        if(amount == capacity){
            map.remove(tail.key);
            removeLast();
        }

        Node newNode = new Node(key, value);
        addFirst(newNode);
        map.put(key,newNode);
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}


class Block implements Comparable<Block>{

    int distance;

    public Block(int distance){
        this.distance = distance;
    }

    @Override
    public int compareTo(Block other){
        return this.distance-other.distance;
    }
}

class BlockComparator implements Comparator<Block>
{
    @Override
    public int compare(Block x, Block y)
    {
        int res = x.distance - y.distance;
        if(res==0)
            return 0;
        else
            return res>0? 1:-1;
    }
}


enum Type{
    REGULAR,
    FULL_SIZE,
    STANDARD
}