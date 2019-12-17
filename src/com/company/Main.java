package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1=new MyThread("+");
        MyThread t2=new MyThread("-");
        t1.start();
        t2.start();
        Thread.sleep(4000);
        t1.flag=false;
        t1.join();
        Main.test("1 stopped!");
    }
    public static Object monitor=new Object();
    public  static void test(String m){
        try {
            synchronized(monitor) {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
                //monitor.notify();
                //monitor.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
