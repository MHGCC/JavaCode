// 方案1；递归求所有最大depth，然后比较的到最小的
// 方案2，层序迭代，没有比较过程
// 这里写一个递归的
// 配合leetcode上的测试，这里binary_tree都换成了TreeTreeNode
package LeetCode;

import tools.TreeNode;


public class code111 {

    public static int min(int a,int b){
        if(a>b){
            return b;
        }
        else{
            return a;
        }
    }

    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int min_left=minDepth(root.left);
            int min_right=minDepth(root.right);
            // github的样例程序里判断左/右子树是否存在，是为了避免左子树不存在导致右子树深度被0的左子树覆盖
            if((root.left==null)&&(root.right!=null)){
                return 1+min_right;
            }
            if((root.right==null)&&(root.left!=null)){
                return 1+min_left;
            }
            //if((root.right!=null)&&(root.left!=null)){
            return 1+min(min_left,min_right);
           
        }
    }

    public static void main(String[] args){
        TreeNode root_01=new TreeNode(1);
        TreeNode leaf_01=new TreeNode(2);
        TreeNode leaf_02=new TreeNode(3);
        TreeNode leaf_03=new TreeNode(4);
        TreeNode leaf_04=new TreeNode(5);
        root_01.right=leaf_01;
        root_01.left=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        System.out.println(minDepth(root_01));
    } 
}
