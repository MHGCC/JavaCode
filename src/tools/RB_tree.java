package tools;

import tools.RB_tree_node;

public class RB_tree<T extends Comparable<T>> {


    private final RB_tree_node<T> nil=new RB_tree_node<>();

    // 根节点初始化为空
    private RB_tree_node<T> root=nil;

    /*
     * 联系之后的删除修复
     * 这里《算法导论》和博客上提供了一个空节点nil而非null作为空，这样nil.color就存在
     * 而不会出现null.color的情况
     *     
        private final Node nil = new Node();

        * 根结点初始化为nil
        private Node root = nil;


        * 结点类

        private class Node {
            private Key key;
            private Node left;
            private Node right;
            private Node parent;
            private boolean color = BLACK;

            public Node() {
            }

            public Node(Key key) {
                this.key = key;
            }

            @Override
            public String toString() {
                String nodeColor = color ? "BLACK" : "RED";
                return " " + key + "-" + nodeColor + " ";
            }
        }
     */


    // 树函数区
    // 插入
    public void RB_tree_node_insert(RB_tree_node<T> root,RB_tree_node<T> z){

        int result_compare;
        RB_tree_node<T> temp=null;
        RB_tree_node<T> search_point=root;

        while(search_point!=null){
            temp=search_point;
            result_compare=z.key.compareTo(search_point.key);
            if(result_compare<0){
                search_point=search_point.left;
            }
            else{
                search_point=search_point.right;
            }
        }

        z.parent=temp;
        // 根节点
        if(temp==null){
            this.root=temp;
        }
        else{
            result_compare=z.key.compareTo(temp.key);
            if(result_compare<0){
                temp.left=z;
            }
            else{
                temp.right=z;
            }
        }

        // 颜色设置
        z.color=false;
        fixed_insert(this.root, z);
    }

    // 删除
    public void RB_tree_node_delete(RB_tree_node<T> z){
        RB_tree_node<T> temp;
        temp=z;
        // x是temp的后继，temp的颜色使用待删除节点的颜色，不调整
        // 则调整的是其后继节点的颜色，又因为这里始终使用右子树的来填补，所以后继为右节点
        RB_tree_node<T> x;

        Boolean temp_color=z.color;

        // 列举删除的情况
        // case 1 左子树为空，右子树提上来
        if(z.left==null){
            x=z.right;
            transplant(z, z.right);
        }
        // case 2
        else if(z.right==null){
            x=z.left;
            transplant(z, z.left);
        }
        else{
            // 搜索替换位置
            // 以右子树搜索，则找到右子树中最小的(肯定没有左子树)
            temp=mini_mum(z.right);
            temp_color=temp.color;
            x=temp.right;
            if(temp.parent==z){
                // 特殊的，z的右节点即为右子树的最小节点（没有左子树）
                // 那直接把右节点上移替代掉就行
                x.parent=temp;
            }
            else{
                // 将替代节点提取出来
                transplant(temp, temp.right);
                // 将z的右子树接给temp
                temp.right=z.right;
                temp.right.parent=temp;
            }
            transplant(z, temp);
            temp.left=z.left;
            temp.left.parent=temp;
            // temp.color使用原来的z.color
            temp.color=z.color;
        }

        // 颜色修复,temp节点红色不影响颜色原则，见P184
        if(temp_color){
            fixed_delete(x);
        }

    }

    // 工具区

    // 嫁接
    private void transplant(RB_tree_node<T> u,RB_tree_node<T> v){
        if(u==this.root){
            this.root=v;
        }
        else{
            if(u==u.parent.left){
                u.parent.left=v;
            }
            else if(u==u.parent.right){
                u.parent.right=v;
            }
        }
        v.parent=u.parent;
    }

    // 左旋转
    private void left_rotate(RB_tree_node<T> root,RB_tree_node<T> x){
        RB_tree_node<T> temp;

        // 入口是fixed_insert，则一定存在右子树
        temp=x.right;
        x.right=temp.left;
        temp.parent=x.parent;

        // 判定根节点
        if(x==root){
            // 更新根节点
            this.root=temp;
        }
        // 左子树还是右子树
        else if(x==x.parent.left){
            x.parent.left=temp;
        }
        else{
            x.parent.right=temp;
        }

        // temp.left存在，则要建立双向连接
        if(temp.left!=null){
            temp.left.parent=x;
        }

        // 最后更新temp和x的关系
        temp.left=x;
        x.parent=temp;
    }

    // 右旋转
    private void right_rotate(RB_tree_node<T> root,RB_tree_node<T> x){
        RB_tree_node<T> temp;

        // 入口是fixed_insert，则一定存在左子树
        temp=x.left;
        x.left=temp.right;
        temp.parent=x.parent;

        // 判定根节点
        if(x==root){
            // 更新根节点
            this.root=temp;
        }
        // 左子树还是右子树
        else if(x==x.parent.left){
            x.parent.left=temp;
        }
        else{
            x.parent.right=temp;
        }

        // temp.left存在，则要建立双向连接
        if(temp.right!=null){
            temp.right.parent=x;
        }

        // 最后更新temp和x的关系
        temp.right=x;
        x.parent=temp;        
    }

