package tools;
import tools.merge_sort;

public class test_merge_sort {
    public static void main(String[] args){
        int[] nums={9,6,43,56,34,6,3,6,2,4,5,36,453,23,4545,1,1,1,2,4};
        merge_sort merge_sort=new merge_sort(nums);
        for(int i:merge_sort.nums){
            System.out.printf("%d ",i);
        }
    }    
}
