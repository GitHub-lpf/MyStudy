package lpf.study.thread;

public class ThreadLocalTest {


    public static void main(String[] args) {

        //threadLocalTest();
        threadLocalTest2();


    }

    private static void threadLocalTest2() {
        // ThreadLocal 子类  InheritableThreadLocal 支持共享数据
        // public class InheritableThreadLocal<T> extends ThreadLocal<T> {}

        ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("李鹏飞");

        System.out.println((String) threadLocal.get()+Thread.currentThread().getName());
        new Thread(()->{
            System.out.println("new Thread："+threadLocal.get());
        }).start();

        threadLocal.remove();
    }

    private static void threadLocalTest() {

        // ThreadLocal 如何共享数据

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("李鹏飞");

        String Str = (String) threadLocal.get();

        System.out.println(Str+Thread.currentThread().getName());

        new Thread(()->{
            // new Thread:null Thread-0  无法共享变量
            System.out.println("new Thread:"+threadLocal.get()+Thread.currentThread().getName());
        }).start();

        threadLocal.remove();

        String Str1 = (String) threadLocal.get();
        System.out.println(Str1);
    }


}
