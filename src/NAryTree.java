/**
 * Created by qixuanwang on 16/2/25.
 */
public class NAryTree<T>{

    NAryTreeNode<T> root;

    public NAryTree(NAryTreeNode<T> root) {
        this.root = root;
    }

    public NAryTree(int n, T value) {
        this.root = new NAryTreeNode<T>(n, value);
    }

    public NAryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(NAryTreeNode<T> root) {
        this.root = root;
    }
}

class NAryTreeNode<T>{

    T value;
    int N;
    int size;
    NAryTreeNode[] children;


    public NAryTreeNode(int n, T value){
        this.value = value;
        this.size = 0;
        this.N = n;
        this.children = new NAryTreeNode[n];
    }

    public NAryTreeNode(NAryTreeNode node){
        this.value = (T)node.getValue();
        this.N = node.getN();
        this.size = node.getSize();
        this.children = new NAryTreeNode[N];

        for(int i=0;i<N;i++){
            this.children[i] = new NAryTreeNode<T>(node.getChildren()[i]);
        }
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NAryTreeNode getChild(int idx) {
        return children[idx];
    }
    public void setChild(int idx, NAryTreeNode node) {
        children[idx] = node;
    }

    public NAryTreeNode[] getChildren() {
        return this.children;
    }
}
