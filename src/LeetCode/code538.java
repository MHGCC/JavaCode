// 想了一下，直接中序出来，然后处理累加，最后替换value即可
package LeetCode;

import tools.binary_tree;
import LeetCode.code94;
import java.util.List;

public class code538 {

    public static binary_tree convertBST(binary_tree root) {
        // 空树判定
        if(root==null){
            return null;
        }
        else{
            List<Integer> inorder_list=code94.inorderTraversal(root);
            for(int i=inorder_list.size()-2;i>=0;i--){
                int sum=inorder_list.get(i)+inorder_list.get(i+1);
                inorder_list.set(i,sum);
            }

            // 按照中序将value填回去
            int position=set_node_value(root,inorder_list,-1);
            
            return root;     
        }   
    }

    public static int set_node_value(binary_tree root,List<Integer> lists,int position){
        if(root.left!=null){
            position=set_node_value(root.left, lists, position);
        }
        // 填入一个值后，计数器+1
        position=position+1;
        root.value=lists.get(position);
        if(root.right!=null){
            position=set_node_value(root.right, lists, position);
        }        
        return position;
    }

    public static void main(String[] args){
        binary_tree root_01=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(5);
        root_01.left=leaf_01;
        root_01.right=leaf_02;
        leaf_01.left=leaf_03;
        leaf_02.right=leaf_04;
        convertBST(root_01);
    }
}
