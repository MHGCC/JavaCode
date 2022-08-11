// 在257基础上修改，257是记录所有路径，112是求valueue之和，开销甚至更小
package LeetCode;

import tools.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code112 {
    public static boolean hasPathSum(binary_tree root,int targetSum) {
        // 有可能出现空树，提前判定
        if(root==null){
            return false;
        }
        else{
            Boolean flag=search_children(root, targetSum, 0, false);
            return flag;
        }        
    }

    public static Boolean search_children(binary_tree root,int targetSum, int sum, Boolean flag){
        // 只要找到一条符合的路径即可
        if(!flag){
            // 当前节点为完全叶子结点，避免使用root==null导致重复路径
            if((root.left==null)&&(root.right==null)){
                if((sum+root.value)==targetSum){
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                if((root.left!=null)&&(!flag)){
                    flag=search_children(root.left, targetSum, sum+root.value,flag);
                }
                if((root.right!=null)&&(!flag)){
                    flag=search_children(root.right, targetSum, sum+root.value,flag);                
                }
            }
        }
        return flag;
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
        System.out.println(hasPathSum(root_01,66));
    }    
}
