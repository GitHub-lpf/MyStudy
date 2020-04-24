package lpf.study.thread;


import java.util.concurrent.locks.LockSupport;

public class LockSupport_print {
    //　使用LockSupport.park()/ unpark()
    // 两个线程 一个输出字母  一个输出数字 交替输出1A2B3C4D....26Z

    static Thread t1=null;
    static Thread t2=null;
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        char[] strs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        System.out.println(nums.length);
        System.out.println(strs.length);


        t1= new Thread(()->{
            for (int num:nums) {
                System.out.print(num);
                LockSupport.unpark(t2); // 唤醒 t2
                LockSupport.park();     // 阻塞
            }
        });
        t2= new Thread(()->{
            for (char str:strs) {
                LockSupport.park();     //阻塞
                System.out.print(str);
                LockSupport.unpark(t1); //唤醒 t1
            }
        });


        t1.start();
        t2.start();
    }

}
