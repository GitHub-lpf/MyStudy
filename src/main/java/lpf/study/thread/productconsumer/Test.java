package lpf.study.thread.productconsumer;

public class Test {

    public static void main(String[] args) {

        Stock stock = new Stock();

        new Thread(new ProductGoods(stock)).start();

        new Thread(new ProductGoods(stock)).start();


        new Thread(new ConsumerGoods(stock)).start();

        new Thread(new ConsumerGoods(stock)).start();



    }
}
