//大堆队列

package LeetCode;

import java.util.ArrayList;

public class my_max_queue{
    // 动态数组构建队列的主体
    public ArrayList<Integer> priority_queue;
    public int size;
    // 无输入参数初始化
    public my_max_queue(){
        this.priority_queue=new ArrayList<>();
        this.size=0;
    }

    public int maximum(){
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
        //默认为x的值比queue[i]的值小
        priority_queue.set(i,x);
        int j=i;
        int temp;
        while((j>0)&&(priority_queue.get(j)>priority_queue.get(j/2))){
            temp=priority_queue.get(j/2);
            priority_queue.set(j/2,priority_queue.get(j));
            priority_queue.set(j,temp);
            j=j/2;
        }
    }

    public int extract_min(){
        try{
            int min=priority_queue.get(0);
            priority_queue.set(0,priority_queue.get(size-1));
            priority_queue.remove(size-1);
            size=size-1;
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
        if(min!=i){
            int temp;
            temp=priority_queue.get(i);
            priority_queue.set(i,priority_queue.get(min));
            priority_queue.set(min,temp);
            min_heapify(min);
        }
    }
}

