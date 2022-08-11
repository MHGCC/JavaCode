package LeetCode;

public class code509 {
    public static int fib(int n) {
        // max(n)=30
        int[] fib_n=new int[n+1];

        fib_n[0]=0;
        fib_n[1]=1;
        for(int i=2;i<=n;i++){
            fib_n[i]=fib_n[i-1]+fib_n[i-2];
        }

        return fib_n[n];
    }

    public static void main(String[] args){
        int n=8;
        System.out.println(fib(n));
    }
}
