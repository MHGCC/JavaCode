package tools;

/*
 //快排核心是每次分治的时候都选出一个位置的值（以下程序中是末尾值）x，然后按比x小和比x大将当前的序列分为两段
 */
import java.util.Arrays;

public class q_sort {
    public int[] nums;

    public q_sort(int[] input_nums){
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
