package LeetCode;

public class code26 {
    public static int removeDuplicates(int[] nums) {
        int flag=0;
        int head=flag+1;
        int tail=nums.length-1;
        int temp;
        while(flag<tail){
            while(head<=tail){
                if(nums[head]!=nums[flag]){
                    head=head+1;
                }
                else{
                    if(nums[tail]!=nums[flag]){
                        nums[head]=nums[tail];
                        tail=tail-1;
                    }
                    else{
                        tail=tail-1;
                    }
                }
            }
            flag=flag+1;
            head=flag+1;
        }
        return nums.length-flag;
    }

    public static void main(String[] args){
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.print(removeDuplicates(nums));
    }
}
