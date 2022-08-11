// 这里有什么可以拆分的吗，，不就是一个个比较过去？
// 可以删除一些数据组合成新的序列，这样的话肯定可以使用递归（给出序列）
// 推演，特殊情况

package LeetCode;

public class code376 {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        else if(nums.length==2){
            if(nums[0]==nums[1]){
                return 1;
            }
            else{
                return 2;
            }
        }
        else{
            //当前差值
            int curDiff = 0;
            //上一个差值
            int preDiff = 0;
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                //得到当前差值
                curDiff = nums[i] - nums[i - 1];
                //如果当前差值和上一个差值为一正一负
                //等于0的情况表示初始时的preDiff
                if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                    count++;
                    preDiff = curDiff;
                }
            }
            return count;
        }
    }
    
    public static void main(String[] args){
        int[] nums={1,2,1,6,6}; 
        System.out.println(wiggleMaxLength(nums));
    }
}
