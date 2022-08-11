package tools;

import java.util.Arrays;
import java.util.Random;

public class q_sort_random {
    public int[] nums;
    Random r=new Random();

    public q_sort_random(int[] input_nums){
        this.nums=Arrays.copyOf(input_nums, input_nums.length);
        sort(0,this.nums.length-1);
    }

    public void sort(int left,int right){
        if(left<right){
            int middle=move(left,right);
            sort(left,middle-1);
            sort(middle+1,right);
        }
    }

    public int move(int left,int right){
        //要保证nums[k]为循环中的不变量
        int k=r.nextInt(left,right+1);
        exchange(right, k);
        int x=nums[right];
        // i为前段的指针,i+1即为分界点（x的填入位置）
        int i=left-1;
        for(int j=left;j<right;j++){
            //将比x小的都移到前段
            if(nums[j]<=x){
                i=i+1;
                exchange(i, j);
            }
        }
        i=i+1;
        exchange(i, right);
        return i;
    }

    public void exchange(int i,int j){
        int temp;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }    
}
