// 房屋的结构变成了一个环
// 我这里是正向和逆向，范例里是去掉头尾，中间先处理，然后考虑首尾

package LeetCode;

public class code213 {
    public static int rob(int[] nums){
        int[] result=new int[nums.length+1];
        if(nums.length==1){
            return nums[0];
        }
        result[0]=nums[0];
        result[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length-1;i++){
            result[i]=Math.max(result[i-2]+nums[i],result[i-1]);
        }

        int max_rob=result[nums.length-2];

        // back_ward
        result[nums.length-1]=nums[nums.length-1];
        result[nums.length-2]=Math.max(nums[nums.length-1],nums[nums.length-2]);
        for(int i=nums.length-3;i>0;i--){
            result[i]=Math.max(result[i+2]+nums[i],result[i+1]);
        }
 
        max_rob=Math.max(max_rob,result[1]);

        return max_rob;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,1};
        rob(nums);
    }
}
