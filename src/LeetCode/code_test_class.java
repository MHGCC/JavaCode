package LeetCode;
import LeetCode.MyStack;

public class code_test_class {
    public static void main(String[] args){
        MyStack test_stack=new MyStack();
        test_stack.push(2);
        int param_2 = test_stack.top();
        int param_3 = test_stack.pop();
        boolean param_4 = test_stack.empty();
    }
}
