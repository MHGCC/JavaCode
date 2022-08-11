package LeetCode;

import LeetCode.my_priority_queue;

public class test_priority_queue {
    public static void main(String[] args){
        my_priority_queue queue=new my_priority_queue();
        int[] nums={2,5,3,4,8,7,9,0,1};
        for(int i:nums){
            queue.insert(i);
        }
        while(queue.size>0){
            System.out.println(queue.extract_min());
        }
    }
} 
