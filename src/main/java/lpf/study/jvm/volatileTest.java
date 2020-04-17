package lpf.study.jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class volatileTest {


    //static volatile  int num =0;
    static AtomicInteger num = new AtomicInteger(0);


    public static void main(String[] args) throws  Exception {
        // volatile 原子性操作
        // 多线程环境下 需要共享变量 volatile 及时同步变量 但不能保证原子性和线程安全
        //
        //


        for (int i=0;i<20;i++){
            new Thread(()->{
               for (int j =0;j<3000;j++){
                   //num++;   //47426 58360
                   num.incrementAndGet();//60000

               }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(num);
    }
}
