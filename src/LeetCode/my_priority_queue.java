package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class my_priority_queue{
    // 动态数组构建队列的主体
    public ArrayList<Integer> priority_queue;
    public int size;
    // 无输入参数初始化
    public my_priority_queue(){
        this.priority_queue=new ArrayList<>();
        this.size=0;
    }

    public int minimum(){
        try{
            return priority_queue.get(0);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Queue is null !");
        }
        return 0;
    }

    public void insert(int x){
        //末位添加一个新元素x
        priority_queue.add(x);
        size=size+1;
        replace_key(size-1, x);
    }

    public void replace_key(int i,int x){

        priority_queue.set(i,x);
        int j=i;
        int temp;
        while((j>0)&&(priority_queue.get(j)<priority_queue.get((j-1)/2))){
            temp=priority_queue.get((j-1)/2);
            priority_queue.set((j-1)/2,priority_queue.get(j));
            priority_queue.set(j,temp);
            j=(j-1)/2;
        }
    }

    public int extract_min(){
        try{
            int min=priority_queue.get(0);
            priority_queue.set(0,priority_queue.get(size-1));
            priority_queue.remove(size-1);
            size=size-1;
            // 保持堆顶为最小值，弹出后重排堆
            min_heapify(0);
            return min;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Queue is null !");
        }
        return 0;
    }

    public void min_heapify(int i){
        //小堆重排，从根节点开始
        int min=i;
        int left=2*min+1;
        int right=2*min+2;
        if((left<size)&&(priority_queue.get(left)<priority_queue.get(min))){
            min=left;
        }
        if((right<size)&&(priority_queue.get(right)<priority_queue.get(min))){
            min=right;
        }
        // 除给定的节点外，其他都遵守根节点小于左右子树，所以其他不用调整
        if(min!=i){
            int temp;
            temp=priority_queue.get(i);
            priority_queue.set(i,priority_queue.get(min));
            priority_queue.set(min,temp);
            min_heapify(min);
        }
    }
}
