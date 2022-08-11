package LeetCode;

import tools.binary_tree;

public class code450_v2 {

    class Solution {
        public binary_tree deleteNode(binary_tree root, int key) {
            // 起点，不在这里做判别
            root = delete(root,key);
            return root;
        }
    
        private binary_tree delete(binary_tree root, int key) {
            // 将搜寻和重构合一，共同的截止条件是遍历到空节点
            if (root == null) return null;
    
            // BTS 可以使用的搜索
            // 这里的递归可以避免掉pre的额外使用
            if (root.value > key) {
                root.left = delete(root.left,key);
            } else if (root.value < key) {
                root.right = delete(root.right,key);
            } else {
            // 相比于这里的策略，我分的情况可能有点多，有些是可以合并的
                // 搜索到，2种情况
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                // 暂时保存root.right
                binary_tree tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                root.value = tmp.value;
                root.right = delete(root.right,tmp.value);
            }
            return root;
        }
    }
}
