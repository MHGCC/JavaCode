// 迭代法检索即可。递归更容易理解
package LeetCode;

import tools.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class code559 {
    public static int maxDepth(Node root) {
        Queue<Node> stack_leaves=new LinkedList<Node>();
        int depth=0;
        if(root!=null){
            stack_leaves.add(root);
            // 将每一层的节点不断push入栈，当达到新一层时栈内没有对象，则说明已经遍历完这棵树了
            while(!stack_leaves.isEmpty()){
                depth=depth+1;
                int length=stack_leaves.size();
                for(int i=0;i<length;i++){
                    Node cur_node=stack_leaves.poll();
                    if(cur_node.children!=null){
                        for(int j=0;j<cur_node.children.size();j++){
                            stack_leaves.add(cur_node.children.get(j));
                        }
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
        Node root_01=new Node(1);
        Node leaf_01=new Node(3);
        Node leaf_02=new Node(2);
        Node leaf_03=new Node(4);
        Node leaf_11=new Node(5);
        Node leaf_12=new Node(6);
        List<Node> list_01=new ArrayList<>();
        list_01.add(leaf_01);
        list_01.add(leaf_02);
        list_01.add(leaf_03);
        root_01.children=list_01;
        List<Node> list_02=new ArrayList<>();   
        list_02.add(leaf_11);
        list_02.add(leaf_12);
        leaf_01.children=list_02;
        System.out.println(maxDepth(root_01));
    } 
}
