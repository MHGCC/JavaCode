package LeetCode;

import java.util.Map;
import java.util.Stack;
import java.util.Collection;
import java.util.HashMap;
import LeetCode.my_priority_queue;

class code347 {
    public static int getkey(Map numbers_count,int value){
        for(Object i:numbers_count.keySet()){
            //ksySet()返回object集合，这里得强制类型转换
            if(numbers_count.get(i).equals(value)){
                return (Integer)(i);
            }
        }
        return 0;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] nums_result=new int[k];
        // 使用map记录出现频次
        Map<Integer, Integer> numbers_count=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numbers_count.containsKey(nums[i])){
                numbers_count.replace(nums[i], numbers_count.get(nums[i]), numbers_count.get(nums[i])+1);
            }
            else{
                numbers_count.put(nums[i],1);
            }
        }
        /*
        // 这题不要求输出数组的顺序，所以其实不用严格排序。但要求n(log(n))的时间限制，其实任何n(log(n))的排序方法都行
        // 但是Map怎么排序。。再设置一个Map，这次以numbers_count的value为key
        // Collection<Integer> numers_values=numbers_count.values();
        // values方法返回的是一个集合（集合类型）,可以通过函数转换为数组
        Integer[] numbers_values=new Integer[numbers_count.size()];
        // toArrat的T[]不包括原始类型，因此int用Integer替代 
        numbers_count.values().toArray(numbers_values);
        */
        // 到此为止，以获取出现频次的数组numbers_values
        // 现在把前k个最大值或n-k个最小值选出来
        // 自己写一个优先队列，不用Java内置的优先性队列
        // 将numbers_count.values()插入到优先队列中，因为结果key序列是惟一的，所以可以把values反过来与key对应

        my_priority_queue priority_queue=new my_priority_queue();

        for(Integer value:numbers_count.values()){
            priority_queue.insert(value);
        }

        while(priority_queue.size>k){
            priority_queue.extract_min();
        }

        //values对应key
        int  i=0;
        while(priority_queue.size>0){
            nums_result[i]=getkey(numbers_count,priority_queue.extract_min());
            // 在map中去掉已弹出的key-value
            numbers_count.remove(nums_result[i]);
            i=i+1;
        }

        return nums_result;
    }

    public static void main(String[] args){
        int[] nums={1,1,1,2,2,2,3,3,3,6,6,5,5,9,9,4,2,2,4,1,0};
        int k=5;
        topKFrequent(nums, k);
    }
}
