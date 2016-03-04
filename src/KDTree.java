import java.util.ArrayList;
import java.util.List;
/**
 * Created by qixuanwang on 16/3/2.
 */
public class KDTree {

    KDTreeNode root;

}

class KDTreeNode{

    //Split plane can be stored by using 2 number.
    //The dimension means the plane's direction (perpendicular to this axis)
    int splitDimension;
    //The value means the plane's position in the dimension
    double splitValue;

    double[] position;

    KDTreeNode parent;
    List<KDTreeNode> left;
    List<KDTreeNode> right;

    public KDTreeNode(KDTreeNode parent, double[] position, double splitValue, int splitDimension) {
        this.parent = parent;
        this.position = position;
        this.splitValue = splitValue;
        this.splitDimension = splitDimension;

        left = new ArrayList<>();
        right = new ArrayList<>();
    }
}
