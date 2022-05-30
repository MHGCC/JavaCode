package LeetCode;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import com.Ari.ListNode;

public class code24 {

    public static ListNode swapPairs(ListNode head) {
        //虚拟头结点
        ListNode temp1=new ListNode();
        ListNode head_new=temp1; //记录return的链表的头结点
        ListNode temp2=null;
        //初始位置，left设置在链表前一位，right设置在链表首位
        ListNode left=null;
        ListNode right=head;
        temp1.next=right;
        //标志位，true时进行交换
        boolean flag=false;
        while(right!=null){
            if(flag){
                temp2=right.next;
                temp1.next=right;
                right.next=left;
                left.next=temp2;
                //更新temp1
                temp1=right;
                /*
                //更新left和right位置,但left和right已发生互换，所以不能这样更新了
                left=right;
                right=right.next;
                */
                //left不动，right后移两位,temp1也要更新
                right=left.next;
                temp1=left;
                //更新flag
                flag=false;
            }
            else{
                left=right;
                right=right.next;
                flag=true;
            }
        }
        return head_new.next;
    }

    static class Inner{
        public static void main(String[] args){
            ListNode head_null=new ListNode();
            ListNode head3=new ListNode(1);
            ListNode head2=new ListNode(2,head3);
            ListNode head1=new ListNode(3,head2);
            ListNode head=new ListNode(4,head1);
            ListNode head_result=swapPairs(head3);
            while(head_result!=null){
                System.out.println(head_result.val);
                head_result=head_result.next;
            }
        }
    }
}
