package lpf.study.thread;

class  VIP implements Runnable{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("VIP正在练车:"+i);
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class  Common implements Runnable{

    Thread vip ;

    public Common(Thread vip) {
        this.vip = vip;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("普通学员正在练车:"+i);
                Thread.sleep(1000);
                if(i==18){
                    vip.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Demo1 {

    //1.驾校练车： 某个驾校每天只能给30个学生练车，有20个普通学生，10个vip。开始时，普通和VIP并发叫号
    //
    //- 叫到vip的概率比普通的高。
    //- vip的练车时间是普通学生的3倍；
    //- 要求vip学生必须在 普通学员之前全部结束。

    public static void main(String[] args) {


        Thread vip = new Thread(new VIP());
        Thread common =new Thread(new Common(vip));
        vip.setPriority(Thread.MAX_PRIORITY);
        common.setPriority(Thread.NORM_PRIORITY);

        vip.start();
        common.start();

    }
}
