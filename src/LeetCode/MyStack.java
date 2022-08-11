package LeetCode;
// 使用两个队列实现栈，使用一个暂存队列，逻辑清晰，但操作步数多
// Leetcode仍然不做空错误样例
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    //声明两个队列
    Queue<Integer> queue_master;
    Queue<Integer> queue_temp;

    public MyStack() {
        this.queue_master = new LinkedList<Integer>();
        this.queue_temp = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue_master.add(x);
    }
    
    public int pop() {
        int element_pop;
        while(queue_master.size()>1){
            queue_temp.add(queue_master.poll());
        }
        element_pop=queue_master.poll();
        while(!queue_temp.isEmpty()){
            queue_master.add(queue_temp.poll());
        }
        return element_pop;
    }
    
    public int top() {
        int element_top;
        while(queue_master.size()>1){
            queue_temp.add(queue_master.poll());
        }
        element_top=queue_master.peek();
        queue_temp.add(queue_master.poll());
        while(!queue_temp.isEmpty()){
            queue_master.add(queue_temp.poll());
        }
        return element_top;        
    }
    
    public boolean empty() {
        if(queue_master.isEmpty()){
            return true;
        }
        return false;
    }
}
