/*
    可以达到效果
    但过不了206的要求。
*/
package LeetCode;
import com.Ari.ListNode;

public class code206 {
    //使用这种方法的话我需要不断的创建新的对象，但怎么样在循环中实例化新对象我好像还不会。。。
    public static class ListNode_reverse{
        public int val;
        public ListNode_reverse pre;
        // 节点的构造函数(无参)
        public ListNode_reverse() {
        }
    
        // 节点的构造函数(有一个参数)
        public ListNode_reverse(int val) {
            this.val = val;
        }
    
        // 节点的构造函数(有两个参数)
        public ListNode_reverse(int val, ListNode_reverse pre) {
            this.val = val;
            this.pre = pre;
        }
    }

    public static ListNode_reverse reverseList(ListNode head) {
        // 注意，java中静态方法不能调用动态类
        ListNode_reverse tail=new ListNode_reverse(-5001);
        ListNode_reverse head_new=tail;
        while(head!=null){
            ListNode_reverse temp=new ListNode_reverse(head.val);
            head_new.pre=temp;
            head_new=head_new.pre;
            head=head.next;
        }
        return tail.pre;
    }

    static class Inner{
        public static void main(String[] args){
            ListNode head_null=new ListNode();
            ListNode head3=new ListNode(1);
            ListNode head2=new ListNode(2,head3);
            ListNode head1=new ListNode(3,head2);
            ListNode head=new ListNode(4,head1);
            ListNode_reverse head_result=reverseList(head_null);
            while(head_result!=null){
                System.out.println(head_result.val);
                head_result=head_result.pre;
            }
        }
    }
}
