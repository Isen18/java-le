package nio.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Isen
 * @date 2019/1/15 19:15
 * @since 1.0
 */
class Handler implements Runnable{
    private final static ConcurrentHashMap<String, StringBuilder> dataMap = new ConcurrentHashMap<>();
    private int bufferSize = 1024;
    private String localCharset = "UTF-8";
    private SelectionKey selectionKey;

    public Handler(SelectionKey selectionKey){
        Objects.requireNonNull(selectionKey);
        this.selectionKey = selectionKey;
    }

    public Handler(SelectionKey selectionKey, int bufferSize, String localCharset) {
        Objects.requireNonNull(selectionKey);
        this.selectionKey = selectionKey;
        if(bufferSize > 0 ){
            this.bufferSize = bufferSize;
        }

        if(localCharset != null){
            this.localCharset = localCharset;
        }
    }

    public void handleAccept(SelectionKey selectionKey) throws IOException {
        //获取与客户端对应的一个SocketChannel
        SocketChannel socketChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
        socketChannel.configureBlocking(false);
        //将socketChannel注册到selector中(此处简单处理为注册到同一个selector)
        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    public void handleRead(SelectionKey selectionKey) throws IOException {
        //获取socketChannel
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        //循环读取数据
        StringBuilder data = new StringBuilder();
        //清空buffer
        buffer.clear();
        try {
            int len = socketChannel.read(buffer);
            if(len == -1){
                // PROBLEM isen 2019/1/15 为什么没有数据？
                System.out.println("没有数据");
                socketChannel.close();
                return;
            }

            while(len > 0){
                //将buffer转为读状态
                buffer.flip();

                //将buffer中接收到的数据解码后保存到receivedString
//                    String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                String receivedString = new String(buffer.array(), localCharset);
                data.append(receivedString);

                buffer.clear();
                len = socketChannel.read(buffer);
            }
        } catch(Exception e) {
            //一般是客户端因为某种原因终止了,所以关闭socket
            socketChannel.close();
            return;
        }

        System.out.println("receive from client, data=" + data);

        //返回数据给客户端
        String sendString = "received data:" + data;
        buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
        socketChannel.write(buffer);

        //数据可能还不是完整的，先保存在dataMap
        StringBuilder stringBuilder = dataMap.computeIfAbsent(socketChannel.hashCode() + "", StringBuilder::new);
        stringBuilder.append(data);

        // XXX isen 2019/1/15 需要提供一个数据结束标志

        // XXX isen 2019/1/15 看情况关闭，不然读一次就关闭了
        //关闭socket
//            socketChannel.close();
    }

    @Override
    public void run() {
        try{
            if(selectionKey.isAcceptable()) {
                //连接请求
                handleAccept(selectionKey);
            }else if(selectionKey.isReadable()){
                //接收数据
                handleRead(selectionKey);
            }else if(selectionKey.isWritable()){
                //发送数据
            }else if(selectionKey.isConnectable()){
                //可连接
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
