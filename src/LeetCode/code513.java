// 这里的最左侧叶子节点指的是最后一层的最左侧叶子节点，用层序遍历很清晰

package LeetCode;

import tools.binary_tree;
import java.util.Queue;
import java.util.LinkedList;

public class code513 {

    public static int findBottomLeftvalue(binary_tree root) {
        Queue<binary_tree> queue_node=new LinkedList<>();
        // 题给信息，根节点一定存在
        int value_left=root.value;
        queue_node.add(root);
        while(!queue_node.isEmpty()){
            // 层序，在一层中从左至右扫描，一旦发现最左节点，flag=false
            Boolean flag=true;
            int length=queue_node.size();
            for(int i=0;i<length;i++){
                binary_tree temp=queue_node.poll();
                if(temp.left!=null){
                    if(flag){
                        value_left=temp.left.value;
                        flag=false;
                    }
                    queue_node.add(temp.left);
                }
                if(temp.right!=null){
                    if(flag){
                        value_left=temp.right.value;
                        flag=false;
                    }
                    queue_node.add(temp.right);                    
                }
            }
        }

        return value_left;
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
        System.out.println(findBottomLeftvalue(root_01));
    } 
}
