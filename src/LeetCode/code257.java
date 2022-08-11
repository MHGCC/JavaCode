// 本题的思路
// 首先是递归搜索完全子节点，基本的前序遍历即可，并不会重复
// 然后是字符串集合
package LeetCode;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths_list=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        if(root!=null){
            search_children(root, paths_list, path);
        }
        return paths_list;        
    }

    public static void search_children(TreeNode root,List<String> paths_list,ArrayList<Integer> path){
        // 当前节点为完全叶子结点，避免使用root==null导致重复路径
        // 还是不适合使用队列，换数组吧
        if((root.left==null)&&(root.right==null)){
            path.add(root.val);
            String path_s=""+path.get(0);
            for(int i=1;i<path.size();i++){
                path_s=path_s+"->"+path.get(i);
            }
            paths_list.add(path_s);
            path.remove(path.size()-1);
        }
        else{
            path.add(root.val);
            if(root.left!=null){
                search_children(root.left, paths_list, path);
            }
            if(root.right!=null){
                search_children(root.right, paths_list, path);                
            }
            // 弹出节点
            path.remove(path.size()-1);
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
        System.out.println(binaryTreePaths(root_01));
    } 

}
