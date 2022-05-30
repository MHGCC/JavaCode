package LeetCode;

public class code35 {

    public static void main(String[] args){
        int nums[]=new int[]{1,3,5,6};
        int target=5;
        int head=0;
        int tail=nums.length-1;
        int middle=(head+tail)/2;
        while ((head<tail)) {
            if(nums[middle]==target){
                break;
            }
            else if(nums[middle]<target){
                head=middle+1;
                middle=(head+tail)/2;
            }
            else if(nums[middle]>target){
                tail=middle-1;
                middle=(head+tail)/2;
            }
        }
        if(nums[middle]>=target){
            System.out.print(middle);
        }
        else if(nums[middle]<target){
            System.out.print(middle+1);
        }
    }    
}
