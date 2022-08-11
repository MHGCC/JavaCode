package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class my_queue{
    Deque<Integer> basic_dqueue;
    public my_queue(){
        this.basic_dqueue=new LinkedList<Integer>();
    }

    public void add(int x){
        //从队尾开始比较
        while((!this.basic_dqueue.isEmpty())&&(x>this.basic_dqueue.peekLast())){
            this.basic_dqueue.pollLast();
        }
        this.basic_dqueue.addLast(x);
    }

    public void del(int x){
        //判断队首元素是否是窗移除元素
        if((!this.basic_dqueue.isEmpty())&&(this.basic_dqueue.peek()==x)){
            this.basic_dqueue.poll();
        }
    }

    public int peek(){
        if(!this.basic_dqueue.isEmpty()){
            return this.basic_dqueue.peek();
        }
        else{
            return -1;
        }
    }

    public Boolean is_empty(int x){
        if(this.basic_dqueue.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
