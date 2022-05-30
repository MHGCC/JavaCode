package LeetCode;

public class code367 {
    public static boolean isPerfectSquare(int num){
        long head=0;
        long tail=num;
        long middle=(head+tail)/2;
        while ((head<=tail)) {
            if(middle*middle==num){
                break;
            }
            else if(middle*middle<num){
                head=middle+1;
                middle=(head+tail)/2;
            }
            else {
                tail=middle-1;
                middle=(head+tail)/2;
            }
        }
        if(head<=tail){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        int num=(int)(Math.pow(2,31)-1);
        System.out.println(isPerfectSquare(num));
    }
}
