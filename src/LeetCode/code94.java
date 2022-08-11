// 迭代法不递归，直接将节点存到栈中，这样可以保存根节点和叶节点的关系
package LeetCode;
import tools.binary_tree;
import java.util.List;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

import java.util.ArrayList;

public class code94 {
    public static List<Integer> inorderTraversal(binary_tree root) {
        Stack<binary_tree> stack_tree=new Stack<>();
        List<Integer> results=new ArrayList<>();
        inorder(root,stack_tree,results);
        return results;
    }

    public static void inorder(binary_tree root,Stack<binary_tree> stack_tree,List<Integer> results){
        if(root==null){
            return ;
        }
        else{
            // 什么时候跳出循环是一个问题，一定要遍历完这棵树为止
            // 遍历完整棵树，不仅包括当前已指向空节点，还要把栈内的根节点都清出
            while((root!=null)||(!stack_tree.isEmpty())){
                // 执行中序遍历的规则
                // 只要不是空节点就一直取左叶子
                if(root!=null){
                    stack_tree.push(root);
                    root=root.left;
                }
                //按照中序规则，弹出根节点，记录，搜寻右子树
                else{
                    root=stack_tree.pop();
                    results.add(root.value);
                    root=root.right;
                }
            }
        }
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(3);
        root_01.right=leaf_01;
        leaf_01.left=leaf_02;
        inorderTraversal(root_01);
    } 
}
