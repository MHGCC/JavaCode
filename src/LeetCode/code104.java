package LeetCode;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class code104 {

    // 层序迭代，需要在一次循环中结束二叉树的一层 
    // 需要一个容器暂时存储上一层节点的叶子结点,确实需要是队列，先进容器的节点先弹出。如果是栈的话，后面加的叶节点会先搜索其叶子节点并弹出
    public static int maxDepth(TreeNode root) {
        
        Queue<TreeNode> stack_leaves=new LinkedList<TreeNode>();
        int depth=0;
        if(root!=null){
            stack_leaves.add(root);
            // 将每一层的节点不断push入栈，当达到新一层时栈内没有对象，则说明已经遍历完这棵树了
            while(!stack_leaves.isEmpty()){
                depth=depth+1;
                int length=stack_leaves.size();
                for(int i=0;i<length;i++){
                    TreeNode cur_node=stack_leaves.poll();
                    if(cur_node.left!=null){
                        stack_leaves.add(cur_node.left);
                    }
                    if(cur_node.right!=null){
                        stack_leaves.add(cur_node.right);
                    }
                }
            }
            return depth;
        }
        else{
            return depth;
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
        System.out.println(maxDepth(root_01));
    } 
}
