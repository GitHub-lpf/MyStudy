package lpf.study.thread.productconsumer;

public class ProductGoods implements Runnable{

    private Stock stock;

    public ProductGoods() {
    }

    public ProductGoods(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        while (true){
            stock.product();
        }

    }
}
