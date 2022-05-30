package LeetCode;
/*
    因为是选取连续段，所以可以使用两个指针进行标记。
*/
public class code209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int head=0;
        int tail=0;
        int sum=nums[tail];
        int left=0;
        int right=nums.length;
        boolean flag=false;
        while(tail<nums.length){
            if(sum>=target){
                flag=true;
                if((right-left)>(tail-head)){
                    left=head;
                    right=tail;
                }
                sum=sum-nums[head];
                head=head+1;               
            }
            else{               
                tail=tail+1;
                if(tail<nums.length){
                    sum=sum+nums[tail];
                }
            }
        }
        if(flag){
            return right-left+1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args){
        int[] nums={1,1,1};
        int target=7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
