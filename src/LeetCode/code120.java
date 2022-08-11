//
package LeetCode;

import java.util.Stack;

public class code120 {

    //因为数字范围是int,所以增加一个判断字符串是否能转换为数字的函数
    //使用Java函数或者正则表达式实现
    public static Boolean is_int(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack_tokens=new Stack<>();
        int result_int=0;
        int temp_a,temp_b;
        for(int i=0;i<tokens.length;i++){
            //由于包含0-9数字，所以不太好用switch case
            if(is_int(tokens[i])){
                stack_tokens.push(Integer.parseInt(tokens[i]));
            }
            else{
                switch(tokens[i]){
                    case "+":
                        temp_a=stack_tokens.pop();
                        temp_b=stack_tokens.pop();
                        stack_tokens.push(temp_b+temp_a);
                        break;
                    case "-":
                        temp_a=stack_tokens.pop();
                        temp_b=stack_tokens.pop();
                        stack_tokens.push(temp_b-temp_a);
                        break;                    
                    case "*":
                        temp_a=stack_tokens.pop();
                        temp_b=stack_tokens.pop();
                        stack_tokens.push(temp_b*temp_a);
                        break; 
                    case "/":
                        temp_a=stack_tokens.pop();
                        temp_b=stack_tokens.pop();
                        stack_tokens.push(temp_b/temp_a);
                        break; 
                }
            }
        }
        result_int=stack_tokens.pop();
        return result_int;
    }   
    
    public static void main(String[] args){
        String[] s={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }
}
