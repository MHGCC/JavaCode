package com.Ari;

class test1{
    public static int add(int a,int b){
        return 1;
    }

    public static double add(double a,double b){
        return 2;
    }

    public static int add(int a){
        return 3;
    }

    public static int add(int a,double b){
        return 4;
    }

    public static int add(double a,int b){
        return 5;
    }
}

public class Overload_test {
    public static void main(String[] args){
        test1 c=new test1();
        System.out.println(c.add(int a=1,double b=1.0));
    }
}
