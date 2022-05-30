/*
我写的这个还需要加不少小操作，确实有一些问题，比如区间head<tail，但更新时使用head=middle+1,tail=middle-1,这样弹出条件是head==tail
但是退出时仍不能判断是否真的找到了target。建议换成head<=tail。
另外，在这题的思路上，不对middle1=(head1+tail1)/2;进行微调的话，选择寻找target的边界，target_left-1,target_right+1更容易
**/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class code34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] arr;
        // 空字符串判定
        if(nums.length==0){
            arr=new int[2];
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        else{
            //手推一遍，用两个二分搜索确实很简单，相当于搜索target(min)，和target(max)
            int head1=0;
            int tail1=nums.length-1;
            int middle1=(head1+tail1)/2;
            while ((head1<tail1)) {
                if(nums[middle1]==target){
                    head1=middle1;
                    middle1=(head1+tail1+1)/2;
                }
                else if(nums[middle1]<target){
                    head1=middle1+1;
                    middle1=(head1+tail1)/2;
                }
                else {
                    tail1=middle1-1;
                    middle1=(head1+tail1)/2;
                }
            }
            int head2=0;
            int tail2=nums.length-1;
            int middle2=(head2+tail2)/2;
            while ((head2<tail2)) {
                if(nums[middle2]==target){
                    tail2=middle2;
                    middle2=(head2+tail2)/2;
                }
                else if(nums[middle2]<target){
                    head2=middle2+1;
                    middle2=(head2+tail2)/2;
                }
                else {
                    tail2=middle2-1;
                    middle2=(head2+tail2)/2;
                }
            }
            if((nums[head1]==target)&&(nums[tail2]==target)){
                arr=new int[2];
                arr[0]=tail2;
                arr[1]=head1;
                return arr;
            }
            else{
                arr=new int[2];
                arr[0]=-1;
                arr[1]=-1;
                return arr; 
            }
        }
    }
    
    public static void main(String[] args){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] new_nums=searchRange(nums,target);
        System.out.println(Arrays.toString(new_nums));
    }
}
