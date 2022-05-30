package LeetCode;
/*
    这里调用后续方法的时候要给头指针吗，还是已保存？
    果然初始化时是需要记录
*/

public class MyLinkedList {
    //使用一个内部类作为链表单元类型
    //这个内部类只在MyLinkedList 类的方法中被实例化，所以无所谓public还是private，这里为了不出其他错误，先用public
    public class List_object{
        public int val;
        public List_object next,pre;

        public List_object(){
        }

        public List_object(int val){
            this.val=val;
        }

        public List_object(int val,List_object next,List_object pre){
            this.val=val;
            this.next=next;
            this.pre=pre;
        }
    }

    // MyLinkedList的成员变量，包括链表头和链表尾，需要链表长度吗
    List_object head;
    List_object tail;
    int size;

    //初始化，建立一个虚拟头链表单元。使用双链表，则需要把尾结点也处理了
    public MyLinkedList() {
        this.head=new List_object(-1);
        this.tail=new List_object(-1);
        head.next=tail;
        tail.pre=head;
        this.size=0;
    }
    
    public int get(int index) {
        if((index>=0)&&(index<size)){
            int index_list=0;
            List_object LinkedList_now=head.next;
            while((index_list!=index)&&(LinkedList_now.next!=null)){
                index_list=index_list+1;
                LinkedList_now=LinkedList_now.next;
            }
            return LinkedList_now.val;        
        }
        else{
            return -1;
        }
    }
    
    public void addAtHead(int val) {
        List_object LinkedList_new=new List_object(val);
        LinkedList_new.next=head.next;
        LinkedList_new.pre=head;
        head.next.pre=LinkedList_new;
        head.next=LinkedList_new;
        size=size+1;
    }
    
    public void addAtTail(int val) {
        List_object LinkedList_new=new List_object(val);
        LinkedList_new.pre=tail.pre;
        tail.pre.next=LinkedList_new;
        LinkedList_new.next=tail;
        tail.pre=LinkedList_new;  
        size=size+1;      
    }
    
    public void addAtIndex(int index, int val) {
        if((index>=0)&&(index<=size)){
            List_object LinkedList_new=new List_object(val);
            int index_list=0;
            List_object LinkedList_now=head;
            while((index_list!=index)&&(LinkedList_now.next!=null)){
                index_list=index_list+1;
                LinkedList_now=LinkedList_now.next;
            }
            //从循环中跳出时，index_list指向插入位置前一位，符合要求
            LinkedList_new.pre=LinkedList_now;
            LinkedList_new.next=LinkedList_now.next;
            LinkedList_now.next.pre=LinkedList_new;
            LinkedList_now.next=LinkedList_new;
            size=size+1;
        }
    }
    
    public void deleteAtIndex(int index) {
        if((index>=0)&&(index<size)){
            int index_list=0;
            List_object LinkedList_now=head.next;
            while((index_list!=index)&&(LinkedList_now.next!=null)){
                index_list=index_list+1;
                LinkedList_now=LinkedList_now.next;
            }
            // 从循环中跳出时，index_list指向删去位置
            LinkedList_now.pre.next=LinkedList_now.next;
            LinkedList_now.next.pre=LinkedList_now.pre;
            LinkedList_now=null;
            size=size-1;
        }
    }
    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(9);
        myLinkedList.get(1); 
        myLinkedList.addAtIndex(1, 1);    // linked list becomes 1->2->3
        myLinkedList.addAtIndex(1, 7);           // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(4);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtIndex(1, 4); 
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(5);
    }
}

