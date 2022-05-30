package LeetCode;
import java.util.HashSet;
// n的范围是int范围，这里要开数组做hash的话太大了，用内置hash表
public class code202 {
    // 计算各位平方和
    public static int get_sum(int n){
        int sum=0;
        int value_yu=0;
        while(n>0){
            value_yu=n%10;
            n=n/10;
            sum=sum+value_yu*value_yu;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        //HashSet 用来存放已有的计算结果
        HashSet<Integer> int_sums = new HashSet<Integer>();
        while((n!=-1)&&(int_sums.contains(n)==false)){
            int_sums.add(n);
            n=get_sum(n);
        }
        if(n==1){
            return true;
        }
        else{
            return false;
        }
    }   
    public static void  main(String[] args){
        int n=2;
        System.out.println(isHappy(n));
    } 
}
