// 这样可能反而慢了？相比于直接搜索前移
package LeetCode;

public class code26new {
    public static int removeDuplicates(int[] nums) {
        int flag=0;
        int head=flag+1;
        int tail=flag+2;
        int temp=nums.length;
        while(tail<nums.length){
            while((head<nums.length-1)&&(tail<nums.length)){
                while((head<nums.length)&&(nums[head]!=nums[flag])){
                    head=head+1;
                    tail=tail+1;
                }
                while((tail<nums.length)&&(nums[tail]==nums[flag])){
                    tail=tail+1;
                }
                if((head<nums.length-1)&&(tail<nums.length)){
                    nums[head]=nums[tail];
                    head=head+1;
                }
            }
            flag=flag+1;
            head=flag+1;
            tail=flag+2;        
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                temp=i+1;
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args){
        int[] nums={1,1,2};
        System.out.print(removeDuplicates(nums));
    }    
}
