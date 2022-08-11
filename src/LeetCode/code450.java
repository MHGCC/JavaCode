// 分为两步
// 1 搜索到key节点，删除key节点
// 2 重新整理BTS结构
// 分几种情况，A 删除完全叶子结点，不动 B 删除非完全叶子结点或根节点
// B的规则，如果存在左子树 cur.left，将 cur的位置由cur.left替代，cur.left的左子树正常继承，如果存在右子树，则给到

// 代码可以简化很多，逻辑上是相同的。
// 可以简化搜索key_node部分和重复的树重构部分

package LeetCode;

import tools.binary_tree;

public class code450 {

    public static binary_tree deleteNode(binary_tree root, int key) {
        // 可能为空树
        if(root==null){
            return null;
        }
        else{
            // 记录pre和cur
            binary_tree pre=new binary_tree(-1);
            pre.left=root;
            // 用数组把
            binary_tree[] pre_cur=search_key(root,key,pre);
            // 没找到
            pre=pre_cur[0];           
            binary_tree key_node=pre_cur[1];
            if(key_node==null){
                return root;
            }
            binary_tree new_root=reconstruct_tree(pre,key_node,root);

            return new_root;
        }
    }

    public static binary_tree[] search_key(binary_tree root,int key,binary_tree pre){
        binary_tree[] pre_cur=new binary_tree[2];
        if(root==null){
            pre_cur[0]=null;
            pre_cur[1]=null;
            return pre_cur;
        }
        else{
            if(root.value==key){
                pre_cur[0]=pre;
                pre_cur[1]=root;
                return pre_cur;
            }
            else{
                // BST 搜索可以简化
                if(root.value>key){
                    return search_key(root.left, key, root);
                }
                else{
                    return search_key(root.right, key, root);
                }
            }
        }
    }

    public static binary_tree reconstruct_tree(binary_tree pre,binary_tree key_node,binary_tree root){
        
        if(pre.left==root){
            // 刚好是原树的根节点
            binary_tree new_root;
            if(root.left==null){
                new_root=root.right;
            }
            else if(root.right==null){
                new_root=root.left;
            }
            else{
                // 重新构建BTS的规则
                new_root=root.left;
                binary_tree temp=new_root.right;
                new_root.right=root.right;
                binary_tree position_right=new_root.right;
                while(position_right.left!=null){
                    position_right=position_right.left;
                }
                position_right.left=temp;
            }
            return new_root;
        }
        else{
            // 不是根节点，不需要更新root
            
            // 是完全叶子节点
            if(key_node.left==null && key_node.right==null){
                // 锁定是左子还是右子
                if(pre.left==key_node){
                    pre.left=null;
                }
                else{
                    pre.right=null;
                }        
            }
            // 非完全叶子结点
            else{
                // 与root那里类似的做法
                if(key_node.left==null){
                    if(pre.left==key_node){
                        pre.left=key_node.right;
                    }
                    else{
                        pre.right=key_node.right;
                    } 
                }
                else if(key_node.right==null){
                    if(pre.left==key_node){
                        pre.left=key_node.left;
                    }
                    else{
                        pre.right=key_node.left;
                    } 
                }
                else{
                    // 重新构建BTS的规则
                    if(pre.left==key_node){
                        pre.left=key_node.left;
                    }
                    else{
                        pre.right=key_node.left;
                    } 
                    binary_tree temp=key_node.left.right;
                    key_node.left.right=key_node.right;
                    binary_tree position_right=key_node.right;
                    while(position_right.left!=null){
                        position_right=position_right.left;
                    }
                    position_right.left=temp;
                }
            }
            return root;
        }
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
        deleteNode(root_01, 4);
    }

}
