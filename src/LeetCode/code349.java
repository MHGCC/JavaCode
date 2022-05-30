package LeetCode;

public class code349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] int_hash=new int[1001];
        for(int i=0;i<int_hash.length;i++){
            int_hash[i]=0;
        }        
        for(int i=0;i<nums1.length;i++){
            int_hash[nums1[i]]=1;
        }
        for(int i=0;i<nums2.length;i++){
            if(int_hash[nums2[i]]>0){
                int_hash[nums2[i]]=2;
            }
        }
        int number_valid=0;
        for(int i=0;i<int_hash.length;i++){
            if(int_hash[i]==2){
                number_valid=number_valid+1;
            }
        }        
        int[] result_return=new int[number_valid];
        int id=0;
        for(int i=0;i<int_hash.length;i++){
            if(int_hash[i]==2){
                result_return[id]=i;
                id=id+1;
            }
        }         
        return result_return;
    }    
    public static void main(String[] args){
        int[] nums1=new int[]{4,9,5};
        int[] nums2=new int[]{1,2,2,3};
        int[] String_results=intersection(nums1,nums2);
    }
}
