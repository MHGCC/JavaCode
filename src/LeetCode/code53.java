// 这题我仍然没有想到拆分的方法
// 策略： 1 遇到正数直接加；2 遇到负数，需要考虑连接该负数连接两段数据后是否能得到更大的sum
// 考虑了一下，用动态规划可能更好
package LeetCode;

public class code53 {
    public static int maxSubArray(int[] nums) {
        // 策略很简单，只要加数不会使cur_sum<0就加
        int sum=nums[0];
        int cur_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur_sum<0 && nums[i]>cur_sum){
                cur_sum=nums[i];
            }
            else{
                cur_sum=cur_sum+nums[i];
            }

            if(cur_sum>sum){
                sum=cur_sum;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
