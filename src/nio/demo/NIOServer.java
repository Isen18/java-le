package nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @author Isen
 * @date 2019/1/15 16:36
 * @since 1.0
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        //创建serverSocketChannel，并监听8080端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        //设置非阻塞，这样才能够使用selector
        serverSocketChannel.configureBlocking(false);

        //将serverSocketChannel注册到selector
        Selector selector = Selector.open();
        //serverSocketChannel只能注册到SelectionKey.OP_ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(3000) == 0){
                System.out.println("过了超时时间，依旧没有请求，可以处理一些其他事情");
                continue;
            }

            System.out.println("处理请求...");

            //获取待处理的SelectionKey
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

            while (keyIter.hasNext()){
                SelectionKey selectionKey = keyIter.next();

                //需要移除SelectionKey，不然下一次selector.select() > 0时，这个SelectionKey又会被处理一次
                keyIter.remove();

                if(selectionKey.isValid()){
                    System.out.println("selectionKey 无效");
                    continue;
                }

                //新建一个线程处理
                new Thread(new Handler(selectionKey)).start();
            }
        }

    }
}
