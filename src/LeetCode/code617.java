// 这题按遍历一步步来比较清晰

package LeetCode;

import tools.binary_tree;

public class code617 {

    public static binary_tree mergeTrees(binary_tree root1, binary_tree root2) {
        // 可能为空
        if((root1==null)&&(root2==null)){
            return null;
        }
        else{
            binary_tree new_root=new binary_tree(0);

            if((root1!=null)&&(root2!=null)){
                new_root.value=new_root.value+root1.value+root2.value;
                new_root.left=mergeTrees(root1.left, root2.left);
                new_root.right=mergeTrees(root1.right, root2.right);
            }
            else if(root1!=null){
                new_root.value=new_root.value+root1.value;    
                new_root.left=mergeTrees(root1.left, null);
                new_root.right=mergeTrees(root1.right, null);            
            }
            else{
                new_root.value=new_root.value+root2.value;    
                new_root.left=mergeTrees(null, root2.left);
                new_root.right=mergeTrees(null, root2.right);    
            }
            return new_root;
        }    
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
        binary_tree root_11=new binary_tree(6);
        binary_tree leaf_11=new binary_tree(7);
        root_11.left=leaf_11;
        mergeTrees(root_01,root_11);
    }
    
}
