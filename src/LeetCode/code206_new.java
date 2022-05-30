package LeetCode;
import java.util.List;

import com.Ari.ListNode;

//不要新建链表单元，改变连接关系
class code206_new{
    public static ListNode reverseList(ListNode head){
        // 对象默认初始化和对象赋值为null有什么区别
        // 答：有的。初始化即使不设置成员变量，仍然占一个内存空间。而null不占内存空间
        //另外，这些链表题的结尾都是null，和自写的ListNode相同
        ListNode head_new=head;
        ListNode temp=null;
        ListNode pre=null;

        while(head_new!=null){
            temp=head_new.next;
            head_new.next=pre;
            //刚才的做法好像忘记存这个了，会导致连接出现问题
            pre=head_new;
            head_new=temp;
        }
        // 反向输出，应该以最后一个节点作为return；。，。。。
        return pre;
    }

/*
    //原来写的
    public static ListNode reverseList(ListNode head){
        ListNode head_new=new ListNode();
        ListNode temp;
        while(head!=null){
            if(head.next!=null){
                temp=head.next;
                head.next=head_new;
                head_new=head;
                head=temp;
            }
            else{
                head.next=head_new;
                head_new=head;
                head=null;
            }
        }
        return head_new;
    }
*/

    static class Inner{
        public static void main(String[] args){
            ListNode head_null=new ListNode();
            ListNode head3=new ListNode(1);
            ListNode head2=new ListNode(2,head3);
            ListNode head1=new ListNode(3,head2);
            ListNode head=new ListNode(4,head1);
            ListNode head_result=reverseList(head);
            while(head_result!=null){
                System.out.println(head_result.val);
                head_result=head_result.next;
            }
        }
    }
}