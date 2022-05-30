package LeetCode;
import com.Ari.ListNode;

public class code203 {
    static ListNode removeElements(ListNode head, int val) {
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode point_head = dummy;
        ListNode point_current = point_head.next;
        while(point_current!=null){
            if(point_current.val==val){
                point_head.next=point_current.next;
            }
            else{
                point_head=point_head.next;
            }
            point_current=point_current.next;
        }
        return dummy.next;
    }

    static class Inner{
        public static void main(String[] args){
            ListNode head_null=new ListNode();
            ListNode head3=new ListNode(7);
            ListNode head2=new ListNode(2,head3);
            ListNode head1=new ListNode(7,head2);
            ListNode head=new ListNode(7,head1);
            ListNode head_result=removeElements(head,7);
            while(head_result!=null){
                System.out.println(head_result.val);
                head_result=head_result.next;
            }
        }
    }

}
