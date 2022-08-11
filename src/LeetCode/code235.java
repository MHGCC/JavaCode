// 相比236，搜索二叉树更容易定位
package LeetCode;

import tools.binary_tree;

public class code235 {

    public static binary_tree lowestCommonAncestor(binary_tree root, binary_tree p, binary_tree q) {
        
        if((root.value>=Math.min(p.value, q.value))&&(root.value<=Math.max(p.value, q.value))){
            return root;
        }
        else{
            // 都在左子树
            if(root.value<Math.min(p.value, q.value)){
                return lowestCommonAncestor(root.left, p, q);
            }
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(2);
        binary_tree leaf_01=new binary_tree(1);
        root_01.left=leaf_01;
        System.out.println(lowestCommonAncestor(root_01,root_01,leaf_01));
    }
}
