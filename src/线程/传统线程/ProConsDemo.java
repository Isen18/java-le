package 线程.传统线程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Isen
 * @date 2018/10/29 19:21
 * @since 1.0
 */
public class ProConsDemo {

    /**
     * 仓库
     */
    static class Repository{

        /**
         * 仓库容量
         */
        private int capacity;

        /**
         * 产品容器
         */
        private List<Product> container;

        public Repository(int capacity) {
            if(capacity < 0){
                throw new IllegalArgumentException("capacity 需要大于0");
            }

            this.capacity = capacity;
            this.container = new ArrayList<>(capacity);
        }

        public synchronized void push(List<Product> productList){
            if(productList == null || productList.size() == 0){
                System.out.println("没有生产的产品需要放入仓库");
                return;
            }

            int index = 0;
            int availableSize = 0;
            int leftSize = productList.size();
            while(leftSize > 0){
                //有产品等待放入仓库
                while(container.size() >= capacity){
                    //需要等待消费者消费
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //可以将产品放入仓库
                availableSize = Math.min(capacity - container.size(), leftSize);
                for (int i = index; i < index + availableSize; i++) {
                    container.add(productList.get(i));
                }
                index += availableSize;
                leftSize -= availableSize;

                //通知消费者可以消费了
                notifyAll();
            }
        }

        public synchronized List<Product> pop(int size){
            if(size < 0){
                throw new IllegalArgumentException("size 需要大于0");
            }

            List<Product> result = new ArrayList<>();
            int leftSize = size;
            int availableSize = 0;
            while(leftSize > 0){
                while (container.size() < 0){
                    //没有产品可以消费，需要等待生产者生产
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //可以消费的产品数量
                availableSize = Math.min(container.size(), leftSize);
                for (int i = 0; i < availableSize; i++) {
                    result.add(container.remove(0));
                }

                leftSize -= availableSize;

                //通知生产者可以生产了
                notifyAll();
            }

            return result;
        }
    }

    /**
     * 生产者
     */
    static class Producer{
        private Repository repository;

        private SeqManager seqManager;

        public Producer(Repository repository, SeqManager seqManager) {
            this.repository = repository;
            this.seqManager = seqManager;
        }

        public void produce(){
            System.out.println(Thread.currentThread().getName() + "开始生产");
            Product product = new Product("电脑", seqManager.getNextSeqNo());
            repository.push(Arrays.asList(product));
            System.out.println(Thread.currentThread().getName() + "生产了一个产品，并放入仓库中 " + product.toString());
        }
    }

    /**
     * 消费者
     */
    static class Consumer{
        private Repository repository;

        public Consumer(Repository repository) {
            this.repository = repository;
        }

        public void consume(int size){
            System.out.println(Thread.currentThread().getName() + "开始消费");
            List<Product> products = repository.pop(size);
            System.out.println(Thread.currentThread().getName() + "从仓库获取并消费了一个产品 " + products.toString());
        }
    }

    /**
     * 产品
     */
    static class Product{

        /**
         * 名称
         */
        private String name;

        /**
         * 产品序列号
         */
        private Long seqNo;

        public Product(String name, Long seqNo) {
            this.name = name;
            this.seqNo = seqNo;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", seqNo=" + seqNo +
                    '}';
        }
    }

    /**
     * 序列号管理中心
     */
    static class SeqManager{
        private AtomicLong seqNoGenerator = new AtomicLong();

        public Long getNextSeqNo(){
            return seqNoGenerator.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        Repository repository = new Repository(50);
        SeqManager seqManager = new SeqManager();

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    new Producer(repository, seqManager).produce();
                }
            }.start();

        }

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    new Consumer(repository).consume(3);

                }
            }.start();
        }
    }
}
