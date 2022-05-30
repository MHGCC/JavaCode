package LeetCode;
public class code27 {
    public static int removeElement(int[] nums, int val) {
        int flag=0;
        int tail=nums.length-1;
        int n=0;
        while(flag<=tail){
            if(nums[flag]!=val){
                flag=flag+1;
            }
            else{
                n=n+1;
                for(int i=flag;i<=tail-1;i++){
                    nums[i]=nums[i+1];
                }
                tail=tail-1;
            }
        }
        return nums.length-n;
    }

    public static void main(String[] args){
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;
        System.out.print(removeElement(nums,val));
    }
}
