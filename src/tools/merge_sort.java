package tools;

import java.util.Arrays;

public class merge_sort {
    public int[] nums;

    public merge_sort(int[] input_nums){
        this.nums=Arrays.copyOf(input_nums, input_nums.length);
        sort(0,this.nums.length-1);
    }   
    
    public void sort(int left,int right){
        if(left<right){
            sort(left,(left+right)/2);
            sort((left+right)/2+1,right);
            int[] nums_temp_1=Arrays.copyOfRange(nums,left,(left+right)/2+1);
            int[] nums_temp_2=Arrays.copyOfRange(nums,(left+right)/2+1,right+1);
            //合并两个分别排好序的数组段
            int i=left-1;
            int j=0;
            int k=0;
            while((j<nums_temp_1.length)&&(k<nums_temp_2.length)){
                i=i+1;
                if(nums_temp_1[j]<nums_temp_2[k]){
                    nums[i]=nums_temp_1[j];
                    j=j+1;
                }
                else{
                    nums[i]=nums_temp_2[k];
                    k=k+1;
                }
            }
            // 将剩余的数据直接填入
            while(j<nums_temp_1.length){
                i=i+1;
                nums[i]=nums_temp_1[j];
                j=j+1;
            }
            while(k<nums_temp_2.length){
                i=i+1;
                nums[i]=nums_temp_2[k];
                k=k+1;
            }
        }
    }
}
