package lpf.study.thread.productconsumer;

public class Stock {

    private int num ;


    // 生产
    public synchronized void product(){
        try {

            if (num >= 100) {
                System.out.println("商品已满，等待消费");
                wait();
            }
            num++;
            Thread.sleep((long)(Math.random()*10));
            System.out.println("当前商品数量："+num);
            notifyAll();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // 消费
    public synchronized void consumer(){
        try {
            if (num <= 0) {
                System.out.println("商品售完，等待生产");
                wait();
            }
            num--;
            Thread.sleep((long)(Math.random()*10));
            System.out.println("当前商品数量："+num);
            notifyAll();
        }catch (Exception e){
             e.printStackTrace();
        }
    }
}
