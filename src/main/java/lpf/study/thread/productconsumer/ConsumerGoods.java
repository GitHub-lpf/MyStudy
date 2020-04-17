package lpf.study.thread.productconsumer;

public class ConsumerGoods implements Runnable {

    private Stock stock;

    public ConsumerGoods(){

    }

    public ConsumerGoods(Stock stock ){
        this.stock=stock;
    }

    @Override
    public void run() {
        while (true){
            stock.consumer();
        }
    }
}
