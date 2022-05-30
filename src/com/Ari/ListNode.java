package com.Ari;
/*
    Java里用对象替换了C/C++中对指针和地址的操作，ListNode.next的类型仍然是ListNode，这保证链表的顺序检索过程顺利进行
    这种类内的自定义还是很不熟悉。。。（也可以理解为ListNode对象和对象之间直接赋值就是给出了一个地址，就像直接输出数组元素只会
    --输出数组的首地址一样。
    另外注意，在其他文件中引用这个链表类的话，要把val和next public，不然不可见。

*/
// 按照707，设计链表
public class ListNode {
    public int val;
    public ListNode next;
    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