    // 插入操作后颜色修复
    // 模拟P179的图
    private void fixed_insert(RB_tree_node<T> root,RB_tree_node<T> z){

        RB_tree_node<T> temp;

        // 入口处z必然是红色
        // 处理红黑树各原则，首先是红黑相邻
        while(!z.parent.color){
            if(z.parent==z.parent.parent.left){
                // 父节点为左节点
                temp=z.parent.parent.right;
                // case 1
                if(!temp.color){
                    z.parent.color=true;
                    temp.color=true;
                    z=z.parent.parent;
                    z.color=false;
                }
                else{ 
                    // case 2
                    if(z==z.parent.right){
                        z=z.parent;
                        // 左转
                        left_rotate(this.root, z);
                    }
                    // case 3，也不能说是case，执行2后必有3
                    // 书上的说法是case2可以转换为case3，则case的处理变为必须，不需要判定
                    z.parent.color=true;
                    z.parent.parent.color=false;
                    right_rotate(root, z.parent.parent);
                }
            }
            else{
                // 父节点为右节点
                temp=z.parent.parent.left;
                // case 1,就针对case1这种情况，叔节点是红色
                if(!temp.color){
                    z.parent.color=true;
                    temp.color=true;
                    z=z.parent.parent;
                    // z.color赋值为红,不管它原来是什么颜色
                    z.color=false;
                }
                else{
                    if(z==z.parent.left){
                        z=z.parent;
                        right_rotate(this.root, z);
                    }
                    z.parent.color=true;
                    z.parent.parent.color=false;
                    left_rotate(root, z.parent.parent);
                }
            }
        }
        // 根节点为黑
        root.color=true;
    }

    // 删除操作后颜色修复
    // 算法导论中的这个修复在z为空节点的情况下不会出错？答：见上方nil

    // 想了想，不必纠结于原理到底怎么样，实现起来就是几个情况的判定和转换
    private void fixed_delete(RB_tree_node<T> z){
        //<算法导论>中的理论是将temp的黑色性质顺延给后继x，这样不管x颜色是什么
        // temp的顺延黑色在计算性质5的黑节点个数时会被计入，即x的黑色计数+1
        // 它天然会有一种黑色，可能会造成既是黑色又是红色的情况，违反性质1

        /*
         * while的条件
         * 2.2(d)情况，u/z双黑但是根节点，弹出，赋值一个黑色
         * 2.1 情况，u红色，弹出，变为黑色
         */
        while (z != root && z.color) {
            // u为左节点，则s为右节点。else中为镜像情况
            if (z == z.parent.left) {
                RB_tree_node<T> w = z.parent.right;
                // 2.2(a) s/w红色，把红色节点换到父位置上（由于红色节点不相连，父节点必为黑色）
                // 则以下的颜色重置就是两个节点的颜色互换
                // s现为右节点，则左转
                if (w.color == false) {
                    w.color = true;
                    z.parent.color = false;
                    left_rotate(root,z.parent);
                    w = z.parent.right;
                }
                //case 2
                // 兄弟节点黑色，且其左右节点都是黑色（NIL也行）
                // 解决双重黑色这一种异常现象
                // 处理：z指向z.parent，w变红
                if (w.left.color && w.right.color) {
                    w.color=false;
                    z=z.parent;
                } 
                else {
                // case 3
                // w黑色，是w左节点红色，右节点黑色，（非空）
                // 解决，w变红色，指向其左节点，变黑色，右转
                    if(!w.left.color){
                        w.color=false;
                        w.left.color=true;
                        right_rotate(root,w);
                        w=z.parent.right;
                    }
                // case 4
                // w黑色，w右节点红色（注意，case3 完成后自然有case 4）
                // 解决， x.parent变黑色（x的一个黑色上移，x.parent的原颜色给w，
                // 这时也会产生一个不确定颜色的根节点，继续while循环），x.parent左转
                    w.color=z.parent.color;
                    z.parent.color=true;
                    // 两边黑色个数
                    w.right.color=true;
                    left_rotate(root, z.parent);
                    z=root;
                }
            } 
            else {
                Node w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (w.left.color == BLACK) {
                        w.right.color = BLACK;
                        w.color = RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;

    }

    // 找完全左叶子
    private RB_tree_node<T> mini_mum(RB_tree_node<T> x){
        while(x.left!=null){
            x=x.left;
        }

        return x;
    }

    // 找完全右叶子
    private RB_tree_node<T> max_mum(RB_tree_node<T> x){
        while(x.right!=null){
            x=x.right;
        }

        return x;
    }

    // 替换节点
    private void transplant(RB_tree_node<T> root,RB_tree_node<T> u, RB_tree_node<T> v){

    }
}
