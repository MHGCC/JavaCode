// 考虑后续遍历然后设置两个flag表示有没有遍历过这两个给定节点，在后序递归时，必然是最近的根节点先返回

// 我忽略了一点，因此代码写得很烦
// 有且仅有三种情况 1 通过 lowestCommonAncestor 搜索给定节点，左子树传回p/q，右子树传回p/q，此时返回root
// 2 左子树传回非null，右子树null，最近根节点在左子树上
// 3 左子树传回null，右子树非null，最近根节点在右子树上

package LeetCode;

import tools.binary_tree;

public class code236 {

    public static binary_tree lowestCommonAncestor(binary_tree root, binary_tree p, binary_tree q) {
        
        int[] flag_arr=new int[2];
        // 两个节点都没有遍历过
        flag_arr[0]=0;
        flag_arr[1]=0;

        binary_tree lowest_root=search_p_q(root,p.value,q.value,flag_arr);

        return lowest_root;       
    }

    public static binary_tree search_p_q(binary_tree root,int p,int q,int[] flag_arr){

        // 已遍历过完全叶子节点
        
        if(root.left!=null){
            // 为了不使左、右子树匹配导致找到右节点为根节点，更新flag规则改变
            int[] flag=new int[2];
            flag[0]=flag_arr[0];
            flag[1]=flag_arr[1];
        
            binary_tree temp_left=search_p_q(root.left, p, q, flag_arr);
            binary_tree temp_right=search_p_q(root.right, p, q, flag);

            flag_arr[0]=Math.max(flag[0], flag_arr[0]);
            flag_arr[1]=Math.max(flag[1], flag_arr[1]);

            if(root.value==p){
                flag_arr[0]=1;
            }
            else if(root.value==q){
                flag_arr[1]=1;
            }

            // 只在第一次遍历过两个节点，并返回根节点（包括遍历根节点）时取共同根节点
            if(temp_left!=null){
                return temp_left;
            }
            else if(temp_right!=null){
                return temp_right;
            }
            else if(flag_arr[0]==1 && flag_arr[1]==1){
                return root;
            }

            return null;
        }
        else{
            return null;
        }
    }
    
    public static void main(String[] args){
        binary_tree root_01=new binary_tree(1);
        binary_tree leaf_01=new binary_tree(2);
        binary_tree leaf_02=new binary_tree(4);
        binary_tree leaf_03=new binary_tree(1);
        binary_tree leaf_04=new binary_tree(0);
        root_01.left=leaf_01;
        System.out.println(lowestCommonAncestor(root_01,root_01,leaf_01));
    }

}
