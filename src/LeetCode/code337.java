// 直接做一个满二叉树数组表示父子关系
// 可以使用一个长度为2的数组，记录当前节点偷与不偷所得到的的最大金钱。

// 与递归且保存结果记录的解法不同的是递归会枚举 偷/不偷 的状态，而递推在最大结果上操作（而非动作状态）

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.lang.Math;

import tools.binary_tree;

public class code337 {
    /*
    // 层序遍历失败，同一层级没有递推关系，用sum作为层和硬怼会出现重复情况
    public static int rob(binary_tree root) {
        // 构造二叉树数组
        List<Integer> tree=generate_tree_array(root);

        int[][] result=new int[tree.size()][2];

        // 推演之后可以发现，自下向上勉强可以递推

        // 初始化
        for(int i=tree.size()-1;i>=tree.size()/2;i--){
            result[i][0]=0;
            if(tree.get(i)!=-1){
                result[i][1]=tree.get(i);
            }
            else{
                result[i][1]=0;
            }
        }

        int length=tree.size()/2;
        while(length>0){
            int sum=0;
            for(int i=length;i<=length*2;i++){
                sum=sum+result[i][1];
            }

            for(int i=length-1;i>=length/2;i--){
                result[i][0]=sum;
                result[i][1]=
            }
        }

        return result[tree.size()];
    }
    */

    // 深度遍历
    public static int rob(binary_tree root) {
        int[] result=rob_search(root);

        return Math.max(result[0],result[1]);
    }

    public static int[] rob_search(binary_tree root){

        int[] result=new int[2];

        if(root==null){
            return result;
        }

        // 左子和右子同样存在偷和不偷两种情况，且value比较状况未知

        int[] left=rob_search(root.left);
        int[] right=rob_search(root.right);

        result[0]=Math.max(left[0],left[1])+Math.max(right[0], right[1]);
        result[1]=left[0]+right[0]+root.value;

        return result;
    }

    public static List<Integer> generate_tree_array(binary_tree root){
        List<Integer> result=new ArrayList<>();

        Queue<binary_tree> temp=new LinkedList<>();

        temp.add(root);

        while(!temp.isEmpty()){
            // flag 用于判断下一层是否全部为空
            Boolean flag=false;
            int length=temp.size();
            for(int i=0;i<length;i++){
                binary_tree temp_node=temp.poll();

                //下 一层只要有一个节点不为空

                result.add(temp_node.value);

                if(temp_node.left!=null){
                    temp.add(temp_node.left);
                    flag=true;
                }
                else{
                    binary_tree null_node=new binary_tree(-1);
                    temp.add(null_node);
                }

                if(temp_node.right!=null){
                    temp.add(temp_node.right);
                    flag=true;
                }
                else{
                    binary_tree null_node=new binary_tree(-1);
                    temp.add(null_node);
                }

            }
            // 一层全部为空，弹出
            if(!flag){
                break;
            }
        }

        return result;
    }
    public static void main(String[] args){
        binary_tree root=new binary_tree(3);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(3);
        binary_tree leaf_03=new binary_tree(3);
        binary_tree leaf_04=new binary_tree(1);

        root.left=leaf_01;
        root.right=leaf_02;
        leaf_01.right=leaf_03;
        leaf_02.right=leaf_04;

        rob(root);
    }    
}
