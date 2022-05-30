package LeetCode;

public class code69 {
    public static int mySqrt(int x){
        long head=0;
        long tail=x;
        long middle=((head+tail)/2);
        while ((head<=tail)) {
            if(middle*middle==x){
                break;
            }
            else if(middle*middle<x){
                head=middle+1;
                middle=((head+tail)/2);
            }
            else {
                tail=middle-1;
                middle=((head+tail)/2);
            }
        }
        return (int)middle;
    }

    public static void main(String[] args){
        int x=(int)(Math.pow(2,31)-1);
        //int x=2147395699;
        System.out.println(mySqrt(x));
    }
}