package LeetCode;
import com.Ari.ListNode;
//考虑拆连接，然后能走通就是环。错误
//其实最难的是怎么从环中结束的问题
//提供的解题思路是先判断是否存在环，然后分析环长度

public class code142 {
    public static ListNode detectCycle(ListNode head) {
        ListNode Node_slow=head;
        ListNode Node_fast=head;
        Boolean flag=false;
        int step_size=0;
        while((Node_slow!=null)&&(Node_fast!=null)&&(Node_slow.next!=null)&&(Node_fast.next!=null)&&(Node_fast.next.next!=null)){
            step_size=step_size+1;
            Node_slow=Node_slow.next;
            Node_fast=Node_fast.next.next;
            if(Node_slow==Node_fast){
                flag=true;
                break;
            }
        }
        if(flag){
            ListNode head_new=head;
            while(true){
                ListNode temp=head_new;
                int length=step_size;
                while(length>0){
                    temp=temp.next;
                    length=length-1;
                }
                if(temp==head_new){
                    return head_new;
                }
                else{
                    head_new=head_new.next;
                }
            }
        }
        else{
            return null;
        }
    }

    public static void main(String[] args){
        ListNode head_null=new ListNode();
        ListNode head3=new ListNode(1);
        ListNode head2=new ListNode(2,head3);
        ListNode head1=new ListNode(3,head2);
        ListNode head=new ListNode(4,head1);
        //head3.next=head;
        ListNode head_result=detectCycle(head);
        while(head_result!=null){
            System.out.println(head_result.val);
            head_result=head_result.next;
        }
    }
}
