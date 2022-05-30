package LeetCode;
//Leetcode自己标的code中的样例可能自己都不用，比如这题 push 1; pop 1;peek ; 会在peek出错
import java.util.Stack;

public class code232 {

    class MyQueue {
        public Stack<Integer> stack_in;
        public Stack<Integer> stack_out;

        public MyQueue() {
            this.stack_in=new Stack<Integer>();
            this.stack_out=new Stack<Integer>();            
        }
        
        public void push(int x) {
            stack_in.push(x);
        }
        
        public int pop() {
            if(stack_out.empty()){
                while(!stack_in.empty()){
                    stack_out.push(stack_in.pop());
                }
            }
            return stack_out.pop();

        }
        
        public int peek() {
            if(stack_out.empty()){
                while(!stack_in.empty()){
                    stack_out.push(stack_in.pop());
                }
            }
            return stack_out.peek();            
        }
        
        public boolean empty() {
            if((stack_in.empty())&&(stack_out.empty())){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public static void main(String[] args){
        int x=1;
        int y=2;
        code232 a = new code232();
        MyQueue obj = a.new MyQueue();
        obj.push(x);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
    }
}
