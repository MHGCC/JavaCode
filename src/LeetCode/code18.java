package LeetCode;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
// 双指针法，四数之和
public class code18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results=new ArrayList<>();
        //四个数的话，指针的移动就很麻烦，当前的想法是锁定头尾，中间的进行移动
        if(nums.length>=4){
            Arrays.sort(nums);
            int head=0;
            int tail=nums.length-1;
            int point_after_head=head+1;
            int point_before_tail=tail-1;
            //加一个flag用于判别指针移动,这个flag在=0时不太行，只能再套一个循环吧
            Boolean flag=true;
            //head迭代
            while(head+1<tail-1){
                //tail迭代
                while(head+1<tail-1){
                    while(point_after_head<point_before_tail){
                        if(nums[point_after_head]+nums[point_before_tail]+nums[head]+nums[tail]<target){
                            while((point_after_head<point_before_tail)&&(nums[point_after_head]==nums[point_after_head+1])){
                                point_after_head=point_after_head+1;
                            }
                            point_after_head=point_after_head+1;
                        }
                        else if(nums[point_after_head]+nums[point_before_tail]+nums[head]+nums[tail]>target){
                            while((point_after_head<point_before_tail)&&(nums[point_before_tail-1]==nums[point_before_tail])){
                                point_before_tail=point_before_tail-1;
                            }
                            point_before_tail=point_before_tail-1;
                        }
                        else{
                            results.add(Arrays.asList(nums[head], nums[point_after_head],nums[point_before_tail],nums[tail]));
                            while((point_after_head<point_before_tail)&&(nums[point_after_head]==nums[point_after_head+1])){
                                point_after_head=point_after_head+1;
                            }
                            point_after_head=point_after_head+1;
                        }
                    }
                    while((head+1<tail-1)&&(nums[tail-1]==nums[tail])){
                        tail=tail-1;
                    } 
                    tail=tail-1;  
                    point_after_head=head+1;
                    point_before_tail=tail-1;                    

                }
                while((head+1<nums.length-2)&&(nums[head+1]==nums[head])){
                    head=head+1;
                } 
                head=head+1;
                tail=nums.length-1;  
                point_after_head=head+1;
                point_before_tail=tail-1;                
            }
            return results;
        }
        else{
            return results;
        }
    }
    
    public static void main(String[] args){
        int[] nums ={2,2,2,2,2};
        int target=8;
        fourSum(nums,target);
    }
}
