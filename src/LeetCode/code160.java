package LeetCode;
import com.Ari.ListNode;

//考虑了一下 ，还是迭代吧。
//先默认head不会是交叉点
// 有比迭代简单得多的方法。因为重叠部分是相同的，所以只需比较从链表末端起的相同点位就行（双向），单向就取较小的链表长度。
public class code160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA_temp,headB_temp;
        ListNode head_result=null;
        Boolean flag=false;
        headA_temp=headA;
        headB_temp=headB;
        while((headB_temp!=null)&&(flag==false)){
            while(headA_temp!=null){
                if(headA_temp==headB_temp){
                    flag=true;
                    head_result=headA_temp;
                    break;
                }
                else{
                    headA_temp=headA_temp.next;
                }
            }
            headB_temp=headB_temp.next;
            headA_temp=headA;
        }
        return head_result;
    }

    public static void main(String[] args){
        int n=6;
        int[][] a=generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();   
        }
    }
}
