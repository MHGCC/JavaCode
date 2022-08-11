package LeetCode;

import java.util.Arrays;

public class small_tree {
    //二叉树的构造
    //这个类的输入应当是待排序的int数组
    //返回排序后的数组
    // 初始化，主体应当是一个数组
    public int[] tree;

    public small_tree(int[] nums){
        int temp;
        //this.tree=new int[nums.length];
        this.tree=(int[])Arrays.copyOf(nums, nums.length);
    }

    public int[] build_small_tree(){
        int temp;
         // 开始构建过程,首次构建小堆
        build_min_heapify();
        // 开始逐次构建，此时的初始状态为根节点是最小值，取出，然后经过一次堆维护将次小的叶节点提上来，同时保证每一个子树仍是小堆
        for(int i=tree.length;i>1;i--){
            temp=tree[i-1];
            tree[i-1]=tree[0];
            tree[0]=temp;
            min_heapify(0,i-1);
        }
            return tree;
    }

    public int left(int i){
        return i*2+1;
    }

    public int right(int i){
        return i*2+2;
    }

    public void min_heapify(int i,int max_length){
        int temp;
        int i_left=left(i);
        int i_right=right(i);
        int min=i;
        if((i_left<max_length)&&(tree[i_left]<tree[min])){
            min=i_left;
        }
        if((i_right<max_length)&&(tree[i_right]<tree[min])){
            min=i_right;
        }
        if(min!=i){
            temp=tree[i];
            tree[i]=tree[min];
            tree[min]=temp;
            min_heapify(min,max_length);
        }
    }

    // 初次遍历，把最小值置于堆顶，同时保证每个子树都是一个小堆（但叶节点的次序没有排好）
    public void build_min_heapify(){
        int nums_length=tree.length;
        for(int i=nums_length/2;i>=0;i--){
            min_heapify(i,nums_length);
        }
    }
}
