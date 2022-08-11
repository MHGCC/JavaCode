// 判断是否为完全二叉树，最直观的就是递归遍历，然后比较每一个左/右子树的深度
// 好像不能再leetcde测试中使用    public static Boolean flag=true;
// 纯返回int的话，可以用-1替代false判别，因为深度不可能为负数
package LeetCode;

import tools.binary_tree;

public class code110 {

    public static Boolean flag=true;

    public static boolean isBalanced(binary_tree root) {
        if(root==null){
            return true;
        }
        else{
            depth_tree(root);
            return flag;
        }
        
    }

    public static int depth_tree(binary_tree root){
        if(root==null){
            return 0;
        }
        else{
            if(flag){
                int depth_left=depth_tree(root.left);
                int depth_right=depth_tree(root.right);
                if(Math.abs(depth_left-depth_right)>1){
                    flag=false;
                }
                return 1+Math.max(depth_left,depth_right);
            }
            return 0;
        }
    }
    
    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        System.out.println(isBalanced(root_01));
    } 
}
