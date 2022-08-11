package LeetCode;

import java.util.Arrays;

public class code406_sort {
// 以height为主变量，排序people数组
    public int[][] nums;

    public code406_sort(int[][] input_nums){
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
        int x=nums[right][0];
        int y=nums[right][1];
        // i为前段的指针,i+1即为分界点（x的填入位置）
        int i=left-1;
        for(int j=left;j<right;j++){
            //将比x小的都移到前段，或者height相等，但k更小
            if((nums[j][0])<x || (nums[j][0]==x && nums[j][1]>y)){
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
        temp=nums[i][0];
        nums[i][0]=nums[j][0];
        nums[j][0]=temp;

        temp=nums[i][1];
        nums[i][1]=nums[j][1];
        nums[j][1]=temp;
    }  
}
