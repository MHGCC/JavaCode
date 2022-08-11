package LeetCode;
import tools.binary_tree;
import java.util.List;
import java.util.ArrayList;

public class code144 {

    public static List<Integer> preorderTraversal(binary_tree root) {
        List<Integer> results=new ArrayList<Integer>();
        //这里很麻烦的是递归过程中记录前序遍历的数组，要跟随函数保持
        //Java函参传递引用，因此在其他函数里修改数组/List即修改其本身，需要注意
        preorder(root,results);
        return results;
    }

    public static void preorder(binary_tree root,List<Integer> results){
        if(root==null){
            return ;
        }
        else{
            results.add(root.value);
            preorder(root.left, results);
            preorder(root.right, results);
        }
        return ;
    }
    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(3);
        root_01.right=leaf_01;
        leaf_01.left=leaf_02;
        preorderTraversal(root_01);
    } 
}
