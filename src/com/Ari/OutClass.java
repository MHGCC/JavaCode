package com.Ari;

public class OutClass {
    
    InnerClass in=new InnerClass();

    class InnerClass{
        int y=0;
        public int inf(){
            return 1;
        }
    }

    public InnerClass doit(){
        //这里的y与InnerClass里的成员变量无冲突
        in.y=4;
        return new InnerClass();
    }

    public static void main(String args[]){
        //调试后可以发现这里实例化一个OutClass类对象out后，out里什么也没有，只占一个地址。这是未加实例化
        // 加实例化之后，生成了out.in,也出现了this（没有实例化的对象的话不会有this吗），this=out，this.in=out.in
        OutClass out=new OutClass();
        //InnerClass in=new InnerClass();   // InnerClass确实不能在没有依赖OutClass的情况下单独定义，哪怕还在OutClass类中
        OutClass.InnerClass in=out.doit();
        //运行到这里为止，产生了一个out实例OutClass@11,两个in实例(OutClass$InnerClass@18和OutClass$InnerClass@19,这里的地址可变。它们的
        //成员参数y的值分别为4和0)
        /*
        思考一下这里应该怎么描述
        实例化一个外部类，内部类若在外部类中实例化，则必然附带一个。
        在主方法中哪怕使用和外部类中同名的内部类对象也没有关系，它们的生效空间不同，但在外部类中的主方法也能访问外部类中实例化的内部类对象
        */
        OutClass.InnerClass in2=out.new InnerClass();
        //这三个内部类对象都依赖于同一个外部类对象
    }

}
