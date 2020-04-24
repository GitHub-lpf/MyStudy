package lpf.study.thread;

public class Synchronized_print {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        char[] strs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        final Object o = new Object();
        new Thread(()->{
            synchronized (o){
                for (int num:nums) {
                    System.out.print(num);
                    try {
                        o.notify();
                        o.wait();
                    }catch (Exception e){}
                }
                o.notify();
            }

        }).start();

        new Thread(()->{
            synchronized (o){
                for (char str:strs) {

                    System.out.print(str);
                    try {
                        o.notify();
                        o.wait();
                    }catch (Exception e){}
                }
                o.notify();
            }
        }).start();
    }
}
