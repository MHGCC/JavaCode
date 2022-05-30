package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
    理一下思路
    要避免排序的话，就按正负分成两个数组，然后填入一个数组中去。
    注意极端条件，比如只有一个元素的输入数组。
*/
public class code977 {
    public static int[] sortedSquares(int[] nums) {
        int middle=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]*nums[i+1]<=0){
                middle=i;
                break;
            }
        }
        if((middle+1<nums.length)&&(nums[middle]*nums[middle+1]>0)){
            if(nums[0]<0){
                middle=nums.length-1;
            }
        }
        System.out.println(middle);
        int[] nums_new=new int[nums.length];
        int head=middle;
        int tail=middle+1;
        for(int i=0;i<nums_new.length;i++){
            if(head<0){
                nums_new[i]=nums[tail]*nums[tail];
                tail=tail+1;
            }
            else if(tail>=nums_new.length){
                nums_new[i]=nums[head]*nums[head];
                head=head-1;
            }
            else{
                if(nums[tail]*nums[tail]>nums[head]*nums[head])
                {
                    nums_new[i]=nums[head]*nums[head];
                    head=head-1;
                }
                else{
                    nums_new[i]=nums[tail]*nums[tail];
                    tail=tail+1;
                }
            }
        }
        return nums_new;
    }
    
    public static void main(String[] args){
        int[] nums={-2,-1,3};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
