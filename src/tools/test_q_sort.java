package tools;
import tools.q_sort;
import tools.q_sort_random;

public class test_q_sort {
    public static void main(String[] args){
        int[] nums={9,6,43,56,34,6,3,6,2,4,5,36,453,23,4545,1,1,1,2,4};
        q_sort nums_q_sort=new q_sort(nums);
        for(int i:nums_q_sort.nums){
            System.out.printf("%d ",i);
        }

        System.out.println();
        
        q_sort_random nums_q_sort_random=new q_sort_random(nums);
        for(int i:nums_q_sort_random.nums){
            System.out.printf("%d ",i);
        }
    }
}
