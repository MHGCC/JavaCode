// 左子树val之和
// 重点在于判断左叶子结点
// 1 可以从左叶子结点的父节点开始判定（好像也没有其他解法，不过可以加装标记，但不直观
// 直观地递归解决

package LeetCode;

import tools.binary_tree;

public class code404 {
    public static int sumOfLeftLeaves(binary_tree root) {
        if(root==null){
            return 0;
        }
        else{
            return search_left_leaves(root);
        }       
    }

    public static int search_left_leaves(binary_tree root){
        int sum_temp=0;
        // 遍历的结束条件
        if(root!=null){
            // 判断当前是否能找到一个左叶子
            if((root.left!=null)&&(root.left.left==null)&&(root.left.right==null)){
                sum_temp=sum_temp+root.left.val;
            }
            // 继续搜索，并不会造成重复
            if(root.left!=null){
                sum_temp=sum_temp+search_left_leaves(root.left);
            }
            if(root.right!=null){
                sum_temp=sum_temp+search_left_leaves(root.right);
            }
        }
        return sum_temp;
    }
    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(3);
        binary_tree leaf_03=new binary_tree(4);
        binary_tree leaf_04=new binary_tree(5);
        root_01.right=leaf_01;
        root_01.left=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(sumOfLeftLeaves(root_01));
    } 
    
}
