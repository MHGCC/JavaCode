package LeetCode;
import LeetCode.small_tree;

public class test_min_heapify {
    public static void main(String[] args){
        int[] nums={5,4,6,8,2,3,1,9};
        small_tree small_numbers=new small_tree(nums);
        int[] new_nums=small_numbers.build_small_tree();
        System.out.println("ok!");
    }
}
