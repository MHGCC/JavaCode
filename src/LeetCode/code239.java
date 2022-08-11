package LeetCode;
//平移窗，关键在于构筑一个管理最大值的结构
//设计了一个队列，其运行逻辑为：
//1 先进先出
//2 push的规则为A 空队列时push B 比队首元素大，则其前面的元素都pop
//3 pop的规则 A 平移窗移除队首元素时队列pop队首元素 B 
//Dqueue好像能读取队首和队尾元素，看一下

import java.util.Deque;
import LeetCode.my_queue;;

public class code239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result_nums=new int[nums.length-k+1];
        my_queue queue_239=new my_queue();
        //初始化第一个窗时的状态,这里不涉及窗移动删除队首元素
        for(int i=0;i<k;i++){
            queue_239.add(nums[i]);
        }
        int result_number=0;
        result_nums[result_number]=queue_239.peek();
        for(int i=0;i<nums.length-k;i++){
            queue_239.del(nums[i]);
            queue_239.add(nums[i+k]);
            result_number=result_number+1;
            result_nums[result_number]=queue_239.peek();
        }

        return result_nums;
    }

    public static void main(String[] args){
        int[] nums={1};
        int k=1;
        System.out.println(maxSlidingWindow(nums,k));
    }
}
