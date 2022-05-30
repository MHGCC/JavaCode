package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
// 用Hash解决的思路。只有在确定第三个数才用Hash确认是否重复
// 用双指针法试试，逻辑类似二分法，因为用sum>0||sum<0，判别指针位置
// [0,0,0]是可能存在的
public class code15{
    public static List<List<Integer>> threeSum(int[] nums) {
        // result的类型是List<List<Integer>>，即嵌套数组，但初始化为
        List<List<Integer>> results=new ArrayList<>();
        if(nums.length>=3){
            //先排序
            Arrays.sort(nums);
            // 第一个数
            for(int point_head=0;point_head<nums.length-2;point_head++){
                if((point_head!=0)&&(nums[point_head]==nums[point_head-1])){
                    continue;
                }
                else{
                    int point_tail=nums.length-1;
                    int point_current=point_head+1;
                    while(point_tail>point_current){
                        if((nums[point_head]+nums[point_current]+nums[point_tail]>0)&&(point_tail>point_current)){
                            point_tail=point_tail-1;
                        }
                        else if((nums[point_head]+nums[point_current]+nums[point_tail]<0)&&(point_tail>point_current)){
                            point_current=point_current+1;
                        }
                        else {
                            results.add(Arrays.asList(nums[point_head], nums[point_current], nums[point_tail]));
                            //这里不设置为break，而选择point_tail前移
                            while((point_tail-1>=0)&&(nums[point_tail-1]==nums[point_tail])){
                                point_tail=point_tail-1;
                            }
                            point_tail=point_tail-1;
                        }
                    }
                }
            }
            return results;
        }
        else{
            return results;
        }
    }

    public static void main(String[] args){
        int[] nums ={0,0,0};
        threeSum(nums);
    }
}